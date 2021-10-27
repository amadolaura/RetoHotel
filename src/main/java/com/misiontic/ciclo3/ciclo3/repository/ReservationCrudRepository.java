/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Reservations;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Laurita
 */
//Se llama la clase habitaciones y se nombre integer ya que es el tipo de dato de la llave primaria
//la papeleriacrudrepository hereda a crudrepository
public interface ReservationCrudRepository extends CrudRepository<Reservations, Integer>{
    
    //se va hacer una consulta 
    //el objeto c es una reservacion, se va a hacer un conte de los clientes usados por reservacion
    //le estamos pidiendo un objeto cliente y un numero
    @Query("SELECT c.client, COUNT(c.client) FROM Reservations AS c group by c.client order by COUNT (c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    //QUERY METHODS!
    public List<Reservations> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    //public List<Reservations> findAllByStartBetween (Date dateOne, Date dateTwo);
    public List<Reservations> findAllByStatus (String statusAAA);
    
}
