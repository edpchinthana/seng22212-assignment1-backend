package uok.seng22212.apiserver.alertSystem.impl;

import uok.seng22212.apiserver.alertSystem.AlertSystem;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.models.SensorData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class AlertSystemImpl implements AlertSystem {

    @Override
    public void sendAlert(SensorData sensorData) {

        Alert alert = alertMessageGenerator(sensorData);

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
