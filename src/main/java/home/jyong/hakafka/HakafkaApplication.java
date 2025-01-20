package home.jyong.hakafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HakafkaApplication {

  public static void main(String[] args) {
    SpringApplication.run(HakafkaApplication.class, args);
  }

}
