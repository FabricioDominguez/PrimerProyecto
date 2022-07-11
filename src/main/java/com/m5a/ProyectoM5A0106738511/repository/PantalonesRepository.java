/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.repository;

import antlr.debug.Event;
import com.m5a.ProyectoM5A0106738511.model.Pantalones;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import javax.persistence.Tuple;
//import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL_USER
 */
public interface PantalonesRepository extends JpaRepository<Pantalones, Long> {
@Query (value = "Select * from pantalones c where c.codigo =:codigo", nativeQuery= true)
public Pantalones BuscarCodePants(String codigo);  
 
}
