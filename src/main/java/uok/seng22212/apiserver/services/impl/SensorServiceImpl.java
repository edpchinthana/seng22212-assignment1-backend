package uok.seng22212.apiserver.services.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.controllers.SensorDataController;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.repositories.SensorDataRepository;
import uok.seng22212.apiserver.repositories.SensorRepository;

import uok.seng22212.apiserver.services.SensorService;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService{

    @Autowired
    private SensorRepository repository;


    @Override
    public void addSensor(SensorType sensorType, List<SensorData> sensorData) {
        repository.addSensor(sensorType, sensorData);
    }

    @Override
    public List<SensorData> getSensor() {
        try{
            return repository.getSensor();
        }catch(Exception e){
            throw e;
        }
    }






}
