/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Proyectos;
import com.porfolio.Backend.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService{

    @Autowired 
    public ProyectosRepository proyRepo;
    
    @Override
    public List<Proyectos> verProyectos() {
        return proyRepo.findAll();
    }

    @Override
    public void crearProyecto(Proyectos proy) {
        proyRepo.save(proy);
    }

    @Override
    public void borrarProyectos(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyRepo.findById(id).orElse(null);
    }
    
}
