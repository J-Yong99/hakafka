package home.jyong.hakafka.feign;

import home.jyong.hakafka.config.FeignClientConfig;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "iot",
        url = "${server.iot.domain}",
        configuration = FeignClientConfig.class)
public interface IotClient {
}
