package com.gabrieldlc.cryptoproject.controllers;

import com.gabrieldlc.cryptoproject.dto.ResultConversorDto;
import com.gabrieldlc.cryptoproject.services.ConversorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ConversorController {

    ConversorService convertor = new ConversorService();
    ResultConversorDto resultConversorDto = new ResultConversorDto();

    @GetMapping("/convertArsToCrypto")
    public ResultConversorDto getConversionArsToCrypto(@PathParam("ars") double ars, @PathParam("token") String token) {
        try {
            double value = convertor.arsToCrypto(ars, token);
            resultConversorDto.setMessage("Su conversion de $" + ars + " a " + token.toUpperCase() + " es de " + value);
            resultConversorDto.setValueConverted(value);
            resultConversorDto.setStatus(true);
        } catch (Exception e) {
            resultConversorDto.setMessage(e.getMessage());
            resultConversorDto.setValueConverted(-1);
            resultConversorDto.setStatus(false);
        } finally {
            return resultConversorDto;
        }
    }

    @GetMapping("/convertUsdToCrypto")
    public ResultConversorDto getConversionUsdToCrypto(@PathParam("usd") double usd, @PathParam("token") String token) {
        try {
            double value = convertor.usdToCrypto(usd, token);
            resultConversorDto.setMessage("Su conversion de $" + usd + " a " + token.toUpperCase() + " es de " + value);
            resultConversorDto.setValueConverted(value);
            resultConversorDto.setStatus(true);
        } catch (Exception e) {
            resultConversorDto.setMessage(e.getMessage());
            resultConversorDto.setValueConverted(-1);
            resultConversorDto.setStatus(false);
        } finally {
            return resultConversorDto;
        }
    }

    @GetMapping("/convertCryptoToArs")
    public ResultConversorDto getConversionCryptoToArs(@PathParam("value") double value, @PathParam("token") String token) {
        try {
            double valor = convertor.arsToCrypto(value, token);
            resultConversorDto.setMessage("Su conversion de " + value + " " + token.toUpperCase() + " a pesos " + " es de $" + valor);
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

    @GetMapping("/convertCryptoToUsd")
    public ResultConversorDto getConversionCryptoToUsd(@PathParam("value") double value, @PathParam("token") String token) {
        try {
            double valor = convertor.arsToCrypto(value, token);
            resultConversorDto.setMessage("Su conversion de " + value + " " + token.toUpperCase() + " a dólares " + " es de $" + valor);
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

    @GetMapping("/convertCryptoToCrypto")
    public ResultConversorDto getConversionCryptoToCrypto(@PathParam("token1") String token1,
                                                          @PathParam("value") double value, @PathParam("token2") String token2) {
        try {
            double valor = convertor.cryptoToCrypto(token1, value, token2);
            resultConversorDto.setMessage("Su conversion de " + value + " " + token1.toUpperCase() + " a " + token2.toUpperCase() + " es de " + valor);
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