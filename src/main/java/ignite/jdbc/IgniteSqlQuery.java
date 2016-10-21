package ignite.jdbc;

import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;

public class IgniteSqlQuery {
public static void main(String[] args) {
	Ignite ignite=Ignition.start("C:\\Users\\zhimx\\workspace\\demo\\config\\ignite.xml");
	IgniteCache cache=ignite.getOrCreateCache("person");
	QueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(
            "select age, name,address from Person"));
	for(List<?> a:cursor){
		System.out.println("age is:"+a.get(0)+" name is:"+a.get(1)+" address is:"+a.get(2));
	}
	
}
}
