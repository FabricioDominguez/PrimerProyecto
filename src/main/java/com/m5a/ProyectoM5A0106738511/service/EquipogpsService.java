/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Equipogps;
import java.util.List;

/**
 *
 * @author DELL_USER
 */
public interface EquipogpsService {

    public Equipogps crearGps(Equipogps e);

    public Equipogps findById(Long id);

    public List<Equipogps> findByAll();

    public void deleteGps(Long id);

    public Equipogps getGps(Equipogps gps);
    
    public Equipogps getImeiGps(String imei);

}
