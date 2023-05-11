/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Persona {
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private String link;
    private String img;
    private String nombre;
    private String descripcion;

    public Persona() {
    }

    public Persona(String link, String img, String nombre, String descripcion) {
        this.link = link;
        this.img = img;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Persona(Long id, String link, String img, String nombre, String descripcion) {
        this.id = id;
        this.link = link;
        this.img = img;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    
    
    
    
}
