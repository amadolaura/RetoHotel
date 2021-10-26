/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Room;
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
public class HabitacionesRepository {
    
    @Autowired
    //metodos que van a llamar las acciones del crud repository
    private HabitacionesCrudRepository habitacionesCrudRepository;
    
    // Consulta los elementos de la base y los entrega en una lista
    public List<Room> getAll(){
	return (List<Room>) habitacionesCrudRepository.findAll();
    }
    
    //Si el dato esta se entrega y si no existe el dato pues nada
    // y entonces con ese Optional se evitan problemas con los null
    public Optional<Room> getHabitaciones(int id) {
        return habitacionesCrudRepository.findById(id);
    }
    
    //Para guardar
    public Room save (Room h) {
         return habitacionesCrudRepository.save(h);
    }
    

    public void delete(Room habitaciones) {
        habitacionesCrudRepository.delete(habitaciones);
    }

    
}
