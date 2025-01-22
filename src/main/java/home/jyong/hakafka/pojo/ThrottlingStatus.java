package home.jyong.hakafka.pojo;

import lombok.Data;

@Data
public class ThrottlingStatus {

  // 전압 부족 상태(현재 전압 부족 발생).
  private boolean underVoltage;

  // ARM CPU 주파수 제한(과열로 인해 성능 제한).
  private boolean frequencyCapped;

  // 현재 성능 제한(전압 부족 또는 과열).
  private boolean currentlyThrottled;

  // 과열
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
