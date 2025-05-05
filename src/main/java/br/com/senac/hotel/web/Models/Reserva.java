package br.com.senac.hotel.web.Models;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int hospedeId;
    private int quartoId;
    private LocalDate dataCheckin;
    private LocalDate dataPrevCheckout;
    private LocalDate dataCheckout;
    private int status; //1-confirmado 2- cancelado 3-pendente
    private String detalhesPagamento; //Dinheiro - cartão de crédito - cartão de débito

    public Reserva() {

    }

    public Reserva(int id, int hospedeId, int quartoId, LocalDate checkin, LocalDate prevCheckout, LocalDate checkout, int status, String detalhesPagamento) {
        this.id = id;
        this.hospedeId = hospedeId;
        this.quartoId = quartoId;
        this.dataCheckin = checkin;
        this.dataPrevCheckout = prevCheckout;
        this.dataCheckout = (checkout != null) ? checkout : null;
        this.status = status;
        this.detalhesPagamento = detalhesPagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospedeId() {
        return hospedeId;
    }

    public void setHospedeId(int hospedeId) {
        this.hospedeId = hospedeId;
    }

    public int getQuartoId() {
        return quartoId;
    }

    public void setQuartoId(int quartoId) {
        this.quartoId = quartoId;
    }

    public LocalDate getDataCheckin() {
        return dataCheckin;
    }

    public void setDataCheckin(LocalDate dataCheckin) {
        this.dataCheckin = dataCheckin;
    }

    public LocalDate getDataPrevCheckout() {
        return dataPrevCheckout;
    }

    public void setDataPrevCheckout(LocalDate dataPrevCheckout) {
        this.dataPrevCheckout = dataPrevCheckout;
    }

    public LocalDate getDataCheckout() {
        return dataCheckout;
    }

    public void setDataCheckout(LocalDate dataCheckout) {
        this.dataCheckout = dataCheckout;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetalhesPagamento() {
        return detalhesPagamento;
    }

    public void setDetalhesPagamento(String detalhesPagamento) {
        this.detalhesPagamento = detalhesPagamento;
    }

}
