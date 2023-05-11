/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Persona;
import java.util.List;


public interface IPersonaService {
    
    public List<Persona> verPersona ();
    
    public void crearPersona (Persona per);
    
    public void borrarPersona(Long id);
    
    public Persona buscarPersona(Long id);
    
}
