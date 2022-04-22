/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author GrupoEjer4
 */
public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private int precio;
    private Cliente cliente;
    private ArrayList <Revision> revisiones;
    
    public Coche(String matricula, String marca, String modelo, String color, int precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public int getPrecio() {
        return precio;
    }
    
    public ArrayList<Revision> getRevisiones(){
        return revisiones;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    
    
    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio=" + precio + '}';
    }
    
    public void pasarRevisiones(Revision revision) {
        this.revisiones.add(revision);
    }
}
