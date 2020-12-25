package uok.seng22212.apiserver.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class FirebaseConfigurations {

    public static void initializeFirebase() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("/home/pasindu/Downloads/seng22212-assignment-1-firebase-adminsdk-agh2y-62b0ce27a3.json");
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();
                FirebaseApp.initializeApp(options);

    }

    public static Firestore getFirestoreReference(){
        return FirestoreClient.getFirestore();
    }



}
