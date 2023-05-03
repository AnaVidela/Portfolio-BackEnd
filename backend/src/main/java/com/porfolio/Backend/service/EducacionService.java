/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Educacion;
import com.porfolio.Backend.repository.EducacionRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducacionService implements IEducacionService{
    
    @Autowired
    public EducacionRepository educRepo;
    

    @Override
    public List<Educacion> verEducacion() {
        return educRepo.findAll();
    }

    @Override
    public void crearEduc(Educacion educ) {
        educRepo.save(educ);
    }

    @Override
    public void borrarEduc(Long id) {
        educRepo.deleteById(id);
    }

    @Override
    public Educacion buscarEduc(Long id) {
        return educRepo.findById(id).orElse(null);
    }
    
}
