package user.action.vo;

public class UserLikeVO {

	public String user_id;
	public int product_id;
	
	public UserLikeVO() {
		// TODO Auto-generated constructor stub
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	@Override
	public String toString() {
		return "UserLikeVO [user_id=" + user_id + ", product_id=" + product_id + "]";
	}

}
