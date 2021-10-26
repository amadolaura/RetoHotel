/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.service;

import com.misiontic.ciclo3.ciclo3.model.Category;
import com.misiontic.ciclo3.ciclo3.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Laurita
 */
@Service
public class CategoryService {
    
    //Se recibira la logica de negocio
    //Le va a indicar al framework
    @Autowired
    private CategoryRepository categoryRepository;
    
    //va a retornar una lista
    public List<Category> getAll(){
	return categoryRepository.getAll();
    }
    
    //get para obtener una categoria especifica
    //servicio
    public Optional<Category> getCategory(int id){
	return categoryRepository.getCategory(id);
    }
    
    //guardar un registro de habitacion 
    public Category save(Category c){
        if(c.getId() == null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> evt=categoryRepository.getCategory(c.getId());
            if(evt.isEmpty()){
                return categoryRepository.save(c);
            }else{
                return categoryRepository.save(c);
            }
        }
    }
    
    public Category update (Category category){
        if(category.getId()!=null){
            Optional<Category> c=categoryRepository.getCategory(category.getId());
            if(!c.isEmpty()){
                
                if(category.getName()!=null){
                    c.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    c.get().setDescription(category.getDescription());
                }
                
                categoryRepository.save(c.get());
                return c.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
    
    
    //para eliminar un registro de habitacion
    public boolean deleteCategory(int id) {
        Boolean aBoolean = getCategory(id).map(category -> {
            categoryRepository.delete(category);
            return true;
        }).orElse( aBoolean = false);
        return aBoolean;
    }
    
}
