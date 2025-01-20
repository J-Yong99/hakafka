package home.jyong.hakafka.iotEntity.repository;

import home.jyong.hakafka.iotEntity.entity.IotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IotEntityRepository extends JpaRepository<IotEntity, Long> {
}
