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
public class Cliente {
    private String dni;
    private String nombre;
    private String direccion;
    private String ciudad;
    private int telefono;
    private ArrayList <Coche> coches;

    public Cliente(String dni, String nombre, String direccion, String ciudad, int telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getTelefono() {
        return telefono;
    }
    public ArrayList<Coche> getCoche(){
        return coches;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
    

    @Override
    public String toString() {
        return "Cliente{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", ciudad=" + ciudad + ", telefono=" + telefono + '}';
    }

    public void compraCoche(Coche coche) {
        this.coches.add(coche);
    }

}
