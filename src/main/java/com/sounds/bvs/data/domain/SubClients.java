package com.sounds.bvs.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="SUB_CLN_HDR_TB")
public class SubClients extends EnterpriseDomainObject  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="SUB_CLIENT_ID", length=5)
	private int subClientId;

	@ManyToOne
	@JoinColumn(name="CLIENT_ID",
	foreignKey = @ForeignKey(name="C_ID_SK"))
	private Clients clients;

	@ElementCollection
	@OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST, mappedBy="subClients")
	private Set<Profiles> profiles;

	@Column(name="BUSINESS_TYPE", length=100)
    private String businessType;

	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST,  mappedBy="subClients")
	private SubClientsDetails subClientsDetails;

	public int getSubClientId() {
		return subClientId;
	}

	public void setSubClientId(int subClientId) {
		this.subClientId = subClientId;
	}

	public Clients getClients() {
		return clients;
	}

	public void setClients(Clients clients) {
		this.clients = clients;
	}

	public String getBusinessType() {
		return businessType;
	}

	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}

	public Set<Profiles> getProfiles() {
		return profiles;
	}

	public void setProfiles(Set<Profiles> profiles) {
		this.profiles = profiles;
	}

	/**
	 * @return the subClientsDetails
	 */
	public SubClientsDetails getSubClientsDetails() {
		return subClientsDetails;
	}

	/**
	 * @param subClientsDetails the subClientsDetails to set
	 */
	public void setSubClientsDetails(SubClientsDetails subClientsDetails) {
		this.subClientsDetails = subClientsDetails;
	}


}
