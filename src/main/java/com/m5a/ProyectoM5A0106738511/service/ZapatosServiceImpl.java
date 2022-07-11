/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Pantalones;
import com.m5a.ProyectoM5A0106738511.model.Zapatos;
import com.m5a.ProyectoM5A0106738511.repository.ZapatosRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author DELL_USER
 */
@Service
public class ZapatosServiceImpl implements ZapatosService {

    private final EntityManager entityManager;

    @Autowired
    public ZapatosServiceImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Autowired
    private ZapatosRepository zptosRepository;

    @Override
    public Zapatos crear(Zapatos z) {

        return zptosRepository.save(z);

    }

    @Override
    public Zapatos findById(Long id) {

        return zptosRepository.findById(id).orElse(null);

    }

    @Override
    public List<Zapatos> findByAll() {

        return (List<Zapatos>) zptosRepository.findAll();

    }

    @Override
    public void deleteZ(Long id) {

        zptosRepository.deleteById(id);
    }

    @Override
    public Zapatos getCode_Z(Zapatos zapatos) {

        TypedQuery<Zapatos> typedQuery = entityManager.createQuery(
                "SELECT z FROM Zapatos z WHERE z.codigo = :codigo", Zapatos.class);
        try {
            Zapatos user = typedQuery.setParameter("codigo", zapatos.getCodigo()).getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Zapatos getCode_shoes(String code) {
       
        return  zptosRepository.getCode_shoes(code);
       
    }

}
