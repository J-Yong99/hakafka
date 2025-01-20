package home.jyong.hakafka.pojo;

import lombok.Data;

@Data
public class ThrottlingStatus {

  private boolean underVoltage;
  private boolean frequencyCapped;
  private boolean currentlyThrottled;
  private boolean temperatureLimit;

  private boolean underVoltageOccurred;
  private boolean frequencyCappedOccurred;
  private boolean throttlingOccurred;
  private boolean temperatureLimitOccurred;

  @Override
  public String toString() {
    return "ThrottlingStatus{" +
      "underVoltage=" + underVoltage +
      ", frequencyCapped=" + frequencyCapped +
      ", currentlyThrottled=" + currentlyThrottled +
      ", temperatureLimit=" + temperatureLimit +
      ", underVoltageOccurred=" + underVoltageOccurred +
      ", frequencyCappedOccurred=" + frequencyCappedOccurred +
      ", throttlingOccurred=" + throttlingOccurred +
      ", temperatureLimitOccurred=" + temperatureLimitOccurred +
      '}';
  }
}
