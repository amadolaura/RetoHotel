/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.repository;

import com.misiontic.ciclo3.ciclo3.model.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Laurita
 */
//Se llama la clase category y se nombre integer ya que es el tipo de dato de la llave primaria
//la papeleriacrudrepository hereda a crudrepository
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
    
}
