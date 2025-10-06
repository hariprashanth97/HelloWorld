package com.example.helloworld.repository;

import com.example.helloworld.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    // Fetch the latest message (highest ID)
    Optional<Message> findTopByOrderByIdDesc();
}

