package home.jyong.hakafka.service;

import home.jyong.hakafka.iotEntity.entity.IotEntity;
import home.jyong.hakafka.iotEntity.repository.IotEntityRepository;
import home.jyong.hakafka.mapper.EntityMapper;
import static home.jyong.hakafka.mapper.EntityMapper.mapToIotEntity;
import home.jyong.hakafka.pojo.EntityMessage;
import home.jyong.hakafka.pojo.ThrottlingStatus;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RaspberryPiService {

  private final IotEntityRepository iotEntityRepository;

  public void processRaspberryPiMessage(EntityMessage message) {
    String status = message.getState();
    ThrottlingStatus throttlingStatus = analyzeStatus(status);
    IotEntity entity = mapToIotEntity(message, throttlingStatus.toString());
    iotEntityRepository.save(entity);
  }


  private ThrottlingStatus analyzeStatus(String status) {
    ThrottlingStatus throttlingStatus = new ThrottlingStatus();
    int value = Integer.decode(status);

    throttlingStatus.setUnderVoltage((value & 0b1) != 0);
    throttlingStatus.setFrequencyCapped((value & 0b10) != 0);
    throttlingStatus.setCurrentlyThrottled((value & 0b100) != 0);
    throttlingStatus.setTemperatureLimit((value & 0b1000) != 0);
    throttlingStatus.setUnderVoltageOccurred((value & 0b1_0000_0000_0000_0000) != 0);
    throttlingStatus.setFrequencyCappedOccurred((value & 0b10_0000_0000_0000_0000) != 0);
    throttlingStatus.setThrottlingOccurred((value & 0b100_0000_0000_0000_0000) != 0);
    throttlingStatus.setTemperatureLimitOccurred((value & 0b1000_0000_0000_0000_0000) != 0);

    return throttlingStatus;
  }
}
