/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Casas;
import com.m5a.ProyectoM5A0106738511.repository.CasaRepository;

import java.util.List;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.persistence.TypedQuery;

/**
 *
 * @author DELL_USER
 */
@Service
public class CasasServiceImpl implements CasasService {

    private final EntityManager entityManager;

    @Autowired
    public CasasServiceImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }
    @Autowired
    private CasaRepository casaRepository;

    @Override
    public Casas crearCasa(Casas c) {

        return casaRepository.save(c);

    }

    @Override
    public Casas findById(Long id) {

        return casaRepository.findById(id).orElse(null);

    }

    @Override
    public List<Casas> findByAll() {

        return (List<Casas>) casaRepository.findAll();

    }

    @Override
    public void delete(Long id) {

        casaRepository.deleteById(id);
    }

    @Override
    public Casas getUser(Casas casa) {

        TypedQuery<Casas> typedQuery = entityManager.createQuery(
                "SELECT c FROM Casas c WHERE c.codigo = :codigo", Casas.class);
        try {
            Casas user = typedQuery.setParameter("codigo", casa.getCodigo()).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }

    }

    @Override
    public Casas BuscarCodigo(String codigo) {

        return casaRepository.BuscarCodigo(codigo);

    }

}
