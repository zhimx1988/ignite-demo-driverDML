package ignite.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import javax.cache.configuration.FactoryBuilder;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteTransactions;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.QueryEntity;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.cache.store.CacheStore;
import org.apache.ignite.cache.store.CacheStoreSession;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.TransactionConfiguration;
import org.apache.ignite.internal.processors.query.h2.sql.GridSqlQuery;
import org.apache.ignite.resources.CacheStoreSessionResource;
import org.apache.ignite.transactions.Transaction;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

//import com.sun.javafx.collections.MappingChange.Map;

public class MysqlToIgnite {
	
	static public IgniteConfiguration getIgniteConfiguration(){
		CacheConfiguration<Integer, Person> cacheConfiguration=new CacheConfiguration<Integer, Person>("personCache");
		cacheConfiguration.setReadThrough(true);
		cacheConfiguration.setWriteThrough(true);
		cacheConfiguration.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
		//PersonStore personStore=new PersonStore();
		CacheJdbcPersonStore cacheJdbcPersonStore=new CacheJdbcPersonStore();
		cacheConfiguration.setCacheStoreFactory(FactoryBuilder.factoryOf(cacheJdbcPersonStore.getClass()));
		QueryEntity queryEntity=new QueryEntity();
		queryEntity.setKeyType("java.long.Object");
		queryEntity.setValueType("ignite.demo.Person");
		LinkedHashMap<String, String> fields=new LinkedHashMap<String,String>();
		fields.put("age", "java.long.Integer");
		fields.put("name", "java.long.String");
		fields.put("address", "java.long.String");
		queryEntity.setFields(fields);
		List<QueryEntity> list=new ArrayList<QueryEntity>();
		list.add(queryEntity);
		cacheConfiguration.setQueryEntities(list);
		IgniteConfiguration igniteConfiguration=new IgniteConfiguration();
		igniteConfiguration.setCacheConfiguration(cacheConfiguration);
		igniteConfiguration.setPeerClassLoadingEnabled(true);
		igniteConfiguration.setTransactionConfiguration(new TransactionConfiguration());
		return igniteConfiguration;
	}
	
	public static void main(String[] args) {
		Ignite ignite=Ignition.start(getIgniteConfiguration());
		IgniteCache<Integer, Person> cache = ignite.getOrCreateCache("personCache");		
		cache.loadCache(null,60);	
		QueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(
                "select age, name,address from Person"));
		for(List<?> a:cursor){
			System.out.println("age is:"+a.get(0)+" name is:"+a.get(1)+" address is:"+a.get(2));
		}
		System.out.println(ignite.cluster().localNode().id());
		/*Transaction transaction=ignite.transactions().txStart();
		cache.put(98, new Person(98, "old-person", "China"));
		cache.put(99, new Person(99, "old-person", "China"));
		transaction.commit();*/
	}
}
