package com.qa.ims.persistence.domain;

public class Order {

	private Long id;
	private Long customerId;
	private String itemName;
	private Double value;
	private Long quantity;

	public Order(Long customerId) {
		this.setCustomerId(customerId);
	}

	public Order(Long id, Long customerId) {
		this.setId(id);
		this.setCustomerId(customerId);

	}
	
	public Order(Long id, Long customerId, String itemName, Double value, Long quantity) {
		this.setId(id);
		this.setCustomerId(customerId);
		this.setItemName(itemName);
		this.setValue(value);
		this.setQuantity(quantity);

	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Double getValue() {
		return value;
	}

	public void setValue(Double value) {
		this.value = value;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "id:" + id + " customer id:" + customerId;
	}
	
	public String toStringExtended() {
		return "id:" + id + " customer id:" + customerId + " item name:" + itemName + " value:£" + value + " quantity:" + quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
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
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		return true;
	}

}
