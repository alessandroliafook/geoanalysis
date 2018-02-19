package GeoAnalysis.Server.repository;

import GeoAnalysis.Server.model.sensor.Sensor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {

  Sensor getById();

  List<Sensor> getByUser();
}
