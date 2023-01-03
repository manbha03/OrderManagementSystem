package garage.plug.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customers")
public class Customers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customersId;
	private String customerName;
	private String address;
	@Column(length = 10)
	private String phoneNumber;
	
	public Customers() {

	}

	public Customers(String customerName, String address, String phoneNumber) {
		this.customerName = customerName;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public int getCustomersId() {
		return customersId;
	}

	public void setCustomersId(int customersId) {
		this.customersId = customersId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customers [customersId=" + customersId + ", customerName=" + customerName + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
	
	
}
