/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Messages;
import com.misiontic.ciclo3.ciclo3.repository.MessageRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laurita
 */
@Service
public class MessageService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private MessageRepository messageRepository;
    

    //va a retornar una lista
    public List<Messages> getAll(){
	return messageRepository.getAll();
    }
    


    //get para obtener una habitacion especifica
    //servicio
    public Optional<Messages> getMessage(int id){
	return messageRepository.getMessage(id);
    }
    

    //guardar un registro de habitacion 
    public Messages save(Messages m){
        if(m.getIdMessage() == null){
            return messageRepository.save(m);
        }else{
            Optional<Messages> evt=messageRepository.getMessage(m.getIdMessage());
            if(evt.isEmpty()){
                return messageRepository.save(m);
            }else{
                return messageRepository.save(m);
            }
        }
    }
    
    public Messages update (Messages messages){
        if(messages.getIdMessage()!=null){
            Optional<Messages> c=messageRepository.getMessage(messages.getIdMessage());
            if(!c.isEmpty()){
                
                if(messages.getMessageText()!=null){
                    c.get().setMessageText(messages.getMessageText());
                }
                
                messageRepository.save(c.get());
                return c.get();
            }else{
                return messages;
            }
        }else{
            return messages;
        }
    }
    

    public boolean deleteMessage(int id) {
        Boolean aBoolean = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }
    
}
