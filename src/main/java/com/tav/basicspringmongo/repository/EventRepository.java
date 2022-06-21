package com.tav.basicspringmongo.repository;

import com.tav.basicspringmongo.entities.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
}
