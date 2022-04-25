package controller;

import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     public void insertCliente(String Codigo,Boolean Flitro, Boolean Aceite, Boolean Frenos ,Date Fecha, String Matricula) throws SQLException {
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

    public void deleteCoche(String Codigo) throws SQLException {
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
}
