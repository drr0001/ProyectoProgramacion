/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoprogramacion;

import controller.ConexionMySql;
import controller.Controlador;
import java.sql.SQLException;

/**
 *
 * @author Dani
 */
public class ProyectoProgramacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Controlador cnn = new Controlador();
        cnn.conectar();
    }

}
