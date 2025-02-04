package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Message m WHERE m.messageId = ?1")
    int deleteMessageById(Integer messageId);
    
    @Query("SELECT m FROM Message m WHERE m.postedBy = ?1")
    List<Message> findAllByPostedBy(Integer postedBy);

}
