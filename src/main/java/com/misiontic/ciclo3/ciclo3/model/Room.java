/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.misiontic.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 *
 * @author Laurita
 */
@Entity
@Table(name="room")
public class Room implements Serializable{
    
    @Id
    //Para que el id sea autogenerado
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Atributo id
     */
    private Integer id;
    /**
     * Atributo name
     */
    private String name;
    /**
     * Atributo hotel
     */
    private String hotel;
    /**
     * Atributo stars
     */
    private Integer stars;
    /**
     * Atributo description
     */
    private String description;
    
    
    //le estamos dando un objeto para crear una relacion con Categoria
    @ManyToOne
    //como se va a llamar la llave foranea
    @JoinColumn(name="categoryId")
    //Aqui mirar muy bien si en el parentesis va habitaciones
    @JsonIgnoreProperties("rooms")
    /**
     * Estamos llamando al objeto Categoria
     */
    private Category category;
    
    
    
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Estamos llamando al objeto Message
     */
    public List<Messages> messages;
    
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "room")
    @JsonIgnoreProperties({"room", "client"})
    /**
     * Estamos llamando al objeto Reservations
     */
    public List<Reservations> reservations;
    
    
    /**
     * Permite acceder al valor del atributo 
     * @return messages
     */
    public List<Messages> getMessages() {
        return messages;
    }

    /**
     *Permite asignar un valor al atributo
     * @param messages 
     */
    public void setMessages(List<Messages> messages) {
        this.messages = messages;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return reservations
     */
    public List<Reservations> getReservations() {
        return reservations;
    }

    /**
     * Permite asignar un valor al atributo
     * @param reservations 
     */
    public void setReservations(List<Reservations> reservations) {
        this.reservations = reservations;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Permite asignar un valor al atributo
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }   
    
    /**
     * Permite acceder al valor del atributo 
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Permite asignar un valor al atributo
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return hotel
     */
    public String getHotel() {
        return hotel;
    }

    /**
     * Permite asignar un valor al atributo
     * @param hotel 
     */
    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return stars
     */
    public Integer getStars() {
        return stars;
    }

    /**
     * Permite asignar un valor al atributo
     * @param stars 
     */
    public void setStars(Integer stars) {
        this.stars = stars;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Permite asignar un valor al atributo
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Permite acceder al valor del atributo 
     * @return category
     */
    public Category getCategory() {
        return category;
    }

    /**
     * Permite asignar un valor al atributo
     * @param category 
     */
    public void setCategory(Category category) {
        this.category = category;
    }

}
