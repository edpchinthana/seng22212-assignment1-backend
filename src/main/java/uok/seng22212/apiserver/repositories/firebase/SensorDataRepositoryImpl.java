package uok.seng22212.apiserver.repositories.firebase;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.*;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.repositories.SensorDataRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class SensorDataRepositoryImpl implements SensorDataRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();
    @Override
    public void addSensorData(SensorType sensorType, List<SensorData> sensorDataList) {
            try{
                CollectionReference ref = firestoreRef.collection("Sensors");
                       for(SensorData sensorData:sensorDataList){
                           ref.document(sensorData.getSensorId())
                                   .collection("data")
                                   .document(sensorData.getId())
                                   .set(sensorData);
                       }
            }catch (Exception e){
                throw e;
            }
    }

    @Override
    public List<SensorData> getSensorDataBySensorId(String sensorId, Date from, Date to) throws ExecutionException, InterruptedException {
        try{
            Query query = firestoreRef.collection("Sensors")
                    .document(sensorId).collection("data")
                    .whereGreaterThan("capturedDate",from)
                    .whereLessThanOrEqualTo("capturedDate", to);

            ApiFuture<QuerySnapshot> querySnapshot = query.get();
            List<SensorData> sensorDataList = new ArrayList<>();

            for(QueryDocumentSnapshot doc: querySnapshot.get().getDocuments()){
                SensorData sensorData = new SensorData();
                sensorData.convertMapToSensorData(doc.getData());
                sensorDataList.add(sensorData);
            }

            return sensorDataList;
        }catch (Exception e){
            throw e;
        }
    }
}
