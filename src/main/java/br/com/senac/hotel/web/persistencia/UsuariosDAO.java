package br.com.senac.hotel.web.persistencia;

import br.com.senac.hotel.web.Models.Usuarios;
import br.com.senac.hotel.web.conection.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author aulas
 */
public class UsuariosDAO {

    public Integer obterProximoId() {
        EntityManager manager = JPAUtil.getEntityManager();
        Integer proximoId = 1;
        try {
            Integer maxId = (Integer) manager.createQuery("SELECT MAX(usuario.id) FROM Usuarios usuario").getSingleResult();
            if (maxId != null) {
                proximoId = maxId + 1;
            }
        } catch (Exception exception) {
            System.out.println("Erro ao obter próximo ID: " + exception.getMessage());
        }
        return proximoId;
    }

    public void cadastrar(Usuarios usuario) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(usuario);
            manager.getTransaction().commit();
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void adminEdita(Usuarios usuario) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.merge(usuario);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Erro ao editar usuário (admin): " + e.getMessage());
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void hospedeEdita(Usuarios usuario) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            manager.getTransaction().begin();
            Usuarios existente = manager.find(Usuarios.class, usuario.getId());
            if (existente != null) {
                existente.setNome(usuario.getNome());
                existente.setEndereco(usuario.getEndereco());
                existente.setTelefone(usuario.getTelefone());
                existente.setEmail(usuario.getEmail());
                existente.setSenha(usuario.getSenha());
                existente.setPreferencias(usuario.getPreferencias());
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            System.out.println("Erro ao editar usuário (hóspede): " + e.getMessage());
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public void excluir(int id) {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            Usuarios usuario = manager.find(Usuarios.class, id);
            if (usuario != null) {
                manager.getTransaction().begin();
                manager.remove(usuario);
                manager.getTransaction().commit();
            }
        } catch (Exception exception) {
            manager.getTransaction().rollback();
            throw exception;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }

    public List<Usuarios> getUsuarios() {
        EntityManager manager = JPAUtil.getEntityManager();
        try {
            TypedQuery<Usuarios> query = manager.createQuery("SELECT u FROM Usuarios u", Usuarios.class);
            return query.getResultList();
        } catch (Exception e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
            return null;
        } finally {
            JPAUtil.closeEntityManager();
        }
    }
}
