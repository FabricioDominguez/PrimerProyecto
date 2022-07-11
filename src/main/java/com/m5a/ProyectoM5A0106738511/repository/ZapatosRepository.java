/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.repository;

import com.m5a.ProyectoM5A0106738511.model.Zapatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DELL_USER
 */
public interface ZapatosRepository extends JpaRepository <Zapatos, Long > {
    @Query (value = "Select * from zapatos c where c.codigo =:codigo", nativeQuery= true)
public Zapatos getCode_shoes(String codigo);   
}
