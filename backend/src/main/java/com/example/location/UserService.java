package com.example.location;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.WriteResult;
import com.google.api.core.ApiFuture;

@Service
public class UserService {

    // @Autowired
    // Firebase database;

    private static final String COLLECTION = "accounts";

    // public boolean existsUser(String username) throws InterruptedException, ExecutionException {
    //     CollectionReference col = database.collection(COLLECTION);
    //     ApiFuture<QuerySnapshot> entry = col.whereEqualTo("username", username).get();
    //     return (entry.get().getDocuments().size()>0);
    // }

    // public String getPasswordByUsername(String username) throws InterruptedException, ExecutionException {
    //     CollectionReference col = database.collection(COLLECTION);
    //     ApiFuture<QuerySnapshot> entry = col.whereEqualTo("username", username).get();
    //     return entry.get().getDocuments().get(0).get("password").toString();
    // }

    public String createUser(User user) throws InterruptedException, ExecutionException {
        Firestore database = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> res = database.collection(COLLECTION).document(user.getUsername()).set(user);
        return res.get().getUpdateTime().toString();
    }
}
