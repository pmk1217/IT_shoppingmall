package admin.action.vo;

import java.sql.Timestamp;

public class AdminVO {
	private String manager_id = null;
	private String password = null;
	private Timestamp created_at = null;
	private Timestamp updated_At = null;
	
	public AdminVO() {
	}

	public String getManager_id() {
		return manager_id;
	}

	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Timestamp updated_At) {
		this.updated_At = updated_At;
	}

	@Override
	public String toString() {
		return "AdminVO [manager_id=" + manager_id + ", password=" + password + ", created_at=" + created_at
				+ ", updated_At=" + updated_At + "]";
	}

	
}
