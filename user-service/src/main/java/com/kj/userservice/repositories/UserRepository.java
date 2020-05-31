package com.kj.userservice.repositories;

import com.kj.userservice.models.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
//    User save(User user);
//    User findByUsername(String username);
}
