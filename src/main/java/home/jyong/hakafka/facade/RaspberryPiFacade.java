package home.jyong.hakafka.facade;

import home.jyong.hakafka.pojo.EntityContext;
import home.jyong.hakafka.pojo.EntityMessage;
import home.jyong.hakafka.service.GeneralEntityMessageService;
import home.jyong.hakafka.service.RaspberryPiService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RaspberryPiFacade {

  private final RaspberryPiService raspberryPiService;
  private final GeneralEntityMessageService generalEntityMessageService;

  public void handleRaspberryPiMessage(EntityMessage message) {
    if (isRaspberryPiRelated(message)) {
      raspberryPiService.processRaspberryPiMessage(message);
    } else {
      generalEntityMessageService.saveMessageToDatabase(message);
    }
  }

  private boolean isRaspberryPiRelated(EntityMessage message) {
    return message.getEntityId().startsWith("raspberry_pi_");
  }
}
