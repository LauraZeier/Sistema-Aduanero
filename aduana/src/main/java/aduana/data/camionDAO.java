package aduana.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aduana.model.Camion;
import aduana.model.Conductor;

public class camionDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/aduana";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static final String SQL_SELECT = "SELECT c.*, co.* " +
                                              "FROM camion c " +
                                              "INNER JOIN conductor co ON c.id_camion = co.id_camion";

    private static final String SQL_INSERT = "INSERT INTO camion (nombre_empresa, tipo_carga, pais_origen, pais_destino, acoplado, peso_carga) " +
                                             "VALUES (?, ?, ?, ?, ?, ?)";
    public List<Camion> listar() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Camion camion = null;

        List<Camion> camiones = new ArrayList<>();

        try {
            conn = Conexion.getConexion();
            ps = conn.prepareStatement(SQL_SELECT);
            rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id_camion");
                String nombreEmpresa = rs.getString("nombre_empresa");
                String tipoCarga = rs.getString("tipo_carga");
                String paisOrigen = rs.getString("pais_origen");
                String paisDestino = rs.getString("pais_destino");
                boolean acoplado = rs.getBoolean("acoplado");
                double pesoCarga = rs.getDouble("peso_carga");

                
                int idConductor = rs.getInt("id_conductor");
                String nombreConductor = rs.getString("nombre");
                String apellidoConductor = rs.getString("apellido");
                int edadConductor = rs.getInt("edad");
                String nacionalidadConductor = rs.getString("nacionalidad");
                String numeroLicencia = rs.getString("numero_licencia");

                Conductor conductor = new Conductor(nombreConductor, apellidoConductor, edadConductor,
                        nacionalidadConductor, numeroLicencia);

                camion = new Camion(id, nombreEmpresa, tipoCarga, paisOrigen, paisDestino, acoplado, (double) pesoCarga,
                        conductor);
                camiones.add(camion);
                
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                Conexion.close(rs);
                Conexion.close(ps);
                Conexion.close(conn);
            } catch (Exception e) {
                e.printStackTrace(System.out);
            }
        }

        
        return camiones;
    }

    
    public static void insertar(Camion camion) {
        Connection conn = null;
        PreparedStatement stmtCamion = null;
        PreparedStatement stmtConductor = null;;
    
        try {
            conn = Conexion.getConexion();
            conn.setAutoCommit(false); 

            String sqlInsert = "INSERT INTO camion (nombre_empresa, tipo_carga, pais_origen, pais_destino, acoplado, peso_carga) VALUES (?, ?, ?, ?, ?, ?)";
            stmtCamion = conn.prepareStatement(sqlInsert);
            stmtCamion.setString(1, camion.getNombreEmpresa());
            stmtCamion.setString(2, camion.getTipoCarga());
            stmtCamion.setString(3, camion.getPaisOrigen());
            stmtCamion.setString(4, camion.getPaisDestino());
            stmtCamion.setBoolean(5, camion.isAcoplado());
            stmtCamion.setDouble(6, camion.getPesoCarga());
            int filasInsertadasCamion =  stmtCamion.executeUpdate();
                
            System.out.println("Camión insertado correctamente.");


            if (filasInsertadasCamion > 0) {
                ResultSet rs = stmtCamion.getGeneratedKeys();
                if (rs.next()) {
                    int idCamionGenerado = rs.getInt(1);
                    camion.setId(idCamionGenerado);
                }
            }

            // Insertar conductor si está asociado al camión
            Conductor conductor = camion.getConductor();
            if (conductor != null) {
                String sqlInsertConductor = "INSERT INTO conductor (nombre, apellido, edad, nacionalidad, numero_licencia, id_camion) " +
                                            "VALUES (?, ?, ?, ?, ?, ?)";
                stmtConductor = conn.prepareStatement(sqlInsertConductor);
                stmtConductor.setString(1, conductor.getNombre());
                stmtConductor.setString(2, conductor.getApellido());
                stmtConductor.setInt(3, conductor.getEdad());
                stmtConductor.setString(4, conductor.getNacionalidad());
                stmtConductor.setString(5, conductor.getNumeroLicencia());
                stmtConductor.setInt(6, camion.getId());

                stmtConductor.executeUpdate();
                conn.commit(); // Confirmar transacción
                System.out.println("Camión y Conductor insertados correctamente.");
            }


        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            try {
                if (stmtConductor != null) {
                    stmtConductor.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(System.out);
            } finally {
                try {
                    if (stmtCamion != null) {
                        stmtCamion.close();
                    }
                    if (stmtConductor != null) {
                        stmtConductor.close();
                    }
                    if (conn != null) {
                        conn.setAutoCommit(true); // Restaurar el modo de autocommit
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
    
     
    
}}
