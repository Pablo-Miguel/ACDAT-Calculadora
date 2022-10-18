package com.example.acdat_calculadora.servicio;

import java.util.ArrayList;

public class Servicio {
    private static Servicio serv = null;
    private ArrayList<Operacion> operaciones;

    private Servicio() {
        this.operaciones = new ArrayList<Operacion>();
    }

    public static Servicio getInstance() {
        if (serv == null) {
            serv = new Servicio();
        }

        return serv;
    }

    public void anyadirOperacion(String operacion, String resultado){
        operaciones.add(new Operacion(operacion, resultado));
    }

    public ArrayList<Operacion> obtenerOperaciones(){
        return new ArrayList<Operacion>(this.operaciones);
    }
}
