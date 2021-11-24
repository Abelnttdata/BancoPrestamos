package com.example.BancoAutenticacion.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PrestamoServicio {
    @Autowired
    RestTemplate restTemplate = new RestTemplate();

    public Integer obtenerId(){
        Integer idUsuario = restTemplate.getForObject("http://localhost:8080/usuarios/enviarid", Integer.class);
        return idUsuario;
    }
}
