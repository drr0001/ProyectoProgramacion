package model;


import controller.ControladorRevision;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.table.AbstractTableModel;
import model.Revision;

/*Create a Java TableModel class with name TableModel_ITV without comments*/

public class TableModel_ITV extends AbstractTableModel {
    private static final String[] columnNames = {"codigo", "fecha", "matricula", 
    "filtro", "aceite","frenos"};
    private final LinkedList<Revision> list;
    private ControladorRevision conn;
    
    public TableModel_ITV(ControladorRevision conexion) {
        list = new LinkedList<>();
        conn = conexion;
    }
    public Revision getValueAt(int rowIndex) {
        return list.get(rowIndex);
    }
    public void cargarRevisiones() throws SQLException {
     
        ArrayList<Revision> revisiones = conn.actualizarRevision();
        System.out.println(revisiones.size());
        
        list.clear();
        list.addAll(revisiones);
       
        fireTableDataChanged();
    }
    public void insertarRevision(Revision revision) throws SQLException {
        conn.insertarRevision(revision);
        cargarRevisiones();
    }
    public void borrarRevision(int codigo) throws SQLException {
        conn.borrarRevision(codigo);
        cargarRevisiones();
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

     @Override  //Devuelve el nombre de la columna en función del índice que se pasa como parámetro. 
     //Este método es necesario para pintar los nombres de las columnas en la tabla. 

     public String getColumnName(int columnIndex) { 

         return columnNames[columnIndex]; 

     } 

      @Override //Devuelve el valor que hay en una celda concreta, en función de los índices que se pasan como parámetros. 

      public Object getValueAt(int rowIndex, int columnIndex) { 

          switch (columnIndex) { 

              case 0: return list.get(rowIndex).getCodigo();  

              case 1: return list.get(rowIndex).getFecha();

              case 2: return list.get(rowIndex).getMatricula();  

              case 3: return list.get(rowIndex).getFiltro();

              case 4: return list.get(rowIndex).getAceite();

              case 5: return list.get(rowIndex).getFrenos();

              default: return null; 

          } 

      } 
}