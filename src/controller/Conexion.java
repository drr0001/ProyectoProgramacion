/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

/**
 *
 * @author usuario
 */
public class Conexion {

   

    private String BD;
    //Usuario con el que nos conectamos
    private String USUARIO;
    //Contraseña del usuario
    private String PASS;
    //zona horaria
    private String HOST;
    //indica que esta en 
    private Calendar now;
    //zona horaria
    private TimeZone zonahoraria;
    static Connection connection;

    /**
     *
     * @param BD
     * @param USUARIO
     * @param PASS
     * @param HOST
     */
    public Conexion(String BD, String USUARIO, String PASS, String HOST) {
        this.BD = BD;
        this.USUARIO = USUARIO;
        this.PASS = PASS;
        this.HOST = HOST;
        this.now = Calendar.getInstance();
        this.zonahoraria = now.getTimeZone();
    }

    /**
     * @brief conectar
     * @throws SQLException con este metodo nos conectaremos a la BD
     */
    public void conectar() throws SQLException {

        connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://" + HOST + "/" + BD + "?user="
                + USUARIO + "&password=" + PASS
                + "&useLegacyDatetimeCode=false&serverTimezone="
                + zonahoraria.getID());
        System.out.println("-----||CONECTADO||-----");

    }
    public Connection getConexion() throws SQLException {

        connection = (Connection) DriverManager.getConnection(
                "jdbc:mysql://" + HOST + "/" + BD + "?user="
                + USUARIO + "&password=" + PASS
                + "&useLegacyDatetimeCode=false&serverTimezone="
                + zonahoraria.getID());
        System.out.println("-----||CONECTADO||-----");
        return connection;

    }

    /**
     * @brief desconectar
     * @throws SQLException con este metodo desconectaremos una BD
     */
    public void desconectar() throws SQLException {

        if (connection != null && !connection.isClosed()) {
            connection.close();

        }
        System.out.println("--------||DESCONECTADO||--------");
    }

    /**
     * @brief ejecutarSelect
     * @param consulta
     * @return rs
     * @throws SQLException con este metodo podremos realizar una conusulta en
     * nuestra basre de datos
     */
    public ResultSet ejecutarSelect(String consulta) throws SQLException {
        Statement pst = connection.createStatement();
        ResultSet rs = pst.executeQuery(consulta);
        return rs;
    }

    /**
     * @brief ejecutarInsertDeleteUpdate
     * @param insert
     * @throws SQLException ejecutamos una modificacion en la BD
     */
    public void ejecutarInsertDeleteUpdate(String insert) throws SQLException {
        Statement st = connection.createStatement();
        st.executeUpdate(insert);
    }
    
}
