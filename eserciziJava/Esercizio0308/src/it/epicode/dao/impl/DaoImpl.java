package it.epicode.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import it.epicode.dao.Dao;
import it.epicode.entities.BaseEntity;

public abstract class DaoImpl<T extends BaseEntity> implements Dao<T> {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	private static final String PERSISTENCE_UNIT_NAME = "EpicodeBE_PU";
	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);

	private final Class<T> type;
	private final String getAllQueryName;

	protected DaoImpl(Class<T> type, String getAllQueryName) {
		this.type = type;
		this.getAllQueryName = getAllQueryName;
	}

	@Override
	public boolean save(T e) {
		var em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			if (exists(e.getId()))
				em.merge(e);
			else
				em.persist(e);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			log.error("Exception saving entity", ex);
			return false;
		} finally {
			em.close();
		}
	}

	private boolean exists(long id) {
		return getById(id) != null;
	}

	@Override
	public T getById(long id) {
		var em = emf.createEntityManager();
		try {
			return em.find(type, id);
		} catch (Exception ex) {
			log.error("Exception retrieving entity with id = {}", id, ex);
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public boolean delete(long id) {
		var em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			var e = em.find(type, id);
			em.remove(e);
			em.getTransaction().commit();
			return true;
		} catch (Exception ex) {
			log.error("Exception deleting entity with id = {}", id, ex);
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public T refresh(T e) {
		var em = emf.createEntityManager();
		try {
			em.refresh(e);
			return e;
		} catch (Exception ex) {
			log.error("Exception refreshing entity with id = {}", e.getId(), ex);
			return null;
		} finally {
			em.close();
		}
	}

	@Override
	public List<T> getAll() {
		var em = emf.createEntityManager();
		try {
			return em.createNamedQuery(getAllQueryName, type).getResultList();
		} catch (Exception e) {
			log.error("Exception retrieving entities list", e);
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
