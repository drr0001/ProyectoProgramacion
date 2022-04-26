/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author Administrador-admin
 */
public class ConexionMySql {

    final String BD = "itv";
    final String USUARIO = "root";
    final String PASS = "";
    final String HOST = "localhost";
    Connection connection = null;

    public ConexionMySql() {

    }

    public void conectar() throws SQLException {
        Calendar now = Calendar.getInstance();
        TimeZone zonahoraria = now.getTimeZone();
        connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://" + HOST + "/" + BD + "?user=" + USUARIO + "&password=" + PASS + "&useLegacyDatetimeCode=false&serverTimezone=" + zonahoraria.getID());
        System.out.println("conectado");
    }

    public void desconectar() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
            System.out.println("desconectado");
        }
    }

    public ResultSet ejecutarSelect(String consulta) throws SQLException {
     
        Statement stmt = connection.createStatement();
        ResultSet resultado = stmt.executeQuery(consulta);
        return resultado;
    }

    public  void ejecutarInsertDeleteUpdate(String consulta)throws SQLException{
        Statement stmt = connection.createStatement();
        int resultado = stmt.executeUpdate(consulta);
        

    }
}


