package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Coche;
import model.Revision;
import view.JFrame2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author MEDAC-INVITADO
 */
public class ControladorRevision {
     public void insertRevision(String Codigo,Boolean Flitro, Boolean Aceite, Boolean Frenos ,Date Fecha, String Matricula) throws SQLException {
        String consulta = "";
        ConexionMySql cliente = new ConexionMySql();

        cliente.conectar();
        consulta = "INSERT INTO revision(Codigo,Flitro,Aceite,Frenos,Fecha,Matricula ) VALUES ("+Codigo +Flitro +Aceite + Frenos +Fecha +Matricula +"); ";

        try {
            cliente.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                cliente.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }

    public void deleteRevision(String Codigo) throws SQLException {
        String consulta = "";
        ConexionMySql coche = new ConexionMySql();

        coche.conectar();
        consulta = "DELETE FROM `revision` WHERE Codigo =" +Codigo +" ;";

        try {
            coche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }  
    public ArrayList <Coche> selectRevision() throws SQLException{
        String consulta = "";
        Controlador revision = new Controlador();
        
        revision.conectar();
        consulta = "SELECT * FROM `coche`;";
        ArrayList<Revision> revisiones = new ArrayList<>();
        try {
           
            revisiones = revision.ejecutarSelect(consulta);
            ResultSet rs = (ResultSet) revision.ejecutarSelect(consulta);
        //ArrayList <Coche> coches = new ArrayList<>();
            while(rs.next()){
                Revision co = new Revision();
                co.setMatricula(rs.getString("Matricula"));
                co.setMarca(rs.getString("Marca"));
                co.setModelo(rs.getString("Modelo"));
                co.setColor(rs.getString("Color"));
                co.setPrecio(rs.getInt("Precio"));
                revisiones.add(co);
            }
            

        } catch (SQLException ex) {
            Logger.getLogger(JFrame2.class.getName()).log(Level.SEVERE, null, ex);

        } finally {
            try {
                coche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
        return coches;
    }
}
