package uok.seng22212.apiserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorType;
import  uok.seng22212.apiserver.services.SensorService;

import java.util.List;


@RestController
@RequestMapping("api/sensor")
@CrossOrigin(origins = "*", allowedHeaders = "*")


public class SensorController {

    @Autowired
    SensorService sensorService;

    private final Logger LOGGER = LoggerFactory.getLogger(SensorController.class);


        @RequestMapping(value="/{sensorId}", method = RequestMethod.GET)
    public ResponseEntity<?> getSensor(@PathVariable("sensorId") String id){
        try{
            Sensor sensor =  sensorService.getSensorById(id);
            System.out.println("get sensor "+sensor.getTitle());
            return ResponseEntity.status(HttpStatus.OK).body(sensor);
        }catch (Exception e){
            LOGGER.error("GET SENSOR  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getSensor(@RequestParam SensorType sensorType){
        try{
            List<Sensor> sensorList =  sensorService.getSensorsBySensorType(sensorType);
            return ResponseEntity.status(HttpStatus.OK).body(sensorList);
        }catch (Exception e){
            LOGGER.error("GET SENSOR BY TYPE  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }


    @RequestMapping(value="", method = RequestMethod.POST)
    public ResponseEntity<?> addSensor (@RequestBody List<Sensor> sensor){
        try{
            sensorService.addSensor(sensor);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("ADD SENSOR ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @RequestMapping(value="", method = RequestMethod.PUT)
    public ResponseEntity<?> updateSensor(@RequestBody Sensor sensor){
        try{
            sensorService.updateSensor(sensor);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("UPDATE SENSOR ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }

    @RequestMapping(value="", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteSensor(@RequestParam String sensorId){
            try{
                sensorService.deleteSensor(sensorId);
                return ResponseEntity.status(HttpStatus.OK).build();
            }catch (Exception e){
                LOGGER.error("DELETE SENSOR ERROR",e);
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
            }
    }


}
