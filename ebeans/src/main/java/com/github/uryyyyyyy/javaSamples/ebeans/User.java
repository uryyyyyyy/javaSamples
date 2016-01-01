package com.github.uryyyyyyy.javaSamples.ebeans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.avaje.ebean.Model;
import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;

/**
 * Customer entity bean.
 */
@Entity
@Table(name="eg_customer")
public class Customer extends Model {

	/**
	 * Convenience Finder for 'active record' style.  Finder is public static class in com.avaje.ebean.Model
	 */
	public static final Finder<Long,Customer> find = new Finder<>(Long.class, Customer.class);

	@Id
	Long id;

	@Version
	Long version;

	@CreatedTimestamp
	Timestamp whenCreated;

	@UpdatedTimestamp
	Timestamp whenUpdated

	@Column(length=100)
	String name;

	boolean inactive;

	LocalDate registered;

	@Column(length=1000)
	String comments;

	@ManyToOne(cascade=CascadeType.ALL)
	Address billingAddress;

	@ManyToOne(cascade=CascadeType.ALL)
	Address shippingAddress;

	@OneToMany(mappedBy="customer", cascade=CascadeType.PERSIST)
	List<Contact> contacts;

	...

	/**
	 * Helper method to add a contact to the customer.
	 */
	public void addContact(Contact contact) {
		if (contacts == null) {
			contacts = new ArrayList<>();
		}
		// setting the customer is automatically done when Ebean does
		// a cascade save from customer to contacts.
		contact.setCustomer(this);
		contacts.add(contact);
	}

}