package uok.seng22212.apiserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.repositories.SensorDataRepository;
import uok.seng22212.apiserver.services.SensorDataService;

import java.util.List;

@Service
public class SensorDataServiceImpl implements SensorDataService {

    @Autowired
    private SensorDataRepository repository;

    @Override
    public List<SensorData> getAllSensorData() {
        try{
            return repository.getAllSensorData();
        }catch(Exception e){
            throw e;
        }
    }


}
