package br.com.senac.hotel.web.Models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int perfilUsuarioId;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private String senha;
    private String preferencias;
    private LocalDate dataCadastro;

    public Usuarios(int id, int perfilUsuarioId, String nome, String endereco, String telefone, String email, String senha, String preferencias, LocalDate dataCadastro) {
        this.id = id;
        this.perfilUsuarioId = perfilUsuarioId;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.preferencias = preferencias;
        this.dataCadastro = LocalDate.now();
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getPerfilUsuarioNome() {
        PerfilUsuario perfil = PerfilUsuario.getPerfilById(this.perfilUsuarioId);
        return (perfil != null) ? perfil.getPerfilUsuario() : "Perfil não encontrado";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPerfilUsuarioId() {
        return perfilUsuarioId;
    }

    public void setPerfilUsuarioId(int perfilUsuarioId) {
        this.perfilUsuarioId = perfilUsuarioId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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

    public String getPreferencias() {
        return preferencias;
    }

    public void setPreferencias(String preferencias) {
        this.preferencias = preferencias;
    }
}
