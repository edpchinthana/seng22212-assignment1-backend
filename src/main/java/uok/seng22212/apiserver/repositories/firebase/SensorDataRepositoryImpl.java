package uok.seng22212.apiserver.repositories.firebase;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.SensorData;
import uok.seng22212.apiserver.models.SensorType;
import uok.seng22212.apiserver.repositories.SensorDataRepository;

import java.util.List;

@Repository
public class SensorDataRepositoryImpl implements SensorDataRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();
    @Override
    public void addSensorData(SensorType sensorType, List<SensorData> sensorDataList) {
            try{
                CollectionReference ref = firestoreRef.collection(sensorType.toString());
                       for(SensorData sensorData:sensorDataList){
                           ref.document(sensorData.getSensorId())
                                   .collection("SensorData")
                                   .document(sensorData.getId())
                                   .set(sensorData);
                       }
            }catch (Exception e){
                throw e;
            }
    }
}
