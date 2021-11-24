package com.example.BancoAutenticacion.controlador;

import com.example.BancoAutenticacion.Entidad.Cuenta;
import com.example.BancoAutenticacion.Entidad.Prestamo;
import com.example.BancoAutenticacion.servicio.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/prestamos")
public class PrestamoControlador {

    private Integer idUsuario;
    private List<Cuenta> cuentaCliente;
    private  Integer idCuenta;
    private double saldo;



    @Autowired
    PrestamoServicio prestamoServicio;

    @GetMapping("/idusuario")
    public Integer getUsuarioPorId(){
        idUsuario = prestamoServicio.obtenerId();
        return idUsuario;
    }

    @PostMapping("/realizarprestamo")
    public ResponseEntity<Prestamo> realizarPrestamo(@RequestBody Prestamo prestamo) throws noTieneCuenta, saldoInsuficiente, PrestamoFallido{
        idUsuario = prestamoServicio.obtenerId();
        cuentaCliente = prestamoServicio.obtenerCuentasClientes();
        if(cuentaCliente == null){
            throw new noTieneCuenta();
        }
        saldo = prestamoServicio.obtenerSaldo(cuentaCliente);
        if(saldo < 20.00){
            throw new saldoInsuficiente();
        }
        idCuenta = prestamoServicio.obetnerIdCuenta(cuentaCliente, saldo);
        if(idCuenta == null){
            throw  new saldoInsuficiente();
        }
        prestamo.setIdUsuario(idUsuario);
        prestamo.setIdCuentas(idCuenta);
        boolean prestamoRealizado = prestamoServicio.crearPrestamo(prestamo);
        if(!prestamoRealizado){
            throw new PrestamoFallido();
        }
        return ResponseEntity.ok(prestamo);
    }

    @GetMapping("/listarprestamos")
    public ResponseEntity<Prestamo> listarPrestamos() throws noTienePrestamo{
        idUsuario = prestamoServicio.obtenerId();
        Optional<Prestamo> optionalPrestamo = prestamoServicio.getListaPrestamos(idUsuario);
        if(optionalPrestamo.isEmpty()){
            throw new noTienePrestamo();
        }
        return ResponseEntity.ok(optionalPrestamo.get());
    }
}
