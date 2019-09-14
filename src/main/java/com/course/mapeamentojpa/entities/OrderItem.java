package com.course.mapeamentojpa.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPK orderItemPK;
	
	private Integer quantity;
	
	private Double price;
	
	public OrderItem() {}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {	
		orderItemPK.setOrder(order);
		orderItemPK.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}
	
	public Order getOrder() {
		return orderItemPK.getOrder();
	}

	public void setOrder(Order order) {
		orderItemPK.setOrder(order);
	}
	
	public Product getProduct() {
		return orderItemPK.getProduct();
	}
	
	public void setProduct(Product product) {
		orderItemPK.setProduct(product);
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderItemPK == null) ? 0 : orderItemPK.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (orderItemPK == null) {
			if (other.orderItemPK != null)
				return false;
		} else if (!orderItemPK.equals(other.orderItemPK))
			return false;
		return true;
	}

}
