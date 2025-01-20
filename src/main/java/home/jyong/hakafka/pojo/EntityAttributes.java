package home.jyong.hakafka.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EntityAttributes {
  @JsonProperty("friendly_name")
  private String friendlyName;
}

