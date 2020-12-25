package uok.seng22212.apiserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetector;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetectorFactory;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.repositories.SensorDataRepository;
import uok.seng22212.apiserver.services.SensorDataService;

import java.util.List;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    private SensorDataRepository repository;

    @Autowired
    private CriticalValueDetectorFactory criticalValueDetectorFactory;


    @Override
    public void addSensorData(SensorType sensorType, List<SensorData> sensorDataList) {

        for(SensorData sensorData : sensorDataList){
            CriticalValueDetector criticalValueDetector = criticalValueDetectorFactory.getInstance(sensorData);
            if(criticalValueDetector.detect(sensorData)){
                System.out.println("send notifications");
            }
        }
        repository.addSensorData(sensorType, sensorDataList);
    }

//    @Override
//    public List<SensorData> getAllSensorData() {
//        try{
//            return repository.getAllSensorData();
//        }catch(Exception e){
//            throw e;
//        }
//    }
//
//
//    @Override
//    public List<SensorData> getSensorDataByType(String type, String from, String to) {
//        try{
//            return repository.getSensorDataByType(type, from, to);
//        }catch (Exception e){
//            throw e;
//        }
//    }







}
