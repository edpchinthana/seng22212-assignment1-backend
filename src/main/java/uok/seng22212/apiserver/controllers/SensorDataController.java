package uok.seng22212.apiserver.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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




}
