package ignite.demo;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

public class Org {
	@QuerySqlField
private int id;
	@QuerySqlField
private String name;
	@QuerySqlField
private String org;

public Org(int id,String name,String org){

	this.id=id;

	this.name=name;

	this.org=org;
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
public String getOrg() {
	return org;
}
public void setOrg(String org) {
	this.org = org;
}

}
