package uok.seng22212.apiserver.alertSystem.emailSender;

import org.springframework.stereotype.Service;
import uok.seng22212.apiserver.models.Alert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmailFormatterImpl implements EmailFormatter{

    @Override
    public String getEmailSubject() {
        StringBuilder subject = new StringBuilder();
        subject.append("Alert! - Monitor Sensor Data Management System");
        return subject.toString();
    }

    @Override
    public String getEmailBody(Alert alert){
        Date dateTime = new Date(alert.getSensorData().getCapturedDate().getTime());
        String date = new SimpleDateFormat("dd-MM-yyyy").format(dateTime);
        String time = new SimpleDateFormat("HH:mm").format(dateTime);


        StringBuilder body = new StringBuilder();
        body.append("Monitor Sensor Data Management System");
        body.append("\n------------------------------------");
        body.append("\n"+alert.getTitle());
        body.append("\n"+alert.getCause());

        body.append("\n\n--Sensor Details--");
        body.append("\nSensor Type : "+alert.getSensorData().getType());
        body.append("\nSensor Id : "+alert.getSensorData().getId());
        body.append("\nSensor Threshold : "+alert.getSensorData().getThreshold()+alert.getSensorData().getUnit());
        body.append("\nRecorded value : "+alert.getSensorData().getDataValue()+alert.getSensorData().getUnit());
        body.append("\nRecorded At : "+date+" "+time);
        body.append("\n\n\n-------------");
        body.append("This is an auto generated email. Please do not reply.");
        return body.toString();
    }
}