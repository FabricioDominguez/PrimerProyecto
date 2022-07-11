/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.controler;

import com.m5a.ProyectoM5A0106738511.model.Zapatos;
import com.m5a.ProyectoM5A0106738511.service.ZapatosService;
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

/**
 *
 * @author DELL_USER
 */
@RestController
@RequestMapping("/api")

public class ZapatosControler {

    @Autowired
    private ZapatosService zapatoService;

    @GetMapping("/listarZ")
    public ResponseEntity<List<Zapatos>> listarZapatos() {

        List<Zapatos> lista = zapatoService.findByAll();
        List<Zapatos> nuevaLista = new ArrayList<>();
        for (Zapatos pant : lista) {
            double costto_tl = pant.getCosto() * pant.getCantidad();
            pant.setCostoTotal(costto_tl);
            nuevaLista.add(pant);
        }

        return new ResponseEntity<>(nuevaLista, HttpStatus.OK);

    }

    @PostMapping("/crearZ")
    public ResponseEntity<Zapatos> crearZapatos(@RequestBody Zapatos z) {

        return new ResponseEntity<>(zapatoService.crear(z), HttpStatus.OK);

    }

    @PutMapping("/actualizarZ/{id}")
    public ResponseEntity<Zapatos> actualizarZapatos(@PathVariable Long id, @RequestBody Zapatos z) {

        Zapatos zpt = buscarZapatos(id);

        if (zpt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            try {

                zpt.setMarca(z.getMarca());
                zpt.setTipoDeZapato(z.getTipoDeZapato());
                zpt.setCantidad(z.getCantidad());
                zpt.setCosto(z.getCosto());

                return new ResponseEntity<>(zapatoService.crear(z), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(zapatoService.crear(z), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    @DeleteMapping("/eliminarZ/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteZ(@PathVariable Long id) {

        zapatoService.deleteZ(id);
    }

    @GetMapping("/buscarzapato/{id}")
    public ResponseEntity<Zapatos> listar_id(@PathVariable Long id) {
        Zapatos xpt = new Zapatos();

        xpt = zapatoService.findById(id);
        double costoTotal = xpt.getCantidad() * xpt.getCosto();      
        xpt.setCostoTotal(costoTotal);
        
        return new ResponseEntity<>(xpt, HttpStatus.OK);

    }

    @PostMapping("/getCodeZapatos")
    public Zapatos getCode(@RequestBody Zapatos zapatos) {

        return zapatoService.getCode_Z(zapatos);
    }

    @GetMapping("/getCodeShoes/{codigo}")
    public Zapatos getShoes_code(@PathVariable String codigo) {

        Zapatos shoes = new Zapatos();
        shoes = zapatoService.getCode_shoes(codigo);
        double costototl = shoes.getCantidad() * shoes.getCosto();
        shoes.setCostoTotal(costototl);
        return shoes;

    }

    public Zapatos buscarZapatos(Long id) {

        return zapatoService.findById(id);
    }

}
