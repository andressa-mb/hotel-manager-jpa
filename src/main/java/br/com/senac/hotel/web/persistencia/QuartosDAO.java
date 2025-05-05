package br.com.senac.hotel.web.persistencia;

import br.com.senac.hotel.web.Models.Quartos;
import br.com.senac.hotel.web.conection.JPAUtil;
import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class QuartosDAO {

    public Integer obterProximoId() {
        EntityManager manager = JPAUtil.getEntityManager();
        Integer proximoId = 1;
        try {
            Integer maxId = (Integer) manager.createQuery("SELECT MAX(quarto.id) FROM Quartos quarto").getSingleResult();
            if (maxId != null) {
                proximoId = maxId + 1;
            }
        } catch (Exception exception) {
            System.out.println("Erro ao obter próximo ID: " + exception.getMessage());
        }
        return proximoId;
    }

    public void cadastrar(Quartos quarto) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(quarto);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Quartos> getQuartos() {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Quartos> consulta = manager.createQuery("SELECT quarto FROM Quartos quarto", Quartos.class);
            return consulta.getResultList();
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Quartos> filtrarQuartos(int adultos, int criancas, int valorMaximo, LocalDate dataCheckin, LocalDate dataPrevCheckout) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            String jpql = "SELECT quarto FROM Quartos quarto "
                    + "WHERE quarto.valor_diaria <= :valorMaximo "
                    + "AND quarto.capacidadeAdultos >= :adultos "
                    + "AND quarto.capacidadeCriancas >= :criancas "
                    + "AND quarto.id NOT IN ("
                    + "    SELECT reserva.quarto.id FROM Reserva reserva "
                    + "    WHERE reserva.dataCheckin <= :dataPrevCheckout "
                    + "    AND reserva.dataPrevCheckout >= :dataCheckin"
                    + ")";

            TypedQuery<Quartos> query = manager.createQuery(jpql, Quartos.class);
            query.setParameter("valorMaximo", valorMaximo);
            query.setParameter("adultos", adultos);
            query.setParameter("criancas", criancas);
            query.setParameter("dataCheckin", dataCheckin);
            query.setParameter("dataPrevCheckout", dataPrevCheckout);

            return query.getResultList();

        } catch (Exception exception) {
            System.out.println("Erro ao filtrar quartos: " + exception.getMessage());
            return null;
        }
    }

    public void editar(Quartos quarto) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(quarto);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(int id) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            Quartos quarto = manager.find(Quartos.class, id);
            if (quarto != null) {
                manager.getTransaction().begin();
                manager.remove(quarto);
                manager.getTransaction().commit();
            }
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
