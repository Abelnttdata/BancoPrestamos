package com.example.BancoAutenticacion.repositorio;

import com.example.BancoAutenticacion.Entidad.Cuenta;
import com.example.BancoAutenticacion.Entidad.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PrestamoRepositorio {

    @Autowired
    PrestamoRepositorioDAO prestamoRepositorioDAO;

    public double obtenerSaldo(List<Cuenta> cuentaCliente) {
        for (int x = 0; x < cuentaCliente.size(); x++){
            if(cuentaCliente.get(x).getSaldo() > 20.00){
                return cuentaCliente.get(x).getSaldo();
            }
            return cuentaCliente.get(x).getSaldo();
        }
        return 0.0;
    }

    public Integer obtenerIdCuenta(List<Cuenta> cuentaCliente, double saldo) {
        for (int x = 0; x < cuentaCliente.size(); x++){
            if(cuentaCliente.get(x).getSaldo() == saldo){
                return cuentaCliente.get(x).getIdCuenta();
            }
            return null;
        }
        return null;
    }

    public boolean crearPrestamo(Prestamo prestamo) {
        try {
            prestamoRepositorioDAO.save(prestamo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public Optional<Prestamo> getListaPrestamos(Integer idUsuario) {
        return prestamoRepositorioDAO.findById(idUsuario);
    }
}
