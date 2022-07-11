/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.controler;

import com.m5a.ProyectoM5A0106738511.model.Equipogps;
import com.m5a.ProyectoM5A0106738511.service.EquipogpsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author DELL_USER
 */
@RestController
@RequestMapping("/api")
public class EquipogpsControler {

    @Autowired
    private EquipogpsService gpsService;

    @GetMapping("/listar")
    public ResponseEntity<List<Equipogps>> listar() {

        return new ResponseEntity<>(gpsService.findByAll(), HttpStatus.OK);

    }

    @PostMapping("/crear")
    public ResponseEntity<Equipogps> crearGps(@RequestBody Equipogps e) {

        return new ResponseEntity<>(gpsService.crearGps(e), HttpStatus.OK);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Equipogps> listar_idGps(@PathVariable Long id) {

        return new ResponseEntity<>(buscarGps(id), HttpStatus.OK);

    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Equipogps> actualizarGPS(@PathVariable Long id, @RequestBody Equipogps e) {

        Equipogps gsp = buscarGps(id);

        if (gsp == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            try {

                gsp.setObservacion(e.getObservacion());
                gsp.setEquipo(e.getEquipo());

                return new ResponseEntity<>(gpsService.crearGps(e), HttpStatus.CREATED);

            } catch (Exception es) {

                return new ResponseEntity<>(gpsService.crearGps(e), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    @DeleteMapping("/eliminar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGps(@PathVariable Long id) {

        gpsService.deleteGps(id);
    }

    public Equipogps buscarGps(Long id) {

        return gpsService.findById(id);
    }

    //obtiene mediante un Json 
    @PostMapping("/getCodeGps")
    public Equipogps getCode(@RequestBody Equipogps equipogps) {
        return gpsService.getGps(equipogps);
    }

    //mediante un get
    @GetMapping("/obtenerImei/{imei}")
    public Equipogps getImeiGps(@PathVariable String imei) {

        Equipogps gps = new Equipogps();

        gps = gpsService.getImeiGps(imei);

        return gps;

    }

}
