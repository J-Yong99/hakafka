package home.jyong.hakafka.service;

import home.jyong.hakafka.iotEntity.entity.IotEntity;
import home.jyong.hakafka.iotEntity.repository.IotEntityRepository;
import home.jyong.hakafka.mapper.EntityMapper;
import home.jyong.hakafka.pojo.EntityMessage;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GeneralEntityMessageService {

  private final IotEntityRepository iotEntityRepository;

  public void saveMessageToDatabase(EntityMessage message) {
    IotEntity entity = EntityMapper.mapToIotEntity(message);
    iotEntityRepository.save(entity);
    System.out.println("Message saved to database: " + message);
  }

}
