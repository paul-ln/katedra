package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.user;

public class userDAO {
	private static EntityManagerFactory emf;
	
	public userDAO() {
	    emf = Persistence.createEntityManagerFactory("Test");
	}
	
	public void addUser(user user) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        em.persist(user);
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
	
	public void updateUser(user user) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        em.merge(user);
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
	
	public void deleteUser(int id) {
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction tx = em.getTransaction();
	    try {
	        tx.begin();
	        user user = em.find(user.class, id);
	        em.remove(user);
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
	
	public user getUserById(int id) {
	    EntityManager em = emf.createEntityManager();
	    try {
	        user user = em.find(user.class, id);
	        return user;
	    } finally {
	        em.close();
	    }
	}
	
	public user getUserByPseudo(String pseudo) {
	    EntityManager em = emf.createEntityManager();
	    try {
	        TypedQuery<user> query = em.createQuery("SELECT u FROM user u WHERE u.pseudo = :pseudo", user.class);
	        query.setParameter("pseudo", pseudo);
	        return query.getSingleResult();
	    } finally {
	        em.close();
	    }
	}
	
	public List<user> getAllUsers() {
	    EntityManager em = emf.createEntityManager();
	    try {
	        TypedQuery<user> query = em.createQuery("SELECT u FROM user u", user.class);
	        List<user> userList = query.getResultList();
	        return userList;
	    } finally {
	        em.close();
	    }
	}
	
	public void close() {
	    emf.close();
	}
}