package datos;

import static datos.Conexion.*;
import domain.Alumnos;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlumnosDAO {

    private static final String SQL_SELECT = "SELECT id_alumno, nombre, apellido, dni FROM alumnos";
    private static final String SQL_INSERT = "INSERT INTO alumnos(nombre, apellido, dni) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE alumnos SET nombre = ?, apellido = ?, dni = ? WHERE id_alumno = ?";
    private static final String SQL_DELETE = "DELETE FROM alumnos WHERE id_alumno = ?";
    
    public List<Alumnos> seleccionar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Alumnos alumno = null;
        List<Alumnos> alumnos = new ArrayList<>();

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_alumno = rs.getInt("id_alumno");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int dni = rs.getInt("dni");
                

                alumno = new Alumnos(id_alumno, nombre, apellido, dni);

                alumnos.add(alumno);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return alumnos;
    }
    
    public int insertar(Alumnos alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getDNI());
            
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public int actualizar(Alumnos alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, alumno.getNombre());
            stmt.setString(2, alumno.getApellido());
            stmt.setInt(3, alumno.getDNI());
            stmt.setInt(4, alumno.getIdAlumno());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
     public int eliminar(Alumnos alumno){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, alumno.getIdAlumno());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            try {
                close(stmt);
                close(conn);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
}
