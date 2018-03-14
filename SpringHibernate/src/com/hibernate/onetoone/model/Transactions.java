package com.hibernate.onetoone.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="transaction")
@SequenceGenerator(
name = "seqid-gen", 
sequenceName = "transaction_sequence" ,
initialValue = 1, allocationSize = 1)
public class Transactions {
	
	@Id
	@Column(name="txn_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	private int id;
	
	@Column(name="txn_date")
	private Date date;
	
	@Column(name="amount")
	private int total;
	
	@OneToOne(cascade=CascadeType.ALL,mappedBy="transactions")
	private Customer customer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	@Override
	public String toString() {
		return "Transactions [id=" + id + ", date=" + date + ", total=" + total + ", customer=" + customer + "]";
	}
	
	
}
