/**
 *
 */
package com.sounds.bvs.data.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Vikram
 *
 */
@Entity
@Table(name = "CLN_HDR_TB")
public class Clients extends EnterpriseDomainObject {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SYSID", updatable = false)
	private Long id;

	// @NotBlank(message = "Client Name can't be Blank")
	// @Size(min = 3, max = 50, message = "Client Name should be greater then 3
	// Characters Or Less Then 50 Characters")
	@Column(name = "CLIENT_NAME", length = 50, unique = true)
	private String clientName;



	@ElementCollection
	@OneToMany(mappedBy = "clients", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	private Set<SubClients> subClientsSet;


	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST,  mappedBy="clients")
	private ClientsDetails clientDetails;

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

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName
	 *            the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the subClientsSet
	 */
	public Set<SubClients> getSubClientsSet() {
		return subClientsSet;
	}

	/**
	 * @param subClientsSet the subClientsSet to set
	 */
	public void setSubClientsSet(Set<SubClients> subClientsSet) {
		this.subClientsSet = subClientsSet;
	}

	/**
	 * @return the clientDetails
	 */
	public ClientsDetails getClientDetails() {
		return clientDetails;
	}

	/**
	 * @param clientDetails the clientDetails to set
	 */
	public void setClientDetails(ClientsDetails clientDetails) {
		this.clientDetails = clientDetails;
	}

	/**
	 * @return the profilesSet
	 */
}
