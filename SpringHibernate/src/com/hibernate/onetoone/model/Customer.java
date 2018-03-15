package com.hibernate.onetoone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


 

@Entity
@Table(name="customer")
public class Customer {

	 
	@Id
	@Column(name="txn_id", unique=true, nullable=false)
	@GeneratedValue(generator="gen")
	@GenericGenerator(name="gen", strategy = "foreign", parameters={
			@Parameter(name="property", value="transactions")})
    private int id;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="cust_mail")
	private String email;
	
	@Column(name="cust_cont")
	private String contact;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Transactions transactions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public Transactions getTransaction() {
		return transactions;
	}

	public void setTransaction(Transactions transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + ", transactions="
				+ transactions + "]";
	}
	
	
}
