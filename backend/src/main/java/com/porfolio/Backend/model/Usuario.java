/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Entity
public class Usuario {
    
    @Id
    private String mail;
    private String pasword;
    private String nombre;
    private String apellido;

    public Usuario() {
    }

    public Usuario(String mail, String pasword, String nombre, String apellido) {
        this.mail = mail;
        this.pasword = pasword;
        this.nombre = nombre;
        this.apellido = apellido;
    }
    
    
    
    
    
}
