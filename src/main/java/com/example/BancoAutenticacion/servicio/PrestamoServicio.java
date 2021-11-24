package com.example.BancoAutenticacion.servicio;

import com.example.BancoAutenticacion.Entidad.Cuenta;
import com.example.BancoAutenticacion.Entidad.Prestamo;
import com.example.BancoAutenticacion.repositorio.PrestamoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class PrestamoServicio {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    PrestamoRepositorio prestamoRepositorio;

    public Integer obtenerId(){
        Integer idUsuario = restTemplate.getForObject("http://localhost:8080/usuarios/enviarid", Integer.class);
        return idUsuario;
    }

        public List<Cuenta> obtenerCuentasClientes(){
            ResponseEntity<Cuenta[]> response=
                    restTemplate.getForEntity(
                            "http://localhost:8080/usuarios/verUsuarios",
                            Cuenta[].class);
            Cuenta[] cuenta = response.getBody();
            List<Cuenta> cuentaList= Arrays.asList(cuenta);
            return cuentaList;
        }

    public double obtenerSaldo(List<Cuenta> cuentaCliente) {
        return prestamoRepositorio.obtenerSaldo(cuentaCliente);
    }

    public Integer obetnerIdCuenta(List<Cuenta> cuentaCliente, double saldo) {
        return prestamoRepositorio.obtenerIdCuenta(cuentaCliente, saldo);
    }

    public boolean crearPrestamo(Prestamo prestamo) {
        return prestamoRepositorio.crearPrestamo(prestamo);
    }

    public Optional<Prestamo> getListaPrestamos(Integer idUsuario) {
        return prestamoRepositorio.getListaPrestamos(idUsuario);
    }
}
