/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Educacion;
import java.util.List;

/**
 *
 * @author analia
 */
public interface IEducacionService {
    
    public List<Educacion> verEducacion ();
    
    public void crearEduc (Educacion educ);
    
    public void borrarEduc(Long id);
    
    public Educacion buscarEduc(Long id);
}
