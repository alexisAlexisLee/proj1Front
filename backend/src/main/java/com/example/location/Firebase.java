package com.example.location;

import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

@Service
public class Firebase {

    @PostConstruct
    public void initialization() {
        try {          
            ClassPathResource serviceAccount = new ClassPathResource("./serviceAccountKey.json");
            FileInputStream serviceAccount2 = new FileInputStream("./serviceAccountKey.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount2))
            .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
