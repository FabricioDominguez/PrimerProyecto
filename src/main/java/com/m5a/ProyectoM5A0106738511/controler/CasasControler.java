/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.controler;

import com.m5a.ProyectoM5A0106738511.model.Casas;
import com.m5a.ProyectoM5A0106738511.service.CasasService;
import java.util.ArrayList;
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

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL_USER
 */
@RestController
@RequestMapping("/api")
public class CasasControler {

    @Autowired
    private CasasService casaService;

    @GetMapping("/listarcas")
    public ResponseEntity<List<Casas>> listar() {

        List<Casas> lista = casaService.findByAll();
        List<Casas> nuevaLista = new ArrayList<>();
        for (Casas pant : lista) {
            double costto_tl = pant.getArea() * pant.getCostoKm();
            pant.setCostoTotal(costto_tl);
            nuevaLista.add(pant);
        }
       return new ResponseEntity<>(nuevaLista, HttpStatus.OK);

    }

    @PostMapping("/crearcasa")
    public ResponseEntity<Casas> crear(@RequestBody Casas c) {

        return new ResponseEntity<>(casaService.crearCasa(c), HttpStatus.OK);

    }

    @GetMapping("/buscarcas/{id}")
    public ResponseEntity<Casas> listar_id(@PathVariable Long id) {

      Casas house = new Casas ();
      house = casaService.findById(id);
      double costototal = house.getArea() * 80;
      house.setCostoTotal(costototal);
 
       return new ResponseEntity<>(house, HttpStatus.OK);

    }

    @PutMapping("/actualizarcasa/{id}")
    public ResponseEntity<Casas> actualizarCasa(@PathVariable Long id, @RequestBody Casas c) {

        Casas home = buscarUsuario(id);

        if (home == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            try {

                home.setPropietario(c.getPropietario());
                home.setTipoTerreno(c.getTipoTerreno());
                home.setArea(c.getArea());
                home.setCostoKm(c.getCostoKm());

                return new ResponseEntity<>(casaService.crearCasa(c), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(casaService.crearCasa(c), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    @DeleteMapping("/eliminarcasa/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        casaService.delete(id);
    }

    @PostMapping("/getCode")
    public Casas getCode(@RequestBody Casas user) {
        return casaService.getUser(user);
    }

    @GetMapping("/busqueda/{codigo}")
    public Casas buscarCode(@PathVariable String codigo) {

        Casas casa = new Casas();
        casa = casaService.BuscarCodigo(codigo);

        double costototal = casa.getArea() * 80;
        casa.setCostoTotal(costototal);
        return casa;

    }

    public Casas buscarUsuario(Long id) {

        return casaService.findById(id);
    }

}
