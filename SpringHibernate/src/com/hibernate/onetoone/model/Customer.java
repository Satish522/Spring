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

 

@Entity
@Table(name="customer")
@SequenceGenerator(
name = "seqid-gen", 
sequenceName = "transaction_sequence" ,
initialValue = 1, allocationSize = 1)
public class Customer {
	@Id
	@Column(name="txn_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
    private long id;
	
	@Column(name="cust_name")
	private String name;
	
	@Column(name="cust_mail")
	private String email;
	
	@Column(name="cust_cont")
	private String contact;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Transactions transactions;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
