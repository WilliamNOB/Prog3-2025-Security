package com.wnob.ms_security.Repositories;

import com.wnob.ms_security.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
