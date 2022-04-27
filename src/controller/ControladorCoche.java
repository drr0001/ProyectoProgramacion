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
public class ControladorCoche {

    Conexion conCoche = new Conexion("itv", "root", "", "localhost");
    static Connection connection;

    public void insertCoche(String Matricula1, String Marca1, String Modelo1, String Color1, int Precio1, String Dni1) throws SQLException {

        String consulta = "";
        conCoche.getConexion();
        consulta = "INSERT INTO coche(Matricula,Marca,Modelo,Color, Precio, Dni) VALUES ('" + Matricula1 + "','" + Marca1 + "','" + Modelo1 + "','" + Color1 + "'," + Precio1 + ",'" + Dni1 + "'); ";

        try {
            conCoche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conCoche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }

    public void deleteCoche(String matricula) throws SQLException {
        String consulta = "";
        conCoche.getConexion();
        consulta = "DELETE FROM `coche` WHERE matricula = " + "'" + matricula + "';";

        try {
            conCoche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conCoche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }

    public void editarCoche(String matricula1, String marca1, String modelo1, String color1, int precio1, String Dni1) throws SQLException {
        String consulta = "";
        conCoche.getConexion();
        consulta = "UPDATE coche SET matricula='" + matricula1 + "',marca='" + marca1 + "',modelo='" + modelo1 + "',color='" + color1 + "',precio='" + precio1 + "' WHERE matricula='" + matricula1 + "' ";
        try {
            conCoche.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conCoche.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }

    public void buscarMatricula(String matricula) throws SQLException {
        String consulta = "";
        conCoche.getConexion();
        consulta = "SELECT cliente.nombre,cliente.ciudad,cliente.direccion,cliente.telf,cliente.dni from coche,cliente where coche.dni=cliente.dni and coche.matricula='" + matricula + "'";
    }

    public void cargarCoche() throws SQLException {
        String consulta = "";
        conCoche.getConexion();
        consulta="SELECT * FROM coche";
    }
}
