/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.porfolio.Backend.service;

import com.porfolio.Backend.model.Usuario;

/**
 *
 * @author analia
 */
public interface IUsuarioService {
    
    public void crearUsuario (Usuario user);
    
    public Usuario buscarUsuario (String mail);
}

    
