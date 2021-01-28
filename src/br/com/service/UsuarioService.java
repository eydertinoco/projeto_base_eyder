package br.com.service;

import br.com.DAO.UsuarioDAO;
import br.com.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService(){
        this.usuarioDAO = new UsuarioDAO();
    }

    public List<Usuario> retornarListaUsuario(){
        return this.usuarioDAO.consultarUsuario();
    }

    public void cadastrarPessoa(Usuario usuario) {
        usuarioDAO.cadastrar(usuario);
    }

    public Boolean autenticar(Usuario usuario) {
        return this.usuarioDAO.autenticar(usuario);
    }

    public Usuario consultarPorEmail(Usuario usuario) {
        return this.usuarioDAO.consultarPorEmail(usuario);
    }

    public void editar(Usuario usuario){
        //usuarioDAO.editar(usuario);
    }



}
