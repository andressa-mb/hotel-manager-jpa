package br.com.senac.hotel.web.persistencia;

import br.com.senac.hotel.web.Models.Quartos;
import br.com.senac.hotel.web.Models.Reserva;
import br.com.senac.hotel.web.conection.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReservaDAO {

    public Integer obterProximoId() {
        EntityManager manager = JPAUtil.getEntityManager();
        Integer proximoId = 1;
        try {
            Integer maxId = (Integer) manager.createQuery("SELECT MAX(reserva.id) FROM Reserva reserva").getSingleResult();
            if (maxId != null) {
                proximoId = maxId + 1;
            }
        } catch (Exception exception) {
            System.out.println("Erro ao obter próximo ID: " + exception.getMessage());
        }
        return proximoId;
    }

    public void cadastrar(Reserva reserva) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(reserva);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void editarReserva(Reserva reserva) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(reserva);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluirReserva(int id) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            Reserva reserva = manager.find(Reserva.class, id);
            if (reserva != null) {
                manager.getTransaction().begin();
                manager.remove(reserva);
                manager.getTransaction().commit();
            }
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Reserva> getReservas() {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Reserva> consulta = manager.createQuery("SELECT reserva FROM Reserva reserva", Reserva.class);
            return consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Reserva> getReservasUsuario(int hospedeId) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Reserva> query = manager.createQuery(
                    "SELECT reserva FROM Reserva reserva WHERE reserva.hospedeId = :hospedeId", Reserva.class);
            query.setParameter("hospedeId", hospedeId);
            return query.getResultList();
        } catch (Exception exception) {
            System.out.println("Erro ao listar reservas do usuário: " + exception.getMessage());
            return new ArrayList<>();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Quartos> getQuartosReservados(int quartoId) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Quartos> query = manager.createQuery(
                    "SELECT reserva.quarto FROM Reserva reserva WHERE reserva.quarto.id = :quartoId", Quartos.class);
            query.setParameter("quartoId", quartoId);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao buscar quartos reservados: " + e.getMessage());
            return new ArrayList<>();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public boolean getDisponibilidadeQuarto(int quartoId, LocalDate checkin, LocalDate prevCheckout) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Long> query = manager.createQuery(
                    "SELECT COUNT(reserva) FROM Reserva reserva "
                    + "WHERE reserva.quarto.id = :quartoId "
                    + "AND reserva.dataCheckin <= :prevCheckout "
                    + "AND reserva.dataPrevCheckout >= :checkin", Long.class);
            query.setParameter("quartoId", quartoId);
            query.setParameter("prevCheckout", prevCheckout);
            query.setParameter("checkin", checkin);

            Long total = query.getSingleResult();
            return total == 0;
        } catch (Exception exception) {
            System.out.println("Erro ao verificar a disponibilidade do quarto: " + exception.getMessage());
            return false;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
