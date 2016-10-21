package ignite.jdbc;

import ignite.models.Person;
import ignite.models.PersonKey;

import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class StartIgniteWithXmlFile {
public static void main(String[] args) {	
	Ignite ignite=Ignition.start("C:\\Users\\zhimx\\workspace\\demo\\config\\ignite2.xml");
	IgniteCache<PersonKey,Person> cache=ignite.getOrCreateCache("person");
	//cache.put(new PersonKey(150), new Person(150, "150", "150"));
	cache.loadCache(null);
	//cache.put(new PersonKey(1111), new Person(1111, "1111","1111"));
	QueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(
            "select age, name,address from Person"));
	for(List<?> a:cursor){
		System.out.println("age is:"+a.get(0)+" name is:"+a.get(1)+" address is:"+a.get(2));
	}
	
	
/*	QueryCursor<List<?>> cursor2 = cache.query(new SqlFieldsQuery(
            "delete from person where age=1111"));*/
	
}
}
