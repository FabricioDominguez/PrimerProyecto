/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.repository;

import com.m5a.ProyectoM5A0106738511.model.Casas;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author DELL_USER
 */
public interface CasaRepository  extends JpaRepository<Casas, Long>  {
    
@Query (value = "Select * from casas c where c.codigo =:codigo", nativeQuery= true)
public Casas BuscarCodigo(String codigo);   
    
}

