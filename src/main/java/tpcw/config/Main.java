package tpcw.config;


import java.util.ArrayList;
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


public class Main {
	private static final String[] TABLES = { "address", "author", "ccxacts",
			"country", "customer", "item", "orderline", "orders",
			"shoppingCart", "shoppingCartLine" };

	public static void main(String[] args) {
		Ignite ignite = getIgnite();
		IgniteCache<Object, Object> author = ignite.getOrCreateCache("author");
		IgniteCache<Object, Object> country = ignite
				.getOrCreateCache("country");
		author.loadCache(null);
		country.loadCache(null);
		QueryCursor<List<?>> cursorAuthor = author.query(new SqlFieldsQuery(
				"select * from author"));
		for (List<?> a : cursorAuthor) {
			System.out.println("age is:" + a.get(0) + " name is:" + a.get(1)
					+ " address is:" + a.get(2));
		}
		QueryCursor<List<?>> cursorCountry = country.query(new SqlFieldsQuery(
				"select * from country"));
		for (List<?> a : cursorCountry) {
			System.out.println("age is:" + a.get(0) + " name is:" + a.get(1)
					+ " address is:" + a.get(2));
		}
	}

	public static Ignite getIgnite() {
		CacheConfiguration[] cfgs = new CacheConfiguration[10];
		for (int tableIndex = 0; tableIndex < TABLES.length; tableIndex++) {
			cfgs[tableIndex] = CacheConfig.cache(TABLES[tableIndex]);
		}
		IgniteConfiguration igniteConfiguration = new IgniteConfiguration();
		igniteConfiguration.setCacheConfiguration(cfgs);
		igniteConfiguration.setPeerClassLoadingEnabled(true);
		
		OptimizedMarshaller marshaller=new OptimizedMarshaller();
		marshaller.setRequireSerializable(false);
		igniteConfiguration.setMarshaller(marshaller);
		
		Ignite ignite = Ignition.start(igniteConfiguration);
		return ignite;

		/*
		 * QueryCursor<List<?>> cursor = igniteCache.query(new SqlFieldsQuery(
		 * "select * from item")); for(List<?> a:cursor){
		 * System.out.println("age is:"
		 * +a.get(0)+" name is:"+a.get(1)+" address is:"+a.get(2)); }
		 */
	}
}
