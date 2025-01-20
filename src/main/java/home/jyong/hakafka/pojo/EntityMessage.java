package home.jyong.hakafka.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class EntityMessage {
  @JsonProperty("entity_id")
  private String entityId;

  private String state;

  private EntityAttributes attributes;

  @JsonProperty("last_changed")
  private String lastChanged;

  @JsonProperty("last_reported")
  private String lastReported;

  @JsonProperty("last_updated")
  private String lastUpdated;

  private EntityContext context;
}
