package com.example.BancoAutenticacion.controlador;

import com.example.BancoAutenticacion.Entidad.Prestamo;
import com.example.BancoAutenticacion.servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {

    private Integer idUsuario;

    @Autowired
    PrestamoServicio prestamoServicio;

    @GetMapping("/idusuario")
    public Integer getUsuarioPorId(){
        idUsuario = prestamoServicio.obtenerId();
        return idUsuario;
    }

    @PostMapping("/realizarprestamo")
    public ResponseEntity<Prestamo> realizarPrestamo(@RequestBody Prestamo prestamo){

    }

}
