package org.project.gestiontournoisjeuxvideo.service;

import org.project.gestiontournoisjeuxvideo.entity.Message;
import org.project.gestiontournoisjeuxvideo.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> getAll(){
        return messageRepository.findAll();
    }

    public Message getById(int id){
        return messageRepository.findById(id).orElse(null);
    }

    public Message save(Message message){
        return messageRepository.save(message);
    }

    public void delete(Message message){
        messageRepository.delete(message);
    }
}
