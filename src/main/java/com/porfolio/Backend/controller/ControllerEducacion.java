    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolio.Backend.controller;

import com.porfolio.Backend.model.Educacion;
import com.porfolio.Backend.service.IEducacionService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "https://portfolio-front-analia.web.app/")
public class ControllerEducacion {
    
    @Autowired
    private IEducacionService educServ;
    
    @GetMapping("/ver")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educServ.verEducacion();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/new")
    public void agregarEducacion(@RequestBody Educacion educ) {
       educServ.crearEduc(educ);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educServ.borrarEduc(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editEducacion(@PathVariable Long id,
            @RequestBody Educacion educDetail) {

        Educacion educ = educServ.buscarEduc(id);

        educ.setLink(educDetail.getLink());
        educ.setImg(educDetail.getImg());
        educ.setNombre(educDetail.getNombre());
        educ.setDescripcion(educDetail.getDescripcion());

        educServ.crearEduc(educ);

        return new ResponseEntity<>(HttpStatus.OK);
    }
        
    @GetMapping("/detail/{id}")
    public Educacion detalleEducacion(@PathVariable Long id){
        return educServ.buscarEduc(id);
    }
        
}
