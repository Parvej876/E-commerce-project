package onlineshopping.model;

public class User {
 private int id;
 private String name;
 private String email;
 private String password;
 private String phone;
 private String address;
 private String country;
 private String userType;
 public boolean isValid;
 
 
public User() {
	super();
}
public User(String name, String email, String password, String phone,
		String address, String country,String userType) {
	super();
	this.name = name;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.address = address;
	this.country = country;
	this.userType=userType;
}
public User(int id, String name, String email, String password, String phone,
		String address, String country,String userType) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.password = password;
	this.phone = phone;
	this.address = address;
	this.country = country;
	this.userType=userType;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

public String getUserType() {
	return userType;
}
public void setUserType(String userType) {
	this.userType = userType;
}


public boolean isValid() {
	return isValid;
}
public void setValid(boolean isValid) {
	this.isValid = isValid;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", email=" + email
			+ ", password=" + password + ", phone=" + phone + ", address="
			+ address + ", country=" + country + ", userType=" + userType + "]";
}

}


