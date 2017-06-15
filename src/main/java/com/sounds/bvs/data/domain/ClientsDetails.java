package com.sounds.bvs.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLN_DTL_TB")
public class ClientsDetails implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SYSID", updatable = false)
	private Long id;

	@Column(name="CLN_DESC", length=50)
	private String clientDescription;

	@Embedded
	private AddressDetails addressDetails;

	@OneToOne
	@JoinColumn(name="C_ID", foreignKey=@ForeignKey(name="CC_ID_SK"))
	private Clients clients;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the clientDescription
	 */
	public String getClientDescription() {
		return clientDescription;
	}

	/**
	 * @param clientDescription the clientDescription to set
	 */
	public void setClientDescription(String clientDescription) {
		this.clientDescription = clientDescription;
	}

	/**
	 * @return the addressDetails
	 */
	public AddressDetails getAddressDetails() {
		return addressDetails;
	}

	/**
	 * @param addressDetails the addressDetails to set
	 */
	public void setAddressDetails(AddressDetails addressDetails) {
		this.addressDetails = addressDetails;
	}

	/**
	 * @return the clients
	 */
	public Clients getClients() {
		return clients;
	}

	/**
	 * @param clients the clients to set
	 */
	public void setClients(Clients clients) {
		this.clients = clients;
	}



}
