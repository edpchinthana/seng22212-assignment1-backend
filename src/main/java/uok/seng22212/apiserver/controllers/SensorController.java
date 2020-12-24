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

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getSensor(){
        try{
            List<Sensor> sensorList =  sensorService.getSensor();
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("GET SENSOR  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }


    @RequestMapping(value="/{sensorType}", method = RequestMethod.POST)
    public ResponseEntity<?> addSensor (@RequestBody List<Sensor> sensor, @PathVariable("sensorType") SensorType sensorType){
        try{
            sensorService.addSensor(sensorType, sensor);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("ADD SENSOR ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }








}
