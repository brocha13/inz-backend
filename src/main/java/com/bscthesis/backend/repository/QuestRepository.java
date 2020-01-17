package com.bscthesis.backend.repository;

import com.bscthesis.backend.model.Quest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestRepository extends MongoRepository<Quest, String> {
}
