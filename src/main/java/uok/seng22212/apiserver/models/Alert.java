package uok.seng22212.apiserver.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {

    private String id;
    private String title;
    private SensorData sensorData;
    private String cause;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SensorData getSensorData() {
        return sensorData;
    }

    public void setSensorData(SensorData sensorData) {
        this.sensorData = sensorData;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public void convertMapToAlert(Map<String, Object> dataMap){
        this.id = dataMap.get("id").toString();
        this.title = dataMap.get("title").toString();
        this.cause = dataMap.get("cause").toString();
        SensorData sensorData = new SensorData();
        sensorData.convertMapToSensorData((Map<String, Object>) dataMap.get("sensorData"));
        this.sensorData = sensorData;
    }
}
