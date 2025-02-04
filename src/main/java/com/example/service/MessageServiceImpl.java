package com.example.service;

import com.example.entity.Message;
import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    @Override
    public Message getMessageById(Integer id) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        return optionalMessage.orElse(null);
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message updateMessage(Integer id, Message messageUpdate) {
        Optional<Message> optionalMessage = messageRepository.findById(id);
        if (optionalMessage.isPresent()) {
            Message existingMessage = optionalMessage.get();
            // Validate and update messageText
            existingMessage.setMessageText(messageUpdate.getMessageText());
            return messageRepository.save(existingMessage);
        }
        return null;
    }

    @Override
    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }

    @Override
    public Message createMessage(Message message) {
        // Validation and business logic can be added here
        return messageRepository.save(message);
    }

    @Override
    public int deleteMessageById(Integer messageId) {
        return messageRepository.deleteMessageById(messageId);
    }

    @Override
    public List<Message> getAllMessagesForUser(Integer userId) {
        return messageRepository.findAllByPostedBy(userId);
    }

}