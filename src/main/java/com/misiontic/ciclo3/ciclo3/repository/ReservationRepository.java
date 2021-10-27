/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Client;
import com.misiontic.ciclo3.ciclo3.model.Reservations;
import com.misiontic.ciclo3.ciclo3.model.custome.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Laurita
 */
//Va a permitir traer y enviar info de base de datos
@Repository
public class ReservationRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private ReservationCrudRepository reservationCrudRepository;
    
    // Consulta los elementos de la base y los entrega en una lista
    public List<Reservations> getAll(){
	return (List<Reservations>) reservationCrudRepository.findAll();
    }
    
    //Si el dato esta se entrega y si no existe el dato pues nada
    // y entonces con ese Optional se evitan problemas con los null
    public Optional<Reservations> getReservation(int id) {
        return reservationCrudRepository.findById(id);
    }
    
    //Para guardar
    public Reservations save (Reservations r) {
         return reservationCrudRepository.save(r);
    }


    public void delete(Reservations reservation) {
        reservationCrudRepository.delete(reservation);
    }
    
    //RETO5
    
    //metodos query como findAllByStatus
    public List<Reservations> getReservationByStatus (String status) {
        return reservationCrudRepository.findAllByStatus(status);
    }
           
    //va a entregar una lista 
    public List<Reservations> getReservationPeriod(Date dateOne, Date dateTwo ) {
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    
    
    //Es el que se encarga de organizar la informacion
    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            /**
            Client cli=(Client) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountClient cc=new CountClient(cantidad,cli);
            res.add(cc);
            */
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }
    
}
