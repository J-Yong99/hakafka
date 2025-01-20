package home.jyong.hakafka.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EntityContext {
  private String id;

  @JsonProperty("parent_id")
  private String parentId;

  @JsonProperty("user_id")
  private String userId;
}
