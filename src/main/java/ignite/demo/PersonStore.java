package ignite.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStore;
import org.apache.ignite.internal.processors.cache.store.GridCacheStoreManagerAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.jetbrains.annotations.Nullable;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class PersonStore implements CacheStore<Integer, Person> {
	private DriverManagerDataSource dataSource;
	
	public PersonStore(){
		dataSource=getDateSource();
	}

	static public DriverManagerDataSource getDateSource(){
		DriverManagerDataSource dateSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/ignite", "root", "123456");
		dateSource.setDriverClassName("com.mysql.jdbc.Driver");
		return dateSource;
	}
	
	 // This method is called whenever IgniteCache.loadCache() method is called.
	@Override
    public void loadCache(IgniteBiInClosure<Integer, Person> clo, @Nullable Object... objects) throws CacheLoaderException {
        System.out.println(">> Loading cache from store...");
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement("select * from PERSON")) {
                try (ResultSet rs = st.executeQuery()) {
                    while (rs.next()) {
                        Person person = new Person(rs.getInt(1), rs.getString(2), rs.getString(3));
                        clo.apply(new Integer(person.getAge()), person);
                    }
                }
            }
        }
        catch (SQLException e) {
            throw new CacheLoaderException("Failed to load values from cache store.", e);
        }
    }
	
	// This method is called whenever IgniteCache.get() method is called.
	@Override
    public Person load(Integer key) throws CacheLoaderException {
        System.out.println(">> Loading person from store...");
        try (Connection conn = dataSource.getConnection()) {
            try (PreparedStatement st = conn.prepareStatement("select * from PERSON where age = ?")) {
                st.setString(1, key.toString());
                ResultSet rs = st.executeQuery();
                return rs.next() ? new Person(rs.getInt(1), rs.getString(2), rs.getString(3)) : null;
            }
        }
        catch (SQLException e) {
            throw new CacheLoaderException("Failed to load values from cache store.", e);
        }
    }

	@Override
	public Map<Integer, Person> loadAll(Iterable<? extends Integer> keys)
			throws CacheLoaderException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void write(Entry<? extends Integer, ? extends Person> entry)
			throws CacheWriterException {
		Person person=entry.getValue();
		Connection conn=null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement st = conn.prepareStatement("insert into person(age,name,address) values(?,?,?)");
			st.setInt(1, person.getAge());
			st.setString(2, person.getName());
			st.setString(3, person.getAddress());
			st.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void writeAll(
			Collection<Entry<? extends Integer, ? extends Person>> entries)
			throws CacheWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object key) throws CacheWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Collection<?> keys) throws CacheWriterException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sessionEnd(boolean commit) throws CacheWriterException {
		// TODO Auto-generated method stub
		
	}
}
