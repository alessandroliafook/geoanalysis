package GeoAnalysis.Server.controller;

import GeoAnalysis.Server.model.sensor.Record;
import GeoAnalysis.Server.model.sensor.Sensor;
import GeoAnalysis.Server.servive.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {

  @Autowired
  private SensorService sensorService;

  @GetMapping("/{id}")
  @ResponseBody
  public Sensor getSensor(@PathVariable("id") Long id) {
    return sensorService.getSensor(id);
  }

  @PostMapping
  @ResponseBody
  public Sensor saveSensor(
      @RequestBody Sensor sensor) {
    return sensorService.saveSensor(sensor);
  }

  @DeleteMapping("/{id}")
  public void deleteSensor(@PathVariable("id") Long id) {
    sensorService.deleteSensor(id);
  }

  @PostMapping("/record/{id}")
  @ResponseBody
  public Sensor updateRecord(
      @RequestBody Record record, @PathVariable("id") Long id) {
    return sensorService.updateRecord(record, id);
  }
}
