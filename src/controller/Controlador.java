/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;
/**
 *
 * @author MEDAC-INVITADO
 */
public class Controlador {
    ConexionMySql cnn = new ConexionMySql();//inicializar en el metodo conectar
     public void conectar() throws SQLException{
        cnn.conectar();
    }
    public void createCliente(String dni, String nombre, String direccion, String ciudad, int telefono) throws SQLException{
        String consulta ="INSERT INTO cliente (dni, nombre, direccion, ciudad, telefono) VALUES ("+dni+","+nombre+","+direccion+","+ciudad+","+telefono+")";
        cnn.ejecutarInsertDeleteUpdate(consulta);
    }
   
            

}
