package garage.plug.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	private float subTotal;
	private float discount;
	private float total;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="order_id", referencedColumnName = "customersId")
	private Customers customers;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="productId", referencedColumnName = "orderId")
	private List<Products> products;

	@OneToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name="productQuantity", referencedColumnName = "productQuantity")
	private Products productQuantity;

	
	public Orders() {
	
	}
	



	public Orders(int orderId, float subTotal, float discount, float total, Customers customers,
			List<Products> products, Products productQuantity) {
		this.orderId = orderId;
		this.subTotal = subTotal;
		this.discount = discount;
		this.total = total;
		this.customers = customers;
		this.products = products;
		this.productQuantity = productQuantity;
	}




	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(float subTotal) {
		this.subTotal = subTotal;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Customers getCustomers() {
		return customers;
	}

	public void setCustomers(Customers customers) {
		this.customers = customers;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public Products getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Products productQuantity) {
		this.productQuantity = productQuantity;
	}




	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", subTotal=" + subTotal + ", discount=" + discount + ", total=" + total
				+ ", customers=" + customers + ", products=" + products + ", productQuantity=" + productQuantity + "]";
	}
	
	
	
	
}
