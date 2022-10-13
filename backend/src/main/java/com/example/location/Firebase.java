package com.example.location;

import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;
import java.io.FileInputStream;

import javax.annotation.PostConstruct;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.FirebaseApp;

import org.json.JSONObject;
import java.io.*;

@Service
public class Firebase {

    @PostConstruct
    public void initialization() {
        try {          

            // JSONObject json = new JSONObject();
            // json.put("type", "service_account");
            // json.put("project_id", "location-search-54492");
            // json.put("private_key_id", "a8c8a7b4a316c98da4c2c6432f66327b4857991e");
            // json.put("private_key", "-----BEGIN PRIVATE KEY-----\nMIIEugIBADANBgkqhkiG9w0BAQEFAASCBKQwggSgAgEAAoIBAQCE2E5ocNrfLvR1\naRyhXu2cYYYjPQNQy/42/Hr5XcFDB7dMhuj6BFBg8/iAxRL9gOBGZpsGzKjsajDc\nutgcgI2HTga2xyO18cI7CMTo4ORTo9/gp9FiJujGoHR49s0VWYJYCaCxJc4UbcAr\nJ7EPrubzJ0c2pnF+Vxzw/BHwWUP91BKH3vZVWwJKFiTYsT/QQFRFLj39ztMTFaa8\nCr4USaKcMAWmm1/6ZxXXgJfzHYE1wLzBe7ECuHGbCgwE4nyTLiQTlqvg7ryJ36dz\n+j+9PXgThe8KxYl1wzEGWxiomJ5hqmq00gokvoRPkKgNGmL7qoL52zoPRUSnqMaI\nwHmubncvAgMBAAECgf9CSlNquhp+LpE29+jUS0cVUq3gfF7UewIXTTj3nL9vdYym\nLnqrDoGMSIpn2KAFzRbYn0/z98FsioNLHjlLT5uoXied8j11ut0XbFUz8OneLcXx\nNYsDLvPCfNuXLqnFF72MHcBrrfoQxAjrTnk3SyHg0TjdRPpdg4DLRHngtrW8hrXI\nRoy3qRdZiitvUh8qlxiGj1lFJQuHbjthfEdjGoJljL1I/sRNv28cjU5fE8OWWiel\nIk1WiD9y6E8AHr2KCjV2PixvLIGQZoXpfWHnx0HWGb41KayCpBWrtYe3LFJ7Yp9w\nOhQD71zl2umjhCzLD99tlK37rcGalPz7oyCeF5kCgYEAu7b6TwMdjG5S0jfOr8Lu\nhun70K+VXYYP4SKWGt5P2R3wi5pppfw3EyQczY88TJIeXilNgDS4EfBdJo9RX+Cl\nGAv3FAM8buvEJ9HZTxwmTYl+0+V3MIhu5an+WqMCNpm/UPTEZadHzaNDow8dbsoQ\nqjC0/MhFabsVoPBnUCXHmykCgYEAtSuNa2ZVHZlhfRXxDwyBxTdMaDHLXUCQxYkg\n2gwKx8TUA5L1eK+CJhsS972PEuC/k8T+BLhKOr/8zBaC1rl7r5BrkE2hl/+P2CEQ\nLZU6t7pzbhdDL5iWCmpnlnXHX3RLnoP88Sgu1jASOoeKoK28145PFUkgKR2QnRlX\nYPuyopcCgYAo0YouokPLpLXXxpDoQWAy8DB02amGM7/COg4f+5WrZcpH4ST2Fhk3\nzVOCE5KOJ/v4h8y1g0E/jWAEIYgVbDkaOIfazzVV/WijLAuwGzPtCmgM1coMQK60\nvDl2Jho2G0qx5PfMDwsbGVR84a2JyODE0WCZ00bczfTPEVe14vE7uQKBgGgeP4gZ\np5D7NSvOEFu1tF7DCQZYl6dgE9Nym460nP1yAOaM7sYNF58OsDfwmOkggPlLnTDZ\nOM/Kxl4EEe2Va5/aP/cOpm/UT7bGSaXovXYZkX0ToWkZKCGURTQTPCF/lHXlJNjz\nXvd5aQB6JRFyx7SZ9JknDXSTqSigB7eU73TBAoGABKOiQHvwNJKBs1hVH/oecxkQ\n5sMl+3yJj4UrRAlekFbZ9p3/+bA6fcKHQULhfar905IvsTh2JX4pbbqrGqHnlbDK\nT48U9SuupscNRuFSPisWiLjwWThuzLiYtJO3zfrms75aWD6SsCsHn5dhZH49T5Pj\nQQpsXSsW/JH/eRJ0qko=\n-----END PRIVATE KEY-----\n");
            // json.put("client_email", "firebase-adminsdk-9dpn6@location-search-54492.iam.gserviceaccount.com");
            // json.put("client_id", "109556962192967668712");
            // json.put("auth_uri", "https,//accounts.google.com/o/oauth2/auth");
            // json.put("token_uri", "https,//oauth2.googleapis.com/token");
            // json.put("auth_provider_x509_cert_url", "https,//www.googleapis.com/oauth2/v1/certs");
            // json.put("client_x509_cert_url", "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-9dpn6%40location-search-54492.iam.gserviceaccount.com");
     
            // String str = json.toString();
            // InputStream serviceAccount3 = new ByteArrayInputStream(str.getBytes()); 

            // ClassPathResource serviceAccount = new ClassPathResource("./serviceAccountKey.json");
            FileInputStream serviceAccount2 = new FileInputStream("src/main/java/com/example/location/serviceAccountKey.json");
            FirebaseOptions options = new FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount2))
            .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
