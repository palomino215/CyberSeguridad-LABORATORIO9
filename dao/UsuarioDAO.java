package dao;

import model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void crearUsuario(Usuario usuario) throws Exception {
        Connection con = Conexion.getConexion();
        String sql = "INSERT INTO usuarios(nombre,email,rol) VALUES(?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getNombre());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getRol());

        ps.executeUpdate();
        con.close();
    }

    public List<Usuario> listarUsuarios() throws Exception {
        List<Usuario> lista = new ArrayList<>();
        Connection con = Conexion.getConexion();
        String sql = "SELECT * FROM usuarios";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNombre(rs.getString("nombre"));
            u.setEmail(rs.getString("email"));
            u.setRol(rs.getString("rol"));
            lista.add(u);
        }

        con.close();
        return lista;
    }
}
