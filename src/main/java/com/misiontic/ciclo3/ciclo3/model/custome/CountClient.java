/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.misiontic.ciclo3.ciclo3.model.custome;

import com.misiontic.ciclo3.ciclo3.model.Client;

/**
 *
 * @author Laurita
 */
//la clase sirve para agrupar 
public class CountClient {
    
    private Long total;
    private Client client;

    //crear un metodo constructor

    public CountClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
}
