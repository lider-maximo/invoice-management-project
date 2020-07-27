package ma.nestideas.invoicemanagement.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "clients")
public class Client {
	
	private long id;
	private String companyName;
	private String contactName;
	private String address;
	private String city;
	private String email;
	private String phone;
	
	public Client() {
		
	}

	public Client(String companyName, String contactName, String address, String city, String email, String phone) {
		
		this.companyName = companyName;
		this.contactName = contactName;
		this.address = address;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "company_name", nullable = false)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name = "contact_name", nullable = false)
	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	@Column(name = "address", nullable = false)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "city", nullable = false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "email", nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "phone", nullable = false)
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", companyName=" + companyName + ", contactName=" + contactName + ", address="
				+ address + ", city=" + city + ", email=" + email + ", phone=" + phone + "]";
	}

}
