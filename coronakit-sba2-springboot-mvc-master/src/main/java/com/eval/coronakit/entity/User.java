package com.eval.coronakit.entity;

public class User {
	
		private int id;
		private String name;
		private String email;
		private String address;
		private Integer phone;

		public User() {
			// left unimplemente
		}

		
		
		public Integer getID() {
			return id;
		}

		public void setId(Integer id) {
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

		public Integer getPhone() {
			return phone;
		}

		public void setPhone(Integer phone) {
			this.phone = phone;
		}

		public User(String name, String email, String address, Integer phone) {
			super();
			this.name = name;
			this.email = email;
			this.address= address;
			this.phone = phone;
		}
		

		

}
