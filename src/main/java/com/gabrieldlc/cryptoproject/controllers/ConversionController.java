package com.gabrieldlc.cryptoproject.controllers;

import com.gabrieldlc.cryptoproject.dto.ResultConversorDto;
import com.gabrieldlc.cryptoproject.services.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class ConversionController {

    ConversionService convertor = new ConversionService();
    ResultConversorDto resultConversorDto = new ResultConversorDto();

    @GetMapping("/convert-fiat-to-crypto")
    public ResultConversorDto getConversionFiatToCrypto(@PathParam("currency") String currency,
                                                        @PathParam("value") double value, @PathParam("token") String token) {
        try {
            double conversion = convertor.fiatToCrypto(currency, value, token);
            resultConversorDto.setMessage("Su conversion de " + value + currency.toUpperCase() + " a " + token.toUpperCase() + " es de " + conversion);
            resultConversorDto.setValueConverted(conversion);
            resultConversorDto.setStatus(true);
        } catch (Exception e) {
            resultConversorDto.setMessage(e.getMessage());
            resultConversorDto.setValueConverted(-1);
            resultConversorDto.setStatus(false);
        } finally {
            return resultConversorDto;
        }
    }

    @GetMapping("/convert-crypto-to-fiat")
    public ResultConversorDto getConversionCryptoToFiat(@PathParam("value") double value,
                                                        @PathParam("token") String token, @PathParam("currency") String currency) {
        try {
            double conversion = convertor.cryptoToFiat(token, value, currency);
            resultConversorDto.setMessage("Su conversion de " + value + token.toUpperCase() + " es de " + conversion + currency.toUpperCase());
            resultConversorDto.setValueConverted(conversion);
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