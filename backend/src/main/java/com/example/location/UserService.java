package com.example.location;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.*;
import com.google.api.core.ApiFuture;

import org.slf4j.Logger; 
import org.slf4j.LoggerFactory; 

@Service
public class UserService {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private static final String COLLECTION = "accounts";

    public boolean existsUser(String username) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference col = db.collection(COLLECTION);
        ApiFuture<QuerySnapshot> entry = col.whereEqualTo("username", username).get();
        return (entry.get().getDocuments().size()>0);
    }

    public String getPasswordByUsername(String username) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        CollectionReference col = db.collection(COLLECTION);
        ApiFuture<QuerySnapshot> entry = col.whereEqualTo("username", username).get();
        return entry.get().getDocuments().get(0).get("password").toString();
    }

    public String createUser(User user) throws InterruptedException, ExecutionException {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> res = db.collection(COLLECTION).document(user.getUsername()).set(user);
        return res.get().getUpdateTime().toString();
    }
}
