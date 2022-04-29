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
    
    private String matricula;
    private boolean filtro;
    private boolean aceite;
    private boolean frenos;

    public Revision() {
        this.codigo = 0;
       
        this.filtro = false;
        this.aceite = false;
        this.frenos = false;

    }

    public Revision(int codigo,String matricula, boolean filtro, boolean aceite, boolean frenos) {
        this.codigo = codigo;
        
        this.matricula = matricula;
        this.filtro = filtro;
        this.aceite = aceite;
        this.frenos = frenos;
    }

    public int getCodigo() {
        return codigo;
    }

    

    public String getMatricula() {
        return matricula;
    }
    

    public boolean isFiltro() {
        return filtro;
    }

    public boolean isAceite() {
        return aceite;
    }

    public boolean isFrenos() {
        return frenos;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
    

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    

    public void setFiltro(boolean filtro) {
        this.filtro = filtro;
    }

    public void setAceite(boolean aceite) {
        this.aceite = aceite;
    }

    public void setFrenos(boolean frenos) {
        this.frenos = frenos;
    }
    

}
