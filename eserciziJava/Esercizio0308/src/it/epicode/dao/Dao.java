package it.epicode.dao;

import java.util.List;

import it.epicode.entities.BaseEntity;

public interface Dao<T extends BaseEntity> {
	boolean save(T e);

	T getById(long id);

	boolean delete(long id);

	T refresh(T e);

	List<T> getAll();

}
