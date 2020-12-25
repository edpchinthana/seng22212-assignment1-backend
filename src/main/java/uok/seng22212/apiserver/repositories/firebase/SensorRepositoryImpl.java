package uok.seng22212.apiserver.repositories.firebase;

import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.Sensor;
import uok.seng22212.apiserver.repositories.SensorRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class SensorRepositoryImpl implements SensorRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();

    @Override
    public List<Sensor> getSensors() {
        return null;
    }

    @Override
    public Sensor getSensorById(String id) throws ExecutionException, InterruptedException {
        try{
            DocumentSnapshot doc = firestoreRef.collection("Sensors").document(id).get().get();
            return doc.toObject(Sensor.class);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void addSensor(List<Sensor> sensorList) {
        try{
            for (Sensor sensor : sensorList ){
                firestoreRef.collection("Sensors").document(sensor.getId()).set(sensor);
            }
        }catch (Exception e){
            throw e;
        }
    }
}
