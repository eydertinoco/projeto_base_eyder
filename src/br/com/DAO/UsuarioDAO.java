package br.com.DAO;

import br.com.model.Usuario;
import br.com.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public List<Usuario> consultarUsuario(){
        List<Usuario> listaUsuario = new ArrayList<>();

        String sql = "select usuario.id, usuario.email, usuario.senha, " +
                "     usuario.nome, usuario.genero, usuario.dataNasc, usuario.dataCriacao," +
                "     usuario.dataEdicao from impact.usuario order by id ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Usuario c = new Usuario();
                c.setId(rs.getInt("id"));
                c.setEmail(rs.getString("email"));
                c.setSenha(rs.getString("senha"));
                c.setNome(rs.getString("nome"));
                c.setGenero(rs.getString("genero"));
                c.setDataNasc((rs.getDate("datanasc")));
                c.setDataCriacao((rs.getDate("datacriacao")));
                c.setDataEdicao((rs.getDate("dataedicao")));
                listaUsuario.add(c);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
        return listaUsuario;
    }


    public void cadastrar(Usuario usuario) {
        String sql = "INSERT INTO impact.usuario " +
                "(email, senha, nome, genero, dataNasc) " +
                "VALUES (?, ?, ?, ?, ?) ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getGenero());
            ps.setDate(5, new java.sql.Date(usuario.getDataNasc().getTime()));
            //ps.setDate(6, new java.sql.Date(usuario.getDataNasc().getTime()));
            ps.execute();
            conexao.commit();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Boolean autenticar(Usuario usuario) {
        String sql = "select id " +
                "from impact.usuario u " +
                "where u.email ilike ? " +
                "and u.senha = ?";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public Usuario consultarPorEmail(Usuario usuario) {
        String sql = "select id, email, senha, nome " +
                "from impact.usuario u " +
                "where u.email = ? ";
        Connection conexao = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, usuario.getEmail());
            ResultSet rs = ps.executeQuery();
            Usuario u = new Usuario();
            if(rs.next()){
                u.setId(rs.getInt("id"));
                u.setEmail(rs.getString("email"));
                u.setNome(rs.getString("nome"));
                u.setSenha(rs.getString("senha"));
            }
            return u;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } finally {
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
