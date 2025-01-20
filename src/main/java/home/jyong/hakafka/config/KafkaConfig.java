package home.jyong.hakafka.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;

@EnableKafka
@Configuration
public class KafkaConfig {

  @Bean
  public StringJsonMessageConverter jsonMessageConverter() {
    return new StringJsonMessageConverter();
  }
}
