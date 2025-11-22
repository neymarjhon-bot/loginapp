package com.platinum.model;

public class CuentaCorriente {

    private int id;
    private int usuarioId;
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(int id, int usuarioId, double saldo) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
