package com.example.demo.repository;

import com.example.demo.model.InputMessage;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MessageRepository extends JpaRepository<InputMessage, Long> {
}
