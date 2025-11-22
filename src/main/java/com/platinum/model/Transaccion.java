package com.platinum.model;

public class Transaccion {
    private int id;
    private String rutCliente;
    private String rutDueño;
    private int idCuenta;
    private double montoTransferencia;
    private String cuentaTransferencia;
    private String tipoCuenta;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRutCliente() { return rutCliente; }
    public void setRutCliente(String rutCliente) { this.rutCliente = rutCliente; }

    public String getRutDueño() { return rutDueño; }
    public void setRutDueño(String rutDueño) { this.rutDueño = rutDueño; }

    public int getIdCuenta() { return idCuenta; }
    public void setIdCuenta(int idCuenta) { this.idCuenta = idCuenta; }

    public double getMontoTransferencia() { return montoTransferencia; }
    public void setMontoTransferencia(double montoTransferencia) { this.montoTransferencia = montoTransferencia; }

    public String getCuentaTransferencia() { return cuentaTransferencia; }
    public void setCuentaTransferencia(String cuentaTransferencia) { this.cuentaTransferencia = cuentaTransferencia; }

    public String getTipoCuenta() { return tipoCuenta; }
    public void setTipoCuenta(String tipoCuenta) { this.tipoCuenta = tipoCuenta; }
}
