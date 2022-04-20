/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Grupo Ejer4
 */
public class Revision {

    private int codigo;
    private String fecha;
    private boolean filtro;
    private boolean aceite;
    private boolean frenos;

    public Revision() {
        this.codigo = 0;
        this.fecha = null;
        this.filtro = false;
        this.aceite = false;
        this.frenos = false;
            
    }
    public Revision(int codigo, String fecha, boolean filtro, boolean aceite, boolean frenos) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.filtro = filtro;
        this.aceite = aceite;
        this.frenos = frenos;
    }
}
