package br.com.controller;

import br.com.model.Usuario;
import br.com.service.UsuarioService;
import br.com.util.JSFUtil;
import br.com.util.SessionUtil;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.time.LocalDateTime;

import static br.com.util.JSFUtil.fecharDialog;

@ViewScoped
@ManagedBean(name = "usuarioMB")
public class  UsuarioController implements Serializable {
    private Usuario usuario;
    private String mensagemErroLogin;
    private UsuarioService usuarioService;
    private List<Usuario> listaUsuario;


    public UsuarioController() {
        this.usuario = new Usuario();
        this.mensagemErroLogin = null;
        this.usuarioService = new UsuarioService();
        this.listaUsuario = this.usuarioService.retornarListaUsuario();
    }

    public void cadastrarUsuario(){
        this.usuario = new Usuario();
        JSFUtil.redirectPage("cadastro");
    }

    public void acessarUsuario(){
        this.usuario = new Usuario();
        JSFUtil.abrirDialog("dlgAcesso");
    }

//    public void entrarContaUsuario(){
//        if (this.usuario.getUsuario().equals("") || this.usuario.getSenha().equals("")) {
//            this.mensagemErroLogin = "Email e Senha obrigatórios!";
//        } else {
//            Boolean logado = this.usuarioService.autenticar(usuario);
//            if (logado) {
//                fecharDialog("dlgAcesso");
//                JSFUtil.redirectPage("perfil");
//                SessionUtil.getInstance().gravarUsuario(this.usuarioService.consultarPorEmail(usuario));
//            } else {
//                this.mensagemErroLogin = "Email ou Senha incorretos!";
//            }
//        }
//    }

    public Boolean retornarSeEhCadastrar() {
        return usuario.getId() == null;
    }

    public void eleVaiEntrar(){
        if (usuario.getId() == null){
            acessarUsuario();
        } else {
            sair(usuario);
            System.out.println();
        }
    }

    public void salvar() {
        if (usuario.getId() == null) {
            this.usuarioService.cadastrarPessoa(this.usuario);
            JSFUtil.redirectPage("listaUsuarios");
        } else {
            this.usuarioService.editar(this.usuario);
        }
        this.listaUsuario = this.usuarioService.retornarListaUsuario();
        JSFUtil.fecharDialog("dlg");

    }

    //  Função do Botão Cancelar das abas de Cadastro e Editar.
    public void cancelar() {
        JSFUtil.fecharDialog("dlg");
        JSFUtil.fecharDialog("dlgAcesso");
    }

    public void sair(Usuario usuario){
        JSFUtil.redirectPage("home");
    }


    // ==================================
    // Getter e Setter
    // ==================================


    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getMensagemErroLogin() {
        return mensagemErroLogin;
    }

    public void setMensagemErroLogin(String mensagemErroLogin) {
        this.mensagemErroLogin = mensagemErroLogin;
    }

    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public List<Usuario> getListaUsuario() {
        return listaUsuario;
    }

    public void setListaUsuario(List<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
}
