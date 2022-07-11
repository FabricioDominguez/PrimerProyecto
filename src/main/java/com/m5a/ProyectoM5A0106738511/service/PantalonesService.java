/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;


import com.m5a.ProyectoM5A0106738511.model.Pantalones;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author DELL_USER
 */
public interface PantalonesService {

    public Pantalones crear(Pantalones p);

    public Pantalones findById(Long id);

    public List<Pantalones> findByAll();

    public void deleteP(Long id);
    
    
    public Pantalones getCode_P(Pantalones pantalones);
    
    public Pantalones getCode_pants(String codigo);
    

}
