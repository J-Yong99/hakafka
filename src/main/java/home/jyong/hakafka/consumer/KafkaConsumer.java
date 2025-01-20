package home.jyong.hakafka.consumer;

import home.jyong.hakafka.facade.RaspberryPiFacade;
import home.jyong.hakafka.iotEntity.repository.IotEntityRepository;
import home.jyong.hakafka.pojo.EntityContext;
import home.jyong.hakafka.pojo.EntityMessage;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {

    private final RaspberryPiFacade raspberryPiFacade;

    @KafkaListener(topics = "home_assistant_test_jy", groupId = "spring-group")
    public void listen(EntityMessage message) {
        raspberryPiFacade.handleRaspberryPiMessage(message);
    }
}
