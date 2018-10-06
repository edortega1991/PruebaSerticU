/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.prueba.models;

/**
 *
 * @author Edinson
 */
public class Prueba {
    int id;
    String cedulaAs, nombreA, carreraA, cedulaE, nombreE, detalle, calificacion, fecha;

    public Prueba() {
    }

    public Prueba(int id, String cedulaAs, String nombreA, String carreraA, String cedulaE, String nombreE, String detalle, String calificacion, String fecha) {
        this.id = id;
        this.cedulaAs = cedulaAs;
        this.nombreA = nombreA;
        this.carreraA = carreraA;
        this.cedulaE = cedulaE;
        this.nombreE = nombreE;
        this.detalle = detalle;
        this.calificacion = calificacion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedulaAs() {
        return cedulaAs;
    }

    public void setCedulaAs(String cedulaAs) {
        this.cedulaAs = cedulaAs;
    }

    public String getNombreA() {
        return nombreA;
    }

    public void setNombreA(String nombreA) {
        this.nombreA = nombreA;
    }

    public String getCarreraA() {
        return carreraA;
    }

    public void setCarreraA(String carreraA) {
        this.carreraA = carreraA;
    }

    public String getCedulaE() {
        return cedulaE;
    }

    public void setCedulaE(String cedulaE) {
        this.cedulaE = cedulaE;
    }

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
