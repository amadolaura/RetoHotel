/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Client;
import com.misiontic.ciclo3.ciclo3.repository.ClientRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laurita
 */
@Service
public class ClientService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private ClientRepository clientRepository;
    
    //va a retornar una lista
    public List<Client> getAll(){
	return clientRepository.getAll();
    }
    
    //get para obtener un cliente en especifico
    //servicio
    public Optional<Client> getClient(int id){
	return clientRepository.getClient(id);
    }
    
    //guardar un registro de habitacion 
    public Client save(Client c){
        if(c.getIdClient() == null){
            return clientRepository.save(c);
        }else{
            Optional<Client> evt=clientRepository.getClient(c.getIdClient());
            if(evt.isEmpty()){
                return clientRepository.save(c);
            }else{
                return clientRepository.save(c);
            }
        }
    }
    
    public Client update (Client client){
        if(client.getIdClient()!=null){
            Optional<Client> c=clientRepository.getClient(client.getIdClient());
            if(!c.isEmpty()){
                
                if(client.getName()!=null){
                    c.get().setName(client.getName());
                }
                if(client.getEmail()!=null){
                    c.get().setEmail(client.getEmail());
                }
                if(client.getPassword()!=null){
                    c.get().setPassword(client.getPassword());
                }
                if(client.getAge()!=null){
                    c.get().setAge(client.getAge());
                }
                
                clientRepository.save(c.get());
                return c.get();
            }else{
                return client;
            }
        }else{
            return client;
        }
    }
    
    
    
    //para eliminar un registro de habitacion
    public boolean deleteClient(int id) {
        Boolean aBoolean = getClient(id).map(client -> {
            clientRepository.delete(client);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }
    
}
