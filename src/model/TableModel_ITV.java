package model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import controller.ConexionMySql;
import controller.Controlador;
import java.sql.ResultSet;
import model.Coche;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author MEDAC
 */
public class TableModel_ITV extends AbstractTableModel {

    private static final String[] columnNames = {"Codigo", "Matricula",
        "Filtro", "Aceite", "Freno"};
    private final LinkedList<Revision> list;
    private final LinkedList<Coche> list2;
    ConexionMySql cnn;

    public TableModel_ITV(ConexionMySql conexion) {
        list = new LinkedList<>();
        cnn = conexion;
        list2 = new LinkedList<>();
    }

    public void cargarRevisiones() throws SQLException {

        String consulta = "SELECT * FROM `revision`;";

        ResultSet resultado = cnn.ejecutarSelect(consulta);

        ArrayList<Revision> revisiones = new ArrayList<>();
        while (resultado.next()) {
            Revision re = new Revision();
            re.setCodigo(resultado.getInt("Codigo"));
            re.setMatricula(resultado.getString("matricula"));
            re.setFiltro(resultado.getBoolean("Filtro"));
            re.setAceite(resultado.getBoolean("Aceite"));
            re.setFrenos(resultado.getBoolean("Frenos"));
            revisiones.add(re);
        }

        System.out.println(revisiones.size());

        list.clear();
        list.addAll(revisiones);

        fireTableDataChanged();
    }

    // cargarRevisionesCoches
    public void cargarRevisionesMatricula(String matricula) throws SQLException {

        String consulta = "SELECT * FROM revision WHERE matricula='" + matricula + "'";

        ResultSet resultado = cnn.ejecutarSelect(consulta);

        ArrayList<Revision> revisiones = new ArrayList<>();
        while (resultado.next()) {
            Revision re = new Revision();
            re.setCodigo(resultado.getInt("Codigo"));
            re.setMatricula(resultado.getString("matricula"));
            re.setFiltro(resultado.getBoolean("Filtro"));
            re.setAceite(resultado.getBoolean("Aceite"));
            re.setFrenos(resultado.getBoolean("Frenos"));
            revisiones.add(re);
        }

        System.out.println(revisiones.size());

        list.clear();
        list.addAll(revisiones);

        fireTableDataChanged();
    }
    // Cargar datos itv, lo llamas desde el boton cargar datos del j5

    public Revision cargarDatosCoche(String matricula) throws SQLException {
        String consulta = "SELECT * FROM `revision` ";
        ResultSet resultado = cnn.ejecutarSelect(consulta);
        Revision revision = null;
        while (resultado.next()) {
            //revision = new Revision(resultado.getInt("Codigo"), resultado.getString("matricula"), resultado.getBoolean("filtro"), resultado.getString("aceite"), resultado.getString("frenos"));
        }
        return revision;
    }

    public void insertar(String codigo, String matricula1, String filtro1, String aceite1, String frenos1)
            throws SQLException {
        String consulta = "INSERT INTO revision(Codigo,Matricula,Filtro,Aceite,Frenos) VALUES ('" + codigo + "','" + matricula1 + "','" + filtro1 + "','" + aceite1 + "'," + frenos1 + "')";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);

        System.out.println(resultado);
    }

    public void eliminar(String codigo) throws SQLException {
        String consulta = "DELETE FROM revision WHERE codigo ='" + codigo + "' ";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);
        System.out.println(resultado);
    }

    public void actualizar(String codigo1, String matricula1, String filtro1, String aceite1, String frenos1, String matricula) throws SQLException {

        String consulta = "UPDATE revision SET codigo='" + codigo1 + "',matricula='" + matricula1 + "',filtro='" + filtro1 + "',aceite='" + aceite1 + "'frenos='" + frenos1 + "' WHERE matricula='" + matricula + "' ";
        int resultado = cnn.ejecutarInsertDeleteUpdate(consulta);
        System.out.println(resultado);
    }



    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getCodigo();
            case 1:
                return list.get(rowIndex).getMatricula();
            case 2:
                return list.get(rowIndex).isFiltro();
            case 3:
                return list.get(rowIndex).isAceite();
            case 4:
                return list.get(rowIndex).isFrenos();
        }
        return null;
    }
}
