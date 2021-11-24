package com.example.BancoAutenticacion.configuracion;

import com.example.BancoAutenticacion.controlador.saldoInsuficiente;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class SaldoInsuficienteHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler({saldoInsuficiente.class})
    protected ResponseEntity<Object> handleNotFound(
            Exception ex, WebRequest request){
        return handleExceptionInternal(ex,"Saldo Insuficiente para realizar un prestamo",
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }
}
