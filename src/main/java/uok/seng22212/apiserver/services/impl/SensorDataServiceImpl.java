package uok.seng22212.apiserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.alertSystem.AlertSystem;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetector;
import uok.seng22212.apiserver.criticalValueDetectors.CriticalValueDetectorFactory;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.repositories.SensorDataRepository;
import uok.seng22212.apiserver.services.SensorDataService;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    private SensorDataRepository repository;

    @Autowired
    private CriticalValueDetectorFactory criticalValueDetectorFactory;

    @Autowired
    private AlertSystem alertSystem;

    @Override
    public void addSensorData(SensorType sensorType, List<SensorData> sensorDataList) throws Exception {
        repository.addSensorData(sensorType, sensorDataList);
        for(SensorData sensorData : sensorDataList){
            CriticalValueDetector criticalValueDetector = criticalValueDetectorFactory.getInstance(sensorData);
            if(criticalValueDetector.detect(sensorData)){
                System.out.println("send alerts");
                alertSystem.sendAlert(sensorData);
            }
        }

    }

    @Override
    public List<SensorData> getSensorDataBySensorId(String sensorId, Date from, Date to) throws ExecutionException, InterruptedException {
        try{
            return repository.getSensorDataBySensorId(sensorId,from, to);
        }catch (Exception e){
            throw e;
        }
    }









}
