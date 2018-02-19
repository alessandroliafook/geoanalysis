package GeoAnalysis.Server.repository;

import GeoAnalysis.Server.model.sensor.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long>{

}
