package com.sounds.bvs.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILES")
public class Profiles extends EnterpriseDomainObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "SYSID", updatable = false)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "CLIENT_ID", foreignKey = @ForeignKey(name = "P_C_ID_SK"))
	private Clients clients;

	@ManyToOne
	@JoinColumn(name = "SUB_CLIENT_ID", foreignKey = @ForeignKey(name = "P_S_ID_SK"))
	private SubClients subClients;

	@Column(name = "PROFILE_NAME", length = 50)
	private String profileName;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public SubClients getSubClients() {
		return subClients;
	}

	public void setSubClients(SubClients subClients) {
		this.subClients = subClients;
	}

}
