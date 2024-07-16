package user.cart.vo;

import java.sql.Timestamp;

public class UserCartVO {
	private int cart_id;
	private String c_userId= null;
	private int  c_productId = 0;
	private int quantity = 0;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public UserCartVO() {
		
	}

	public int getCart_id() {
		return cart_id;
	}

	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}

	public String getC_userId() {
		return c_userId;
	}

	public void setC_userId(String c_userId) {
		this.c_userId = c_userId;
	}

	public int getC_productId() {
		return c_productId;
	}

	public void setC_productId(int c_productId) {
		this.c_productId = c_productId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "UserCartVO [cart_id=" + cart_id + ", c_userId=" + c_userId + ", c_productId=" + c_productId
				+ ", quantity=" + quantity + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}

	

	


	

}
