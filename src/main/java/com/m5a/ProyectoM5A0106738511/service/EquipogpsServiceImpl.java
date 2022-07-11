/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.service;

import com.m5a.ProyectoM5A0106738511.model.Equipogps;
import com.m5a.ProyectoM5A0106738511.repository.EquipogpsRepository;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL_USER
 */
@Service
public class EquipogpsServiceImpl implements EquipogpsService {

    private final EntityManager entityManager;

    @Autowired
    public EquipogpsServiceImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Autowired
    private EquipogpsRepository gpsRepository;

    @Override
    public Equipogps crearGps(Equipogps e) {

        return gpsRepository.save(e);

    }

    @Override
    public Equipogps findById(Long id) {

        return gpsRepository.findById(id).orElse(null);

    }

    @Override
    public List<Equipogps> findByAll() {

        return (List<Equipogps>) gpsRepository.findAll();

    }

    @Override
    public void deleteGps(Long id) {

        gpsRepository.deleteById(id);

    }

    @Override
    public Equipogps getGps(Equipogps gps) {

        TypedQuery<Equipogps> typedQuery = entityManager.createQuery(
                "SELECT e FROM Equipogps e WHERE e.imei = :imei", Equipogps.class);
        try {
            Equipogps user = typedQuery.setParameter("imei", gps.getImei()).getSingleResult();
            return user;
        } catch (Exception e) {
            System.out.println("Datos no existen");

            return null;
        }

    }

    @Override
    public Equipogps getImeiGps(String imei) {

        return gpsRepository.getImeiGps(imei);

    }

}
