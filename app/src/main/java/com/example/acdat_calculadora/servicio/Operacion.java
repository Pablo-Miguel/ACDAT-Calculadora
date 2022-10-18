package com.example.acdat_calculadora.servicio;

public class Operacion {
    private String operacion, resultado;

    public Operacion(String operacion, String resultado) {
        this.operacion = operacion;
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "operacion='" + operacion + '\'' +
                ", resultado='" + resultado + '\'' +
                '}';
    }
}
