/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author MEDAC-INVITADO
 */
public class ControladorRevisiones {

    Conexion conFiltro = new Conexion("itv", "root", "", "localhost");
    static Connection connection;

    public void insertRevision(String codigo1, String matricula1, String filtro1, String aceite1, String frenos1) throws SQLException {

        String consulta = "";
        conFiltro.getConexion();
        consulta = "INSERT INTO revision(codigo,matricula,filtro, aceite, frenos) VALUES ('" + codigo1 + "','" + matricula1 + "','" + filtro1 + "','" + aceite1 + "','" + frenos1 + "')";

        try {
            conFiltro.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conFiltro.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }

    public void deleteRevision(String codigo) throws SQLException {
        String consulta = "";
        conFiltro.getConexion();
        consulta = "DELETE FROM revision WHERE codigo ='" + codigo + "' ";

        try {
            conFiltro.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conFiltro.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }

    }
        public void editarRevision(String codigo1, String matricula1, String filtro1, String aceite1, String frenos1) throws SQLException {
        String consulta = "";
        conFiltro.getConexion();
        consulta = "UPDATE revision SET codigo='" + codigo1 + "',filtro='" + filtro1 + "',matricula='" + matricula1 + "',aceite='" + aceite1 + "',frenos='" + frenos1 + "' WHERE matricula='" + matricula1 + "' ";
        try {
            conFiltro.ejecutarInsertDeleteUpdate(consulta);

        } catch (SQLException ex) {

        } finally {
            try {
                conFiltro.desconectar();
            } catch (SQLException ex) {
                System.out.println("Error" + ex.toString());
            }

        }
    }
    
}
