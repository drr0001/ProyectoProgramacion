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
 * @date 24/03/2021
 * @author Dani
 * @version 1.0
 */
public class ConexionMySQL {//atributos
    private String HOST;
    private String USUARIO;
    private String PASS;
    private String BD;
    Connection connection = null;
    
    /**
     * Constructor con parametros
     * @param host
     * @param usuario
     * @param pass
     * @param bd 
     */
    public ConexionMySQL(String host, String usuario, String pass, String bd) {
        this.HOST = host;
        this.USUARIO = usuario;
        this.PASS = pass;
        this.BD = bd;
    }

    public String getHost() {//getters y setters
        return HOST;
    }

    public String getUsuario() {
        return USUARIO;
    }

    public String getPass() {
        return PASS;
    }

    public String getBd() {
        return BD;
    }

    public void setHost(String host) {
        this.HOST = host;
    }

    public void setUsuario(String usuario) {
        this.USUARIO = usuario;
    }

    public void setPass(String pass) {
        this.PASS = pass;
    }

    public void setBd(String bd) {
        this.BD = bd;
    }
    /**
     * Metodo para conectar la base de datos
     * @throws SQLException 
     */
    public void conectar()throws SQLException{
        if(connection == null || connection.isClosed()){
            Calendar now = Calendar.getInstance();
            TimeZone zonahoraria=now.getTimeZone();
            connection = (Connection) DriverManager.getConnection("jdbc:mysql://" + HOST +"/"+BD+"?user="+ USUARIO + "&password=" + PASS+"&useLegacyDatetimeCode=false&serverTimerzone="+zonahoraria.getID());
            System.out.println("CONECTADO");
        }
    }
    /**
     * Metodo para desconectar la base de datos
     * primero comprobamos si la base de datos esta desconectada
     * @throws SQLException 
     */
    public void desconectar()throws SQLException{
        if(connection!=null&&!connection.isClosed()){
            connection.close();
        }
    }
    /**
     *  Metodo para realizar consultas sql pasandole por parametro una consulta
     * @param Consulta
     * @return
     * @throws SQLException 
     */
    public ResultSet ejecutarSelect(String Consulta)throws SQLException{
        Statement stat = connection.createStatement();
        ResultSet rset = stat.executeQuery(Consulta);
        return rset;
    }
    /**
     * Metodo para realizar insert, delete o update
     * @param consulta
     * @return
     * @throws SQLException 
     */
    public boolean ejecutarInsertDeleteUpdate(String consulta)throws SQLException{
        Statement stmt = connection.createStatement();
        int filas_afectadas = stmt.executeUpdate(consulta);
        if(filas_afectadas>0){
            return true;
        }else{
            return false;
        }
        
        
    }
}
