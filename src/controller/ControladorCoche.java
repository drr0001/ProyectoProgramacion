package controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;
import view.JFrame2;

/**
 *
 * @author MEDAC-INVITADO
 */
public class ControladorCoche {

    public void insertCoche(String Matricula, String Marca, String Modelo, String Color, int Precio, String Dni) throws SQLException {
        String consulta = "";
        ConexionMySql coche = new ConexionMySql();

        coche.conectar();
        consulta = "INSERT INTO coche(Matricula,Marca,Modelo,Color, Precio, Dni) VALUES ('+Matricula +Marca +Color +Precio +Dni'); ";

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

    public void deleteCoche() throws SQLException {
        String consulta = "";
        ConexionMySql coche = new ConexionMySql();

        coche.conectar();
        consulta = "DELETE FROM `coche` WHERE matricula = ;";

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
