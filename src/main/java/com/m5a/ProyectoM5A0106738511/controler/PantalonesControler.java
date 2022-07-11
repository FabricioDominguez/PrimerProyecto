/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.ProyectoM5A0106738511.controler;


import com.m5a.ProyectoM5A0106738511.model.Pantalones;
import com.m5a.ProyectoM5A0106738511.service.PantalonesService;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
public class PantalonesControler {

    @Autowired
    private PantalonesService pantalon;

    public PantalonesControler(PantalonesService pantalon) {
        this.pantalon = pantalon;
    }

    @GetMapping("/listarP")
    public ResponseEntity<List<Pantalones>> listarPantalones() {

        List<Pantalones> lista = pantalon.findByAll();
        List<Pantalones> nuevaLista = new ArrayList<>();
        for (Pantalones pant : lista) {
            double costto_tl = pant.getCosto() * pant.getCantidad();
            pant.setCostoTotal(costto_tl);
            nuevaLista.add(pant);
        }

        return new ResponseEntity<>(nuevaLista, HttpStatus.OK);

    }

    @PostMapping("/crearP")
    public ResponseEntity<Pantalones> crearPantalon(@RequestBody Pantalones p) {

        return new ResponseEntity<>(pantalon.crear(p), HttpStatus.OK);

    }

    @GetMapping("/buscarP/{id}")
    public ResponseEntity<Pantalones> listar_id(@PathVariable Long id) {

        Pantalones pants = new Pantalones();
        pants = pantalon.findById(id);
        double costototales = pants.getCantidad()*pants.getCosto();
        pants.setCostoTotal(costototales);
        
        return new ResponseEntity<>(pants, HttpStatus.OK);


    }

    @PutMapping("/actualizarP/{id}")
    public ResponseEntity<Pantalones> actualizarPantalones(@PathVariable Long id, @RequestBody Pantalones p) {

        Pantalones pt = buscarUsuario(id);

        if (pt == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } else {

            try {

                pt.setMarca(p.getMarca());
                pt.setModelo(p.getModelo());
                pt.setOrigen(p.getOrigen());
                pt.setFabricante(p.getFabricante());
                pt.setCantidad(p.getCantidad());
                pt.setCosto(p.getCosto());

                return new ResponseEntity<>(pantalon.crear(p), HttpStatus.CREATED);

            } catch (Exception e) {

                return new ResponseEntity<>(pantalon.crear(p), HttpStatus.INTERNAL_SERVER_ERROR);

            }

        }

    }

    @DeleteMapping("/eliminarP/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {

        pantalon.deleteP(id);
    }

    public Pantalones buscarUsuario(Long id) {

        return pantalon.findById(id);
    }

    //busqueda mediante un Json
     @PostMapping("/getCodePantalones")
    public Pantalones getCodeP(@RequestBody Pantalones pantalones) {
        return pantalon.getCode_P(pantalones);
    }
    //busqueda mediante get
     @GetMapping("/getPants_code/{codigo}")
    public Pantalones getCode_Panths(@PathVariable String codigo){
    
      Pantalones prenda = new Pantalones();
        prenda = pantalon.getCode_pants(codigo);
    
        double costototal = prenda.getCosto()*prenda.getCantidad();
        prenda.setCostoTotal(costototal);
        return prenda;
    
    
    
    
    }
    
    
    
    
 

}
