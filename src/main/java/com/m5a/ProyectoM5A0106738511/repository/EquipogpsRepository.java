/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.repository;

import com.m5a.ProyectoM5A0106738511.model.Equipogps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DELL_USER
 */
public interface EquipogpsRepository extends JpaRepository<Equipogps, Long>{
    @Query (value = "Select * FROM equipogps e WHERE e.imei = :imei", nativeQuery= true)
public Equipogps getImeiGps(String imei);   
}
