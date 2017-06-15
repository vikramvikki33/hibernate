/**
 *
 */
package com.sounds.bvs.test;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sounds.bvs.data.dao.impl.ClientsDaoImpl;
import com.sounds.bvs.data.dao.impl.SubClientsDaoImpl;
import com.sounds.bvs.data.domain.Address;
import com.sounds.bvs.data.domain.AddressDetails;
import com.sounds.bvs.data.domain.Clients;
import com.sounds.bvs.data.domain.ClientsDetails;
import com.sounds.bvs.data.domain.EnterpriseDomainObject;
import com.sounds.bvs.data.domain.Profiles;
import com.sounds.bvs.data.domain.SubClients;
import com.sounds.bvs.data.domain.SubClientsDetails;



/**
 * @author Vikram
 *
 */
public class TestGenericCrudOperation {

//	protected SessionFactory sessionFactory;
	ClientsDaoImpl clientsImpl;
	SubClientsDaoImpl subClientsImpl;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("In Setup");
		clientsImpl = new ClientsDaoImpl();
		subClientsImpl = new SubClientsDaoImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {

	}


	@Test
	public void saveClients() {
		Clients clients = new Clients();
		clients.setClientName("Accenture");
		populateAuditDetails(clients);
		ClientsDetails clientsDetails = new ClientsDetails();
		clientsDetails.setClientDescription("oracle Operation Desciption");
		clientsDetails.setAddressDetails(populateAddressDetails());
		clientsDetails.setClients(clients);
		clients.setClientDetails(clientsDetails);

		Set<Profiles> profiesSet = new HashSet<>();
		Set<SubClients> subClientsSet = new HashSet<>();
		SubClientsDetails subClientsDetails = null;
		SubClients subClients = new SubClients();


		subClients.setBusinessType("Education Verification");
		subClients.setClients(clients);
		populateAuditDetails(subClients);
		subClientsDetails = new SubClientsDetails();
		subClientsDetails.setBusnessDescription("Education Veri Business");
		subClientsDetails.setAddressDetails(populateAddressDetails());
		subClientsDetails.setSubClients(subClients);
		subClients.setSubClientsDetails(subClientsDetails);

		Profiles profiles = null;
		for(int i=1; i<=3; i++) {
			profiles = new Profiles();
			profiles.setProfileName("Education Verification Profile" + i);
			populateAuditDetails(profiles);
			profiles.setClients(clients);
			profiles.setSubClients(subClients);
			profiesSet.add(profiles);
		}
		subClients.setProfiles(profiesSet);
		subClientsSet.add(subClients);

		subClients = new SubClients();
		subClients.setBusinessType("Contact Verification");
		subClients.setClients(clients);
		populateAuditDetails(subClients);
		subClientsDetails = new SubClientsDetails();
		subClientsDetails.setBusnessDescription("Contact Veri Business");
		subClientsDetails.setAddressDetails(populateAddressDetails());
		subClientsDetails.setSubClients(subClients);
		subClients.setSubClientsDetails(subClientsDetails);

		for(int i=1; i<=3; i++) {
			profiles = new Profiles();
			profiles.setProfileName("Contact Verification Profile" + i);
			populateAuditDetails(profiles);
			profiles.setClients(clients);
			profiles.setSubClients(subClients);
			profiesSet.add(profiles);
		}
		subClients.setProfiles(profiesSet);
		subClientsSet.add(subClients);

		subClients = new SubClients();
		subClients.setBusinessType("Employment Verification");
		subClients.setClients(clients);
		populateAuditDetails(subClients);
		subClientsDetails = new SubClientsDetails();
		subClientsDetails.setBusnessDescription("Employment Veri Business");
		subClientsDetails.setAddressDetails(populateAddressDetails());
		subClientsDetails.setSubClients(subClients);
		subClients.setSubClientsDetails(subClientsDetails);

		for(int i=1; i<=3; i++) {
			profiles = new Profiles();
			profiles.setProfileName("Employment Verification Profile" + i);
			populateAuditDetails(profiles);
			profiles.setClients(clients);
			profiles.setSubClients(subClients);
			profiesSet.add(profiles);
		}
		subClients.setProfiles(profiesSet);
		subClientsSet.add(subClients);



		clients.setSubClientsSet(subClientsSet);

		clientsImpl.save(clients);
	}


	@Test
	public void testClientDetails() {
		try {
		System.out.println("In testClientDetails");
		Clients clients = new Clients();
		clients.setClientName("Oracle");
		populateAuditDetails(clients);
		clientsImpl.save(clients);
		System.out.println("Clients Saved......");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Test
	public void fetchClients() {
		List<Clients> clientsList = clientsImpl.findAll();
		assertNotNull(clientsList);
	}

	private AddressDetails populateAddressDetails() {
		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setContactPersonName("Vikram R");
		addressDetails.setContactReference("Vikram Reference");
		addressDetails.setAddress(populateAddress());
		return addressDetails;
	}

	private Address populateAddress() {
		Address address = new Address();
		address.setAddressLine1("Line 1");
		address.setAddressLine2("Line 2");
		address.setAddressLine3("line 3");
		address.setCity("Banagalore");
		address.setCountry("india");
		address.setOfficeMobile("987466");
		address.setPersonalMobile("987456321");
		address.setPin("98755");
		address.setPrimaryEmailId("primary Email Address");
		address.setSecondaryEmailId("Secomdary@gmail.com");
		return address;

	}

	private void populateAuditDetails(Object obj) {
		EnterpriseDomainObject object = (EnterpriseDomainObject)obj;
		object.setCreatedBy("Admin");
		object.setCreatedOn(new Date());
		object.setModifiedBy("Admin");
		object.setModifiedOn(new Date());
	}
}
