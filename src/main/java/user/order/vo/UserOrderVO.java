package user.order.vo;

import java.sql.Timestamp;
import java.util.Date;

public class UserOrderVO {
	
	private String order_id = "";
	private String o_user = null;
	private int o_product = 0;
	private int quantity = 0;
	private String orderProcess = "";
	private Date orderDate;
	private Timestamp created_at = null;
	private Timestamp updated_at = null;

	public UserOrderVO() {
		
	}//기본생성자 end

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getO_user() {
		return o_user;
	}

	public void setO_user(String o_user) {
		this.o_user = o_user;
	}

	public int getO_product() {
		return o_product;
	}

	public void setO_product(int o_product) {
		this.o_product = o_product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrderProcess() {
		return orderProcess;
	}

	public void setOrderProcess(String orderProcess) {
		this.orderProcess = orderProcess;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
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
		return "UserOrderVO [order_id=" + order_id + ", o_user=" + o_user + ", o_product=" + o_product + ", quantity="
				+ quantity + ", orderProcess=" + orderProcess + ", orderDate=" + orderDate + ", created_at="
				+ created_at + ", updated_at=" + updated_at + "]";
	}
	
}

