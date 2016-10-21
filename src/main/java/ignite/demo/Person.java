package ignite.demo;

import org.apache.ignite.cache.query.annotations.QueryGroupIndex;
import org.apache.ignite.cache.query.annotations.QuerySqlField;
import org.apache.ignite.cache.query.annotations.QueryTextField;

public class Person {
	@QuerySqlField(index=true)
	private int age;
	
	@QuerySqlField(index=true)
	private String name;
	
	@QuerySqlField
	private String address;

	public Person(int age, String name, String addr) {
		this.address = addr;
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
