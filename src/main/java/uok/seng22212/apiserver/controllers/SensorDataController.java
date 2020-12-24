package uok.seng22212.apiserver.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/data")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class SensorDataController {

    @Autowired
    SensorDataService sensorDataService;

    private final Logger LOGGER = LoggerFactory.getLogger(SensorDataController.class);

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSensorData (){
        try{
            List<SensorData> sensorDataList =  sensorDataService.getAllSensorData();
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("GET ALL SENSOR DATA ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }


    @RequestMapping(value="/type", method = RequestMethod.GET)
    public ResponseEntity<?> getSensorDataByType(@RequestParam String type, @RequestParam String from, @RequestParam String to){
        try{
            List<SensorData> sensorDataList = sensorDataService.getSensorDataByType(type, from, to);
            return ResponseEntity.status(HttpStatus.OK).body(sensorDataList);
        }catch (Exception e){
            LOGGER.error("GET SENSOR DATA BY TYPE ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }



}
