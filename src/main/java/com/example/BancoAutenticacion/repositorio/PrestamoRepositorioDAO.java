package com.example.BancoAutenticacion.repositorio;

import com.example.BancoAutenticacion.Entidad.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrestamoRepositorioDAO extends CrudRepository<Prestamo, Integer> {

    @Query(value = "select p from Prestamo p where p.idUsuario = :idUsuario")
    Optional<Prestamo> findByIdUsuario(Integer idUsuario);
}
