package com.javastack.spring.internetprovider.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="userplan")
public class UserPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// This will not allow the createdAt column to be updated after creation
		@Column(updatable=false)
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date createdAt;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date updatedAt;

	// other getters and setters removed for brevity
	// use in order to create/update the time of the data
		@PrePersist
		protected void onCreate(){
	       	this.createdAt = new Date();
	       	this.updatedAt = new Date();
	}
		@PreUpdate
		protected void onUpdate(){
			this.updatedAt = new Date();
	}
		@NotEmpty(message="Please enter a legal First Name")
		@Size(min=3, max=15, message="Name must be between 3 - 15 characters")
		private String firstname;
		
		@NotEmpty(message="Please enter a legal Last Name")
		@Size(min=3, max=15, message="Name must be between 3 - 15 characters")
		private String lastname;
		
//		@
//		private int accountnumber;
//		
		@NotEmpty(message="Address must be required")
		@Size(min=5, max=50, message="Please put your valid address for the installation of your plan")
		private String address;
		
		@Positive
		@NotNull(message="Phone number is required")
		@Pattern(regexp = "\\d{9}", message = "Phone number must have exactly 9 digits")
		
		private String phonenumber;
		
		@NotNull(message="Select a plan of your choice")
		private double price;
		

		

		// This has to match the mappedBy name from OnetoMany in order to connect
		@ManyToOne(fetch=FetchType.LAZY)
		@JoinColumn(name="user_id")
		
		private User planCreator;
		
		public UserPlan() {
		
		}
		

				
		public UserPlan(Long id,
				@NotEmpty(message = "Please enter a legal First Name") @Size(min = 3, max = 15, message = "Name must be between 3 - 15 characters") String firstname,
				@NotEmpty(message = "Please enter a legal Last Name") @Size(min = 3, max = 15, message = "Name must be between 3 - 15 characters") String lastname,
				@NotEmpty(message = "Address must be required") @Size(min = 5, max = 50, message = "Please put your valid address for the installation of your plan") String address,
				@Positive @NotNull(message = "Phone number is required") @Pattern(regexp = "\\d{9}", message = "Phone number must have exactly 9 digits") String phonenumber,
				@NotNull(message = "Select a plan of your choice") double price) {
			this.id = id;
			this.firstname = firstname;
			this.lastname = lastname;
			this.address = address;
			this.phonenumber = phonenumber;
			this.price = price;
		}

		

		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		
		
		public String getPhonenumber() {
			return phonenumber;
		}
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}
		public User getPlanCreator() {
			return planCreator;
		}
		public void setPlanCreator(User planCreator) {
			this.planCreator = planCreator;
		}
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}

}
