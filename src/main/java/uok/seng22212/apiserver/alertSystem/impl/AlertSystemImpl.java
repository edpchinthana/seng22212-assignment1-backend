package uok.seng22212.apiserver.alertSystem.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.alertSystem.AlertSystem;
import uok.seng22212.apiserver.alertSystem.emailSender.EmailSender;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.AlertSubscriber;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.repositories.AlertRepository;
import uok.seng22212.apiserver.services.AlertSubscriberService;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@Service
public class AlertSystemImpl implements AlertSystem {

    @Autowired
    AlertSubscriberService alertSubscriberService;

    @Autowired
    EmailSender emailSender;

    @Autowired
    AlertRepository alertRepository;

    @Override
    public void sendAlert(SensorData sensorData) throws ExecutionException, InterruptedException, MessagingException {

        try{
            Alert alert = alertMessageGenerator(sensorData);
            List<AlertSubscriber> alertSubscriberList = alertSubscriberService.getAllSubscribers();
            alertRepository.addAlert(alert);
            emailSender.sendEmails(alert, alertSubscriberList);

        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Alert> getAlertHistory(String sensorId) throws ExecutionException, InterruptedException {
        try{
            return alertRepository.getAlertHistory(sensorId);
        }catch (Exception e){
            throw e;
        }
    }


    private Alert alertMessageGenerator(SensorData sensorData){

        Date dateTime = new Date(sensorData.getCapturedDate().getTime());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(dateTime);
        String time = new SimpleDateFormat("HH:mm").format(dateTime);

        Alert alert = new Alert();
        alert.setId(UUID.randomUUID().toString());
        alert.setTitle(sensorData.getType()+" sensor exceeded the threshold value ");
        alert.setCause(sensorData.getType()+" sensor (id "+sensorData.getId()+") reading("
                +sensorData.getDataValue()+sensorData.getUnit()+") exceeded the threshold value("
                +sensorData.getThreshold()+sensorData.getUnit()+") on "+date+" at "+time+". "
        );
        alert.setSensorData(sensorData);

        return alert;
    }
}
