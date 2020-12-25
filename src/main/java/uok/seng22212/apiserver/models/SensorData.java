package uok.seng22212.apiserver.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorData implements Serializable {

    private String id;
    private String sensorId;
    private Timestamp capturedDate;
    private double threshold;
    private double dataValue;
    private SensorType type;
    private String unit;


    public SensorType getType() {
        return type;
    }

    public void setType(SensorType type) {
        this.type = type;
    }

    public double getThreshold() {
        return threshold;
    }

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public Timestamp getCapturedDate() {
        return capturedDate;
    }

    public void setCapturedDate(Timestamp capturedDate) {
        this.capturedDate = capturedDate;
    }

    public double getDataValue() {
        return dataValue;
    }

    public void setDataValue(double dataValue) {
        this.dataValue = dataValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void convertMapToSensorData(Map<String, Object> dataMap){
        SensorData sensorData = new SensorData();

        this.id = dataMap.get("id").toString();
        this.sensorId = dataMap.get("sensorId").toString();
        this.dataValue = Double.parseDouble(dataMap.get("dataValue").toString());
        this.threshold = Double.parseDouble(dataMap.get("threshold").toString());
        this.type = SensorType.valueOf(dataMap.get("type").toString());
        this.unit = dataMap.get("unit").toString();

        com.google.cloud.Timestamp googleTimestamp = com.google.cloud.Timestamp.parseTimestamp(dataMap.get("capturedDate").toString());
        Date date = googleTimestamp.toDate();
        java.sql.Timestamp timestamp = new java.sql.Timestamp(date.getTime());
        this.capturedDate = timestamp;
    }
}
