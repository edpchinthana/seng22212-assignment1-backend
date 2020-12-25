package uok.seng22212.apiserver.controllers;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.services.SensorDataService;



import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/data")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class SensorDataController {

    @Autowired
    SensorDataService sensorDataService;

    private final Logger LOGGER = LoggerFactory.getLogger(SensorDataController.class);

//    @RequestMapping(value="", method = RequestMethod.GET)
//    public ResponseEntity<?> getAllSensorData (){
//        try{
//            List<SensorData> sensorDataList =  sensorDataService.getAllSensorData();
//            return ResponseEntity.status(HttpStatus.OK).build();
//        }catch (Exception e){
//            LOGGER.error("GET ALL SENSOR DATA ERROR",e);
//            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
//        }
//    }
//

//
    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getSensorDataByType(@RequestParam String sensorId, @RequestParam String from, @RequestParam String to){
        try{
            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(from);
            Date date2=new SimpleDateFormat("yyyy-MM-dd").parse(to);
            List<SensorData> sensorDataList = sensorDataService.getSensorDataBySensorId(sensorId, date1, date2);
            System.out.println(from);
            System.out.println(to);
            return ResponseEntity.status(HttpStatus.OK).body(sensorDataList);
        }catch (Exception e){
            LOGGER.error("GET SENSOR DATA BY TYPE ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }


    @RequestMapping(value="/{sensorType}", method = RequestMethod.POST)
    public ResponseEntity<?> addSensorData (@RequestBody List<SensorData> sensorData, @PathVariable("sensorType") SensorType sensorType){
        try{
            sensorDataService.addSensorData(sensorType, sensorData);
            return ResponseEntity.status(HttpStatus.OK).build();
        }catch (Exception e){
            LOGGER.error("ADD SENSOR DATA ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }




}
