/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Pantalones;
import com.m5a.ProyectoM5A0106738511.repository.PantalonesRepository;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL_USER
 */
@Service
public class PantalonesServiceImpl implements PantalonesService {

       private final EntityManager entityManager;
  @Autowired
    public PantalonesServiceImpl (EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    
    
    @Autowired
    private PantalonesRepository pantalonRepository;

    @Override
    public Pantalones crear(Pantalones p) {
        return pantalonRepository.save(p);
    }

    @Override
    public Pantalones findById(Long id) {

        return pantalonRepository.findById(id).orElse(null);

    }

    @Override
    public List<Pantalones> findByAll() {

        return (List<Pantalones>) pantalonRepository.findAll();

    }

    @Override
    public void deleteP(Long id) {
        pantalonRepository.deleteById(id);
    }

    @Override
    public Pantalones getCode_P(Pantalones pantalones) {
       
        
        
        TypedQuery<Pantalones> typedQuery = entityManager.createQuery(
                "SELECT p FROM Pantalones p WHERE p.codigo = :codigo", Pantalones.class);
        try {
            Pantalones user = typedQuery.setParameter("codigo", pantalones.getCodigo()).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }        
        
    }

    @Override
    public Pantalones getCode_pants(String codigo) {
        
        
        
           return pantalonRepository.BuscarCodePants(codigo);
        
        
        
    }

}
