/**
 *
 */
package com.sounds.bvs.data.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * @author Vikram
 *
 */
@MappedSuperclass
public class EnterpriseDomainObject implements Serializable, Cloneable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;



	@Column(name="CREATED_BY", length=30, updatable=false)
	private String createdBy;

	@Column(name="CREATED_ON", updatable=false)
	@Temporal(TemporalType.DATE)
	private Date createdOn;

	@Column(name="MODIFIED_BY", length=30)
	private String modifiedBy;

	@Column(name="MODIFIED_ON")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedOn;

	@Column(name="STATUS", length=20, nullable=true)
    private String status;

	@Column(name="VERSION_NO")
	@Version
	private int versionNumber;



	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdOn
	 */
	public Date getCreatedOn() {
		return createdOn;
	}

	/**
	 * @param createdOn the createdOn to set
	 */
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the modifiedOn
	 */
	public Date getModifiedOn() {
		return modifiedOn;
	}

	/**
	 * @param modifiedOn the modifiedOn to set
	 */
	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the versionNumber
	 */
	public int getVersionNumber() {
		return versionNumber;
	}

	/**
	 * @param versionNumber the versionNumber to set
	 */
	public void setVersionNumber(int versionNumber) {
		this.versionNumber = versionNumber;
	}



}
