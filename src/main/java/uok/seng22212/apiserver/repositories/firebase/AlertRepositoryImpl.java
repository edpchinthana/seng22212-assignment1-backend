package uok.seng22212.apiserver.repositories.firebase;

import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.Alert;
import uok.seng22212.apiserver.repositories.AlertRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class AlertRepositoryImpl implements AlertRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();

    @Override
    public void addAlert(Alert alert) {
        try{
            firestoreRef.collection("AlertHistory").document(alert.getId()).set(alert);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<Alert> getAlertHistory(String sensorId) throws ExecutionException, InterruptedException {
        List<Alert> alertList = new ArrayList<Alert>();

        List<QueryDocumentSnapshot> queryDocumentSnapshots = firestoreRef.collection("AlertHistory").whereEqualTo("sensorData.sensorId", sensorId).get().get().getDocuments();
        for(QueryDocumentSnapshot doc: queryDocumentSnapshots){
            Alert alert = new Alert();
            alert.convertMapToAlert(doc.getData());
            alertList.add(alert);
        }
        return alertList;
    }
}
