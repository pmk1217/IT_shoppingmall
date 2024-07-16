package user.product.vo;

import java.sql.Timestamp;

public class UserProductVO {
	private int product_id = 0;
	private String name = "";
	private int price = 0;
	private String content = "";
	private String img = "";
	private int views = 0;
	private int likes = 0;
	private int quantity = 0;
	private String category = "";
	private Timestamp created_at;
	private Timestamp updated_at;
	/** 페이지 번호 */
	private String pageNum = "1";
	/** 검색 항목 */
	private String searchType = "";
	/** 검색어 */
	private String searchText = "";
	/** 목록 페이지 게시물 노출 수 */
	private int listCount = 10;
	/** 목록 페이지 네비게이터 블록 수 */
	private int pagePerBlock = 10;
	
	public UserProductVO() {
		
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public String getPageNum() {
		return pageNum;
	}

	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public int getPagePerBlock() {
		return pagePerBlock;
	}

	public void setPagePerBlock(int pagePerBlock) {
		this.pagePerBlock = pagePerBlock;
	}

	@Override
	public String toString() {
		return "UserProductVO [product_id=" + product_id + ", name=" + name + ", price=" + price + ", content="
				+ content + ", img=" + img + ", views=" + views + ", likes=" + likes + ", quantity=" + quantity
				+ ", category=" + category + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", getProduct_id()=" + getProduct_id() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getContent()=" + getContent() + ", getImg()=" + getImg() + ", getViews()=" + getViews()
				+ ", getLikes()=" + getLikes() + ", getQuantity()=" + getQuantity() + ", getCategory()=" + getCategory()
				+ ", getCreated_at()=" + getCreated_at() + ", getUpdated_at()=" + getUpdated_at() + "]";
	}
}