package uok.seng22212.apiserver.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.models.AlertSubscriber;
import uok.seng22212.apiserver.repositories.AlertSubscriberRepository;
import uok.seng22212.apiserver.services.AlertSubscriberService;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class AlertSubscriberServiceImpl implements AlertSubscriberService {

    @Autowired
    AlertSubscriberRepository alertSubscriberRepository;

    @Override
    public void addSubscriber(AlertSubscriber alertSubscriber) {
        try{
            alertSubscriber.setId(UUID.randomUUID().toString());
            alertSubscriberRepository.addSubscriber(alertSubscriber);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<AlertSubscriber> getAllSubscribers() throws ExecutionException, InterruptedException {
        try{
            return alertSubscriberRepository.getAllSubscribers();
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteSubscriebr(String subscriberId) {
        try{
            alertSubscriberRepository.deleteSubscriber(subscriberId);
        }catch (Exception e){
            throw e;
        }
    }
}
