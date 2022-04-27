/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.j1;

/**Esta es la clase para añadir los registros en la tabla
 *me da error, he tenido que hacer estos metodos desde el jFrame
 * @author usuario
 */
public class TablaModelo {
 public TablaModelo() {
        initComponents();
        
    }
   
 /**metodo para mostrar los coches en la tabla
  * 
  * @param consulta
  * @param jTable2
  * @return 
  */
    public JTable mostrarCoches(String consulta,JTable jTable2) {
        
        
        try {

            Statement st;
            Conexion con = new Conexion("itv", "root", "", "localhost");
            Connection connection = con.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Matricula");
            model.addColumn("Marca");
            model.addColumn("Modelo");
            model.addColumn("Color");
            model.addColumn("Precio");
            model.addColumn("Dni");
            jTable2.setModel(model);

            

            String[] Coches = new String[6];
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Coches[0] = rs.getString(1);
                Coches[1] = rs.getString(2);
                Coches[2] = rs.getString(3);
                Coches[3] = rs.getString(4);
                Coches[4] = rs.getString(5);
                Coches[5] = rs.getString(6);

                model.addRow(Coches);

            }

        } catch (SQLException ex) {
            
        }
     return jTable2;

    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     /**metodo para mostrar las revisiones en la tabla
      * 
      * @param consulta
      * @param jTable2 
      */
     public void mostrarRevisiones(String consulta, JTable jTable1) {
        try {

            Statement st;
            Conexion con = new Conexion("itv", "root", "", "localhost");
            Connection connection = con.getConexion();
            DefaultTableModel model = new DefaultTableModel();
            model.addColumn("Codigo");
            model.addColumn("Matricula");
            model.addColumn("Filtro");
            model.addColumn("Aceite");
            model.addColumn("Frenos");
          
            jTable1.setModel(model);

            String[] Revisiones = new String[5];
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(consulta);
            while (rs.next()) {
                Revisiones[0] = rs.getString(1);
                Revisiones[1] = rs.getString(2);
                Revisiones[2] = rs.getString(3);
                Revisiones[3] = rs.getString(4);
                Revisiones[4] = rs.getString(5);
                

                model.addRow( Revisiones);

            }

        } catch (SQLException ex) {
            Logger.getLogger(j1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
