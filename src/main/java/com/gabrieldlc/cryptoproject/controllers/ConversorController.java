package com.gabrieldlc.cryptoproject.controllers;

import com.gabrieldlc.cryptoproject.dto.ResultConversorDto;
import com.gabrieldlc.cryptoproject.services.ConversorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ConversorController {

    @GetMapping("/convert")
    public ResultConversorDto getConversion(@PathParam("ars") double ars, @PathParam("token") String token) {
        ConversorService conversor = new ConversorService();

        ResultConversorDto resultConversorDto = new ResultConversorDto();

        try {
            double valor = conversor.valorEnCripto(ars, token);
            resultConversorDto.setMessage("Su conversion de $" + ars + " a " + token.toUpperCase() + " es de " + valor);
            resultConversorDto.setValueConverted(valor);
            resultConversorDto.setStatus(true);
        } catch (Exception e) {
            resultConversorDto.setMessage(e.getMessage());
            resultConversorDto.setValueConverted(-1);
            resultConversorDto.setStatus(false);
        } finally {
            return resultConversorDto;
        }
    }
}