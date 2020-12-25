package uok.seng22212.apiserver.repositories.firebase;

import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;
import uok.seng22212.apiserver.models.SensorCategory;
import uok.seng22212.apiserver.repositories.SensorCategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class SensorCategoryRepositoryImpl implements SensorCategoryRepository {

    private final static Firestore firestoreRef = FirebaseConfigurations.getFirestoreReference();

    @Override
    public List<SensorCategory> getAllCategories() throws ExecutionException, InterruptedException {
        try{
            return firestoreRef.collection("SensorCategories")
                    .get().get()
                    .toObjects(SensorCategory.class);
        }catch (Exception e){
            throw e;
        }
    }

}
