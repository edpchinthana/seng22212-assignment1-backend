package uok.seng22212.apiserver.repositories.firebase;


import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.AlertSubscriber;
import uok.seng22212.apiserver.repositories.AlertSubscriberRepository;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class AlertSubscriberRepositoryImpl implements AlertSubscriberRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();

    @Override
    public void addSubscriber(AlertSubscriber alertSubscriber) {
        try{
            firestoreRef.collection("AlertSubscribers").document(alertSubscriber.getId()).set(alertSubscriber);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public List<AlertSubscriber> getAllSubscribers() throws ExecutionException, InterruptedException {
        try{
            return firestoreRef.collection("AlertSubscribers").get().get().toObjects(AlertSubscriber.class);
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public void deleteSubscriber(String subscriberId) {
        try{
            firestoreRef.collection("AlertSubscribers").document(subscriberId).delete();
        }catch (Exception e){
            throw e;
        }
    }
}
