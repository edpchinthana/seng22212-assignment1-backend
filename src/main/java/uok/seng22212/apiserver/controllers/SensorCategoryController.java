package uok.seng22212.apiserver.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.models.SensorCategory;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.services.SensorCategoryService;

import java.util.List;

@RestController
@RequestMapping("api/category")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SensorCategoryController {

    @Autowired
    SensorCategoryService sensorCategoryService;

    private final Logger LOGGER = LoggerFactory.getLogger(SensorCategoryController.class);

    @RequestMapping(value="", method = RequestMethod.GET)
    public ResponseEntity<?> getAllSensorCategories(){
        try{
            List<SensorCategory> sensorCategoryList = sensorCategoryService.getAllSensorCategories();
            return ResponseEntity.status(HttpStatus.OK).body(sensorCategoryList);
        }catch (Exception e){
            LOGGER.error("GET SENSOR CATEGORY  ERROR",e);
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(e.getMessage());
        }
    }
}
