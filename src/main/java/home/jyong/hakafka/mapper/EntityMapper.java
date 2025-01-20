package home.jyong.hakafka.mapper;

import home.jyong.hakafka.iotEntity.entity.IotEntity;
import home.jyong.hakafka.pojo.EntityMessage;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EntityMapper {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ISO_DATE_TIME;

    public static IotEntity mapToIotEntity(EntityMessage message, String... ignoredFields) {
        return IotEntity.builder()
            .entityId(message.getEntityId())
            .state(message.getState())
            .attributes(
                IotEntity.Attributes.builder()
                    .friendlyName(message.getAttributes() != null ? message.getAttributes().getFriendlyName() : null)
                    .build()
            )
            .lastChanged(parseLocalDateTime(message.getLastChanged()))
            .lastReported(parseLocalDateTime(message.getLastReported()))
            .lastUpdated(parseLocalDateTime(message.getLastUpdated()))
            .context(
                IotEntity.Context.builder()
                    .id(message.getContext() != null ? message.getContext().getId() : null)
                    .parentId(message.getContext() != null ? message.getContext().getParentId() : null)
                    .userId(message.getContext() != null ? message.getContext().getUserId() : null)
                    .build()
            )
          .throttlingStatus(ignoredFields.length != 0 ? ignoredFields[0] : null)
            .build();
    }

    private static LocalDateTime parseLocalDateTime(String dateTime) {
        return dateTime != null ? LocalDateTime.parse(dateTime, DATE_TIME_FORMATTER) : null;
    }
}