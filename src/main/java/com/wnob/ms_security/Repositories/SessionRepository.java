package com.wnob.ms_security.Repositories;

import com.wnob.ms_security.Models.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface SessionRepository extends MongoRepository<Session, String> {
    @Query("{'theUser.$id': ObjectId(?0),'token2FA': ?1}")
    Session getSessionbyUserId(String userId, int token2FA);
}
