/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.web;

import com.misiontic.ciclo3.ciclo3.model.Reservations;
import com.misiontic.ciclo3.ciclo3.model.custome.CountClient;
import com.misiontic.ciclo3.ciclo3.model.custome.StatusAmount;
import com.misiontic.ciclo3.ciclo3.service.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Laurita
 */
@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class ReservationController {
    
    @Autowired
    private ReservationService reservationService;
    
    @GetMapping("/all")
    public List<Reservations> getReservation(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservations> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    }
    
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations save (@RequestBody Reservations r){
        return reservationService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservations update(@RequestBody Reservations reserv){
        return reservationService.update(reserv);
    }

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return reservationService.deleteReservation(id);
    }
    
    //RETO 5

    @GetMapping("/report-status")
    public StatusAmount getReservationDescriptionStatus(){
        return reservationService.getStatusReport();
    }
    
    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return reservationService.getTopClient();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservations> getDatesReport(@PathVariable("dateOne")String d1, @PathVariable("dateTwo")String d2){
       return reservationService.getReservationPeriod(d1,d2);
    }
    
}
