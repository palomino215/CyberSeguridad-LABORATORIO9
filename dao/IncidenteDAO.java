package dao;

import model.Incidente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IncidenteDAO {

    public void crearIncidente(Incidente incidente) throws Exception {
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO incidentes(titulo,descripcion,severidad,usuario_id) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, incidente.getTitulo());
        ps.setString(2, incidente.getDescripcion());
        ps.setString(3, incidente.getSeveridad());
        ps.setInt(4, incidente.getUsuarioId());

        ps.executeUpdate();
        con.close();
    }

    public List<Incidente> listarIncidentes() throws Exception {
        List<Incidente> lista = new ArrayList<>();
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM incidentes";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Incidente i = new Incidente();
            i.setId(rs.getInt("id"));
            i.setTitulo(rs.getString("titulo"));
            i.setDescripcion(rs.getString("descripcion"));
            i.setSeveridad(rs.getString("severidad"));
            i.setEstado(rs.getString("estado"));
            i.setUsuarioId(rs.getInt("usuario_id"));
            lista.add(i);
        }

        con.close();
        return lista;
    }
}
