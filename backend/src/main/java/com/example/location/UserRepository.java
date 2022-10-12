package com.example.location;

import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface UserRepository extends FirestoreReactiveRepository<User> {

    Flux<User> findByUsername(String username);
}
