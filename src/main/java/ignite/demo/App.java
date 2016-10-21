package ignite.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import javax.cache.Cache.Entry;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteCluster;
import org.apache.ignite.IgniteCompute;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.cache.query.SqlQuery;
import org.apache.ignite.cache.query.TextQuery;
import org.apache.ignite.cluster.ClusterNode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.NearCacheConfiguration;
import org.apache.ignite.lang.IgniteCallable;
import org.apache.ignite.lang.IgniteFuture;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.multicast.TcpDiscoveryMulticastIpFinder;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;

import com.sun.beans.util.Cache;
import com.sun.org.apache.bcel.internal.generic.RETURN;

@SuppressWarnings("unused")
public class App {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		/*CacheConfiguration<String, Person> cacheConfiguration=new CacheConfiguration<String, Person>("test");
		cacheConfiguration.setCacheMode(CacheMode.PARTITIONED);
		cacheConfiguration.setIndexedTypes(String.class,Person.class);
		Ignite ignite=Ignition.start();
		ignite.getOrCreateCache(cacheConfiguration);
		IgniteCache<String, Person> igniteCache=ignite.cache("test");
		igniteCache.put("p1", new Person(28, "zhimengxuan", "haidian"));
		igniteCache.put("p2", new Person(25, "cuiyang", "yanqing"));
		TextQuery textQuery=new TextQuery(Person.class, "zhimengxuan");
		QueryCursor<Entry<String,Person>> queryCursor=igniteCache.query(textQuery);
		for(Entry<String,Person> entry:queryCursor)
			System.out.println(entry.getValue().getAge());*/
		
		
		/*SqlQuery sql = new SqlQuery(Person.class, "age < ?");
		CacheConfiguration<String, Person> cacheConfiguration=new CacheConfiguration<String, Person>("person");
		cacheConfiguration.setIndexedTypes(String.class,Person.class);
		Ignite ignite=Ignition.start();
		ignite.getOrCreateCache(cacheConfiguration);
		IgniteCache<String, Person> igniteCache=ignite.cache("person");
		igniteCache.put("p1", new Person(28, "zhimengxuan", "haidian"));
		igniteCache.put("p2", new Person(25, "cuiyang", "yanqing"));
		QueryCursor<Entry<String,Person>> queryCursor=igniteCache.query(sql.setArgs(26));
		for(Entry<String,Person> a:queryCursor)
			System.out.println(a.getValue().getAddress());
*/
		CacheConfiguration cacheConfiguration=new CacheConfiguration("person");
		cacheConfiguration.setIndexedTypes(String.class,Person.class,String.class,Org.class);
		Ignite ignite=Ignition.start();
		IgniteCache igniteCache=ignite.getOrCreateCache(cacheConfiguration);
		igniteCache.put("org1", new Org(1, "zhimengxuan", "iscas"));
		igniteCache.put("org2", new Org(2, "cuiyang", "zh"));
		igniteCache.put("person1", new Person(28, "zhimengxuan", "haidian"));
		igniteCache.put("person2", new Person(25, "cuiyang", "yanqing"));
		IgniteCache<String, Person> igniteCache1=ignite.cache("person");
		SqlFieldsQuery sql = new SqlFieldsQuery(
				  "select concat('name:',Person.name,' age:',Person.age,' org:',Org.org) from Person,Org where Person.name=Org.name and Org.id=?");
		QueryCursor<List<?>> cursor = igniteCache1.query(sql.setArgs("2"));
		for(List<?> a:cursor)
			System.out.println(a.get(0));
	}
	
}
