/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;


import com.m5a.ProyectoM5A0106738511.model.Zapatos;
import java.util.List;

/**
 *
 * @author DELL_USER
 */
public interface ZapatosService {
     
    public Zapatos crear(Zapatos z);

    public Zapatos findById(Long id);

    public List<Zapatos> findByAll();

    public void deleteZ(Long id);

    public Zapatos getCode_Z(Zapatos pantalones);
    
    public Zapatos getCode_shoes(String code);
    
    
    
    
}
