package user.action.vo;

public class ZipCodeVO {
	private String zipcode = null;
	private String cityName = null;
	private String regionName = null;
	private String streetName = null;
	private String area = null;

	public ZipCodeVO() {
		
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "ZipCodeVO [zipcode=" + zipcode + ", cityName=" + cityName + ", regionName=" + regionName
				+ ", streetName=" + streetName + ", area=" + area + "]";
	}


}
