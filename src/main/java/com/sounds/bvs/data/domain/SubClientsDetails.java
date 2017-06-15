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
@Table(name="SUB_CLN_DTL_TB")
public class SubClientsDetails implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SYSID", updatable = false)
	private Long id;

	@Column(name="BUSS_DESC", length=50)
	private String busnessDescription;

	@Embedded
	private AddressDetails addressDetails;

	@OneToOne
	@JoinColumn(name="SUB_ID", foreignKey=@ForeignKey(name="SS_ID_SK"))
	private SubClients subClients;

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
	 * @return the busnessDescription
	 */
	public String getBusnessDescription() {
		return busnessDescription;
	}

	/**
	 * @param busnessDescription the busnessDescription to set
	 */
	public void setBusnessDescription(String busnessDescription) {
		this.busnessDescription = busnessDescription;
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
	 * @return the subClients
	 */
	public SubClients getSubClients() {
		return subClients;
	}

	/**
	 * @param subClients the subClients to set
	 */
	public void setSubClients(SubClients subClients) {
		this.subClients = subClients;
	}

}
