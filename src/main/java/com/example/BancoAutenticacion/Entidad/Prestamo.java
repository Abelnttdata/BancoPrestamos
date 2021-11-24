package com.example.BancoAutenticacion.Entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer idUsuario;
    private Integer idCuentas;
    private Integer coutas;
    private Integer importe;
    private String tazaInteres;

    public Prestamo() {
    }


    public Prestamo(Integer id, Integer idUsuario, Integer idCuentas, Integer coutas, Integer importe, String tazaInteres) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idCuentas = idCuentas;
        this.coutas = coutas;
        this.importe = importe;
        this.tazaInteres = tazaInteres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCoutas() {
        return coutas;
    }

    public void setCoutas(Integer coutas) {
        this.coutas = coutas;
    }

    public Integer getImporte() {
        return importe;
    }

    public void setImporte(Integer importe) {
        this.importe = importe;
    }

    public String getTazaInteres() {
        return tazaInteres;
    }

    public void setTazaInteres(String tazaInteres) {
        this.tazaInteres = tazaInteres;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdCuentas() {
        return idCuentas;
    }

    public void setIdCuentas(Integer idCuentas) {
        this.idCuentas = idCuentas;
    }
}
