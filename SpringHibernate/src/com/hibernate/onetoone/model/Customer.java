package com.hibernate.onetoone.model;

public class Customer {
	private long id;
	private String name;
	private String email;
	private String address;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Transactions getTransaction() {
		return transactions;
	}

	public void setTransaction(Transactions transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", transactions="
				+ transactions + "]";
	}
	
	
}
