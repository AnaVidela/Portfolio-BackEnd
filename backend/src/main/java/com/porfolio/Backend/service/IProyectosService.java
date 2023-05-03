/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Proyectos;
import java.util.List;


public interface IProyectosService {
    
    public List<Proyectos> verProyectos();
    
    public void crearProyecto (Proyectos proy);
    
    public void borrarProyectos (Long id);
    
    public Proyectos buscarProyectos (Long id);
    
}
