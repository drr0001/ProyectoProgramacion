/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.Conexion;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MEDAC-INVITADO
 */
public class ControladorCLiente {

    Conexion conCliente = new Conexion("itv", "root", "", "localhost");
    static Connection connection;

    public void insertCliente(String DNI, String Nombre, String Ciudad, String Direccion, int TLF) throws SQLException {
        String consulta = "";

        conCliente.getConexion();
        consulta = "INSERT INTO cliente(DNI,Nombre,Ciudad,Direccion,TLF) VALUES (" + "'" + DNI + "'," + "'" + Nombre + "'," + "'" + Ciudad + "'," + "'" + Direccion + "'," + TLF + "'" + "); ";

        try {
            conCliente.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conCliente.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }

    public void editarCliente(String matricula, String Dni) throws SQLException {
        String consulta = "";
        conCliente.getConexion();
        consulta = " UPDATE coche SET dni='"+Dni+"' WHERE matricula='"+matricula+"'";
        try {
            conCliente.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conCliente.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }

}
