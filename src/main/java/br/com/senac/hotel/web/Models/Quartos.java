package br.com.senac.hotel.web.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Quartos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int numero;
    private String tipo;
    private boolean disponivel;
    private double valor_diaria;
    private String comodidades;
    @Column(name = "capacidade_adultos")
    private int capacidadeAdultos;
    @Column(name = "capacidade_criancas")
    private int capacidadeCriancas;

    public Quartos() {

    }

    public Quartos(int id, int numero, String tipo, boolean disponivel, double valor_diaria, String comodidades) {
        this.id = id;
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = disponivel;
        this.valor_diaria = valor_diaria;
        this.comodidades = comodidades;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public double getValor_diaria() {
        return valor_diaria;
    }

    public void setValor_diaria(double valor_diaria) {
        this.valor_diaria = valor_diaria;
    }

    public String getComodidades() {
        return comodidades;
    }

    public void setComodidades(String comodidades) {
        this.comodidades = comodidades;
    }

    public int getCapacidadeAdultos() {
        return capacidadeAdultos;
    }

    public void setCapacidadeAdultos(int capacidadeAdultos) {
        this.capacidadeAdultos = capacidadeAdultos;
    }

    public int getCapacidadeCriancas() {
        return capacidadeCriancas;
    }

    public void setCapacidadeCriancas(int capacidadeCriancas) {
        this.capacidadeCriancas = capacidadeCriancas;
    }

}
