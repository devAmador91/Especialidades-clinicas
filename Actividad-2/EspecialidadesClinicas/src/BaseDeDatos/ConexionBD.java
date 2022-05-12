package BaseDeDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionBD {

    String usuario = "root";
    String password = "";
    String strBaseDatos = "jdbc:mysql://localhost:3306/especialidadesclinicasbd";
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet respuesta = null;
    String nombreTabla;

    public ConexionBD() {

        //Conectar a base de datos
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(strBaseDatos, usuario, password);

            System.out.println("Conexion establecida con exito");

        } catch (Exception e) {
            System.out.println("Error de conexion: " + e.getMessage());
        }

    }

    //Metodo para ejecutar sentencias SQL
    public int ejecutarSentenciaSQL(String strSentenciaSQL) {

        try {
            pstm = conn.prepareStatement(strSentenciaSQL);
            pstm.execute(); // ejecutar

            return 1;
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        }
    }

    //Metodo para recuperar datos de la base de datos
    public ResultSet consultarRegistros(String strSentenciaSQL) {
        try {
            pstm = conn.prepareStatement(strSentenciaSQL);
            respuesta = pstm.executeQuery(); //Devolver
            return respuesta;
        } catch (SQLException e) {
            System.out.println(e);
        }

        return null;
    }
}
