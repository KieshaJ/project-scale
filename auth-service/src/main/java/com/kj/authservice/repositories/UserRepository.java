package com.kj.authservice.repositories;

import com.kj.authservice.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
    User save(User user);
    User findByUsername(String username);
}
