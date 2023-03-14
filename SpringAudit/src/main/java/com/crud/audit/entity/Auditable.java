package com.crud.audit.entity;

import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
	
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<Issuer>{
	
	@CreatedBy
	protected Issuer createdBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	protected Date createdDate;
	
	@LastModifiedBy
	protected Issuer lastModifiedBy;
	
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	protected Date lastModifDate;
	
	public Issuer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Issuer createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Issuer getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(Issuer lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public Date getLastModifDate() {
		return lastModifDate;
	}

	public void setLastModifDate(Date lastModifDate) {
		this.lastModifDate = lastModifDate;
	}
	
}
