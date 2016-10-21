package tpcw.config;

import static org.apache.ignite.cache.CacheMode.PARTITIONED;
import static org.apache.ignite.cache.CacheWriteSynchronizationMode.FULL_SYNC;

import java.util.List;

import ignite.models.Person;
import ignite.models.PersonKey;

import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.apache.ignite.IgniteTransactions;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicWriteOrderMode;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.cache.CacheWriteSynchronizationMode;
import org.apache.ignite.cache.query.QueryCursor;
import org.apache.ignite.cache.query.SqlFieldsQuery;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.ConnectorConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.apache.ignite.configuration.NearCacheConfiguration;
import org.apache.ignite.spi.discovery.tcp.TcpDiscoverySpi;
import org.apache.ignite.spi.discovery.tcp.ipfinder.vm.TcpDiscoveryVmIpFinder;
import org.apache.ignite.transactions.Transaction;

public class Test {	
	public static void main(String[] args) {	
		String insertString = "INSERT into Person (age,name,address) VALUES(1234,'1111','1111')";
		String deleteString = "delete from Person where age=1234";
		Ignite ignite=Ignition.start("C:\\Users\\zhimx\\workspace\\demo\\config\\jdbc-config.xml");
		IgniteCache<PersonKey,Person> cache=ignite.getOrCreateCache("person");

		
		/*QueryCursor<List<?>> cursor = cache.query(new SqlFieldsQuery(
	            "select age, name,address from Person"));
		for(List<?> a:cursor){
			System.out.println("age is:"+a.get(0)+" name is:"+a.get(1)+" address is:"+a.get(2));
		}*/
		
		IgniteTransactions transactions = ignite.transactions();
		try(Transaction transaction=transactions.txStart()){
			
		cache.query(new SqlFieldsQuery(
	            insertString));
		/*cache.query(new SqlFieldsQuery(
				deleteString));	*/
		transaction.commit();
		}		
		
	}
}
