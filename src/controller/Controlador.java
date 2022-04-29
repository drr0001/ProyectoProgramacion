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
import model.Coche;

import view.j1;

/**
 *
 * @author MEDAC-INVITADO
 */
public class Controlador {
    static ConexionMySql cnn;

    public static void main(String[] args) throws SQLException {
        // Creamos una conexión con la base de datos
        cnn=new ConexionMySql();
        cnn.conectar();
        
        // Inicializamos la vista 
        j1 jf = new j1(cnn);
        jf.setVisible(true);
    } 
}
