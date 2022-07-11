/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Casas;
import java.util.List;

/**
 *
 * @author DELL_USER
 */
public interface CasasService {

    public Casas crearCasa(Casas c);

    public Casas findById(Long id);

    public List<Casas> findByAll();

    public void delete(Long id);

    public Casas getUser(Casas casa);

    public Casas BuscarCodigo(String codigo);

}
