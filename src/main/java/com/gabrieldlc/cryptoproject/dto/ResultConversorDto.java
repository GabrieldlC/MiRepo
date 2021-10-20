package com.gabrieldlc.cryptoproject.dto;

public class ResultConversorDto {
    private String message;
    private double valueConverted;
    private boolean status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getValueConverted() {
        return valueConverted;
    }

    public void setValueConverted(double valueConverted) {
        this.valueConverted = valueConverted;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
