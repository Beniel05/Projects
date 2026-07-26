package model;

public class Member {
	private int memberId;
	private String name;
	private int age;
	private String contact;
	private String address;
	
	public Member(int memberId, String name, int age, String contact, String address) {
		this.memberId = memberId;
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", name=" + name + ", age=" + age +
				", contact=" + contact + ", address=" + address + "]";
	}
	
	

	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
