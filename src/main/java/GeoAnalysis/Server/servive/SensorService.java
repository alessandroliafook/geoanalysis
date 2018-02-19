package GeoAnalysis.Server.servive;

import GeoAnalysis.Server.model.sensor.Record;
import GeoAnalysis.Server.repository.RecordRepository;
import GeoAnalysis.Server.repository.SensorRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import GeoAnalysis.Server.model.sensor.Sensor;

@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    @Autowired
    private RecordRepository recordRepository;

  public Sensor getSensor(Long id) {
    return sensorRepository.findOne(id);
  }

  public Sensor saveSensor(Sensor sensor) {
    return sensorRepository.save(sensor);
  }

  public void deleteSensor(Long id) {
    sensorRepository.delete(id);
  }

  public Sensor updateRecord(Record record, Long id) {

    Sensor sensor = getSensor(id);
    List<Record> records = sensor.getRecords();

    Record lastRecord = records.get(records.size() - 1);

    if(lastRecord.getDate() != record.getDate()) {

      Record newRecord = recordRepository.save(record);
      records.add(newRecord);
    }

    return sensorRepository.save(sensor);
  }

}
