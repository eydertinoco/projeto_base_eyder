package br.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Usuario implements Serializable {

    private Integer id;
    private String email;
    private String senha;
    private String nome;
    private String genero;
    private Date dataNasc;
    private Date dataCriacao;
    private Date dataEdicao;

    public Usuario() {
    }

    public Usuario(Integer id, String email, String senha,
                   String nome, String genero, Date dataNasc, Date dataCriacao, Date dataEdicao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.genero = genero;
        this.dataNasc = dataNasc;
        this.dataCriacao = dataCriacao;
        this.dataEdicao = dataEdicao;
    }

    // ==========================================
    // Getter e Setter
    // ==========================================

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataEdicao() {
        return dataEdicao;
    }
    public void setDataEdicao(Date dataEdicao) {
        this.dataEdicao = dataEdicao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(genero, usuario.genero) &&
                Objects.equals(dataNasc, usuario.dataNasc) &&
                Objects.equals(dataCriacao, usuario.dataCriacao) &&
                Objects.equals(dataEdicao, usuario.dataEdicao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, senha, nome, genero, dataNasc, dataCriacao, dataEdicao);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", dataNasc=" + dataNasc +
                ", dataCriacao=" + dataCriacao +
                ", dataEdicao=" + dataEdicao +
                '}';
    }
}

