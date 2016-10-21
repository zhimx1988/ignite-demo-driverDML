package ignite.demo;

import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;

public class CacheTest {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		CacheConfiguration cacheConfigurationPerson = new CacheConfiguration();
		cacheConfigurationPerson.setName("person")
				.setIndexedTypes(String.class, Person.class)
				.setCacheMode(CacheMode.PARTITIONED);
		CacheConfiguration cacheConfigurationOrg = new CacheConfiguration();
		cacheConfigurationOrg.setName("org")
				.setIndexedTypes(String.class, Org.class)
				.setCacheMode(CacheMode.PARTITIONED);
		Ignite ignite = Ignition.start();
		ignite.createCache(cacheConfigurationPerson);
		ignite.createCache(cacheConfigurationOrg);
		ignite.cache("person").put("1",
				new Person(28, "zhimengxuan", "haidian"));
		ignite.cache("person").put("2", new Person(25, "cuiyang", "yanqing"));
		ignite.cache("org").put("1", new Org(1, "zhimengxuan", "iscas"));
		ignite.cache("org").put("2", new Org(2, "cuiyang", "zhonghuajituan"));
		SqlFieldsQuery sql = new SqlFieldsQuery(
				"select concat('name--',Person.name,' org--',Org.org) from \"person\".Person,Org where Org.id=? and Person.name=Org.name");
		QueryCursor<List<?>> cursor=ignite.cache("org").query(sql.setArgs("1"));
		System.out.println(cursor.getAll().get(0).get(0));
		//System.out.println(ignite.cache("org").query(sql.setArgs("1")).getAll());
	}
}
