package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.visited;

public class visitedDAO {
    private static EntityManagerFactory emf;

    public visitedDAO() {
        emf = Persistence.createEntityManagerFactory("Test");
    }

    public void addVisited(visited visited) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(visited);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void updateVisited(visited visited) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(visited);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public void deleteVisited(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            visited visited = em.find(visited.class, id);
            em.remove(visited);
            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    public visited getVisitedById(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            visited visited = em.find(visited.class, id);
            return visited;
        } finally {
            em.close();
        }
    }
    

    public List<visited> getVisitedByUserId(int userId) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<visited> query = em.createQuery("SELECT v FROM visited v WHERE v.user.id = :userId", visited.class);
            query.setParameter("userId", userId);
            List<visited> visitedList = query.getResultList();
            return visitedList;
        } finally {
            em.close();
        }
    }

    public List<visited> getAllVisited() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<visited> query = em.createQuery("SELECT v FROM visited v", visited.class);
            List<visited> visitedList = query.getResultList();
            return visitedList;
        } finally {
            em.close();
        }
    }

    public void close() {
        emf.close();
    }
}