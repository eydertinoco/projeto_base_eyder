package br.com.util;

import br.com.model.Usuario;

public class SessionUtil {
    public SessionUtil() {
        this.isLogado = false;
        this.userSession = new Usuario();
    }

    private static br.com.util.SessionUtil instance;
    private Usuario userSession;
    private Boolean isLogado;

    public static br.com.util.SessionUtil getInstance() {
        if (instance == null) {
            instance = new br.com.util.SessionUtil();
        }
        return instance;
    }

    public Usuario getUserSession() {
        return userSession;
    }

    public Boolean getLogado() {
        return isLogado;
    }

    public static void destruirSessao() {
        instance = new br.com.util.SessionUtil();
    }

    public void gravarUsuario(Usuario usuario) {
        this.userSession = usuario;
        this.isLogado = true;
    }

}
