package it.epicode.entities;

import java.time.OffsetDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // non entra in alcuna query serve solo come classe base nel BE
public class BaseEntity {
	protected static final String SEQUENCE_GENERATOR = "default_generator";

	private long id;
	private OffsetDateTime createdAt;

	public BaseEntity(long id) {
		this.id = id;
	}

	public BaseEntity() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR)
	public long getId() {
		return id;
	}

	@Column(columnDefinition = "TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP", insertable = false, updatable = false)
	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCreatedAt(OffsetDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		return obj == this || (obj != null && obj.getClass().equals(getClass()) && obj.hashCode() == hashCode());
	}

	@Override
	public String toString() {
		return String.format("BaseEntity{id: %s, createdAt: %tc}", id, createdAt);
	}
}
