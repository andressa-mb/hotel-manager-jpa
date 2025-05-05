package br.com.senac.hotel.web.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  //id 1 = Administrador / 2 = Operador / 3 = Hóspede
    private String perfilUsuario;
    private static List<PerfilUsuario> perfis;

    public PerfilUsuario(int id, String perfilUsuario) {
        this.id = id;
        this.perfilUsuario = perfilUsuario;
    }

    static {
        perfis = new ArrayList<>();
        perfis.add(new PerfilUsuario(1, "Administrador"));
        perfis.add(new PerfilUsuario(2, "Operador"));
        perfis.add(new PerfilUsuario(3, "Hóspede"));
    }

    public static PerfilUsuario getPerfilById(int id) {
        for (PerfilUsuario perfil : perfis) {
            if (perfil.getId() == id) {
                return perfil;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPerfilUsuario() {
        return perfilUsuario;
    }

    public void setPerfilUsuario(String perfilUsuario) {
        this.perfilUsuario = perfilUsuario;
    }
}
