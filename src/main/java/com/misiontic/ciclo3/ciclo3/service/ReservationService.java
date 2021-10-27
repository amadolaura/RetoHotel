/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Reservations;
import com.misiontic.ciclo3.ciclo3.model.custome.CountClient;
import com.misiontic.ciclo3.ciclo3.model.custome.StatusAmount;
import com.misiontic.ciclo3.ciclo3.repository.ReservationRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laurita
 */
@Service
public class ReservationService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    /**
     * Estamos llamando un objeto reservationRepository
     */
    private ReservationRepository reservationRepository;
    

    //va a retornar una lista
    /**
     * Metodo que sirve para traer todas las reservaciones
     * @return 
     */
    public List<Reservations> getAll(){
	return reservationRepository.getAll();
    }
    


    //get para obtener una habitacion especifica
    //servicio
    /**
     * Metodo que sirve para traer una reservacion por el id
     * @param id
     * @return reservación
     */
    public Optional<Reservations> getReservation(int id){
	return reservationRepository.getReservation(id);
    }
    

    //guardar un registro de habitacion 
    /**
     * Metodo que sirve para guardar una reservacion
     * @param r
     * @return una nueva reservacion
     */
    public Reservations save(Reservations r){
        if(r.getIdReservation() == null){
            return reservationRepository.save(r);
        }else{
            Optional<Reservations> evt=reservationRepository.getReservation(r.getIdReservation());
            if(evt.isEmpty()){
                return reservationRepository.save(r);
            }else{
                return reservationRepository.save(r);
            }
        }
    }
    
    /**
     * Metodo que sirve para actualizar una reservación
     * @param reservations
     * @return la actualizacion
     */
    public Reservations update (Reservations reservations){
        if(reservations.getIdReservation()!=null){
            Optional<Reservations> categ=reservationRepository.getReservation(reservations.getIdReservation());
            if(!categ.isEmpty()){
                
                if(reservations.getStartDate()!=null){
                    categ.get().setStartDate(reservations.getStartDate());
                }
                if(reservations.getDevolutionDate()!=null){
                    categ.get().setDevolutionDate(reservations.getDevolutionDate());
                }
                if(reservations.getStatus()!=null){
                    categ.get().setStatus(reservations.getStatus());
                }
                
                reservationRepository.save(categ.get());
                return categ.get();
            }else{
                return reservations;
            }
        }else{
            return reservations;
        }
    }

    /**
     * Metodo para eiminar una reservación
     * @param id
     * @return un BOOLEAN true or false
     */
    public boolean deleteReservation(int id) {
        Boolean aBoolean =  getReservation(id).map(reservation -> {
            reservationRepository.delete(reservation);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }
    
    //RETO 5
    public List<CountClient> getTopClient(){
        return reservationRepository.getTopClient();
    }

    public StatusAmount getStatusReport(){
        List<Reservations> completed=reservationRepository.getReservationByStatus("completed");
        List<Reservations> cancelled=reservationRepository.getReservationByStatus("cancelled");

        StatusAmount descAmt=new StatusAmount(completed.size(),cancelled.size());
        return descAmt;
    }
    public List<Reservations> getReservationPeriod(String d1, String d2){

        // yyyy-MM-dd
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date dateOne=new Date();
        Date dateTwo=new Date();
        try {
            dateOne=parser.parse(d1);
            dateTwo=parser.parse(d2);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        if(dateOne.before(dateTwo)){
            return reservationRepository.getReservationPeriod(dateOne,dateTwo);
        }else{
            return new ArrayList<>();
        }
    }
    
}
