package ignite.models;

import java.util.List;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.cache.store.jdbc.CacheJdbcPojoStoreFactory;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.marshaller.optimized.OptimizedMarshaller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class StartIgniteWithJava {
	public static void main(String[] args) {
		CacheJdbcPojoStoreFactory<PersonKey, Person> storeFactory = new CacheJdbcPojoStoreFactory<PersonKey, Person>();
		/* storeFactory.setParallelLoadCacheMinimumThreshold(20); */
		CacheConfiguration<PersonKey, Person> configuration = CacheConfig
				.cache("person", storeFactory);
		IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
		OptimizedMarshaller optimizedMarshaller=new OptimizedMarshaller();
		optimizedMarshaller.setRequireSerializable(false);
		igniteConfiguration.setMarshaller(optimizedMarshaller);
		igniteConfiguration.setCacheConfiguration(configuration);
		igniteConfiguration.setPeerClassLoadingEnabled(true);
		Ignite ignite = Ignition.start(igniteConfiguration);
		IgniteCache<PersonKey, Person> igniteCache = ignite
				.getOrCreateCache("person");

		// igniteCache.put(new PersonKey(150), new Person(150, "150", "150"));
		igniteCache.loadCache(null);

		QueryCursor<List<?>> cursor = igniteCache.query(new SqlFieldsQuery(
				"select age,name,address from Person"));
		for (List<?> a : cursor) {
			System.out.println("age is:" + a.get(0) + " name is:" + a.get(1)
					+ " address is:" + a.get(2));
		}

	}
}
