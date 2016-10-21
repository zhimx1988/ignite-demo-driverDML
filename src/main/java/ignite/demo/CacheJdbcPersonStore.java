package ignite.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.cache.Cache.Entry;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.cache.store.CacheStoreSession;
import org.apache.ignite.cache.store.jdbc.CacheJdbcBlobStore;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.apache.ignite.resources.CacheStoreSessionResource;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mysql.jdbc.Driver;

public class CacheJdbcPersonStore extends CacheStoreAdapter<Integer, Person> {
	/** Auto-injected store session. */
	@CacheStoreSessionResource
	private CacheStoreSession ses;

	// Complete transaction or simply close connection if there is no
	// transaction.
	@Override
	public void sessionEnd(boolean commit) {
		try (Connection conn = ses.attachment()) {
			if (conn != null && ses.isWithinTransaction()) {
				if (commit)				
					conn.commit();						
				else
					conn.rollback();
			}
		} catch (SQLException e) {
			throw new CacheWriterException("Failed to end store session.", e);
		}
	}

	// This mehtod is called whenever "get(...)" methods are called on
	// IgniteCache.
	@Override
	public Person load(Integer key) {
		try (Connection conn = connection()) {
			try (PreparedStatement st = conn
					.prepareStatement("select * from PERSON where age=?")) {
				st.setInt(1, key);
				ResultSet rs = st.executeQuery();
				return rs.next() ? new Person(rs.getInt(1), rs.getString(2),
						rs.getString(3)) : null;
			}
		} catch (SQLException e) {
			throw new CacheLoaderException("Failed to load: " + key, e);
		}
	}

	// This mehtod is called whenever "remove(...)" methods are called on
	// IgniteCache.
	@Override
	public void delete(Object key) {
		try (Connection conn = connection()) {
			try (PreparedStatement st = conn
					.prepareStatement("delete from PERSON where age=?")) {
				st.setInt(1, (Integer) key);
				st.executeUpdate();
			}
		} catch (SQLException e) {
			throw new CacheWriterException("Failed to delete: " + key, e);
		}
	}

	// This mehtod is called whenever "loadCache()" and "localLoadCache()"
	// methods are called on IgniteCache. It is used for bulk-loading the cache.
	// If you don't need to bulk-load the cache, skip this method.
	@Override
	public void loadCache(IgniteBiInClosure<Integer, Person> clo,
			Object... args) {
		if (args == null || args.length == 0 || args[0] == null)
			throw new CacheLoaderException(
					"Expected entry count parameter is not provided.");
		final int entryCnt = (Integer) args[0];
		try (Connection conn = connection()) {
			try (PreparedStatement st = conn
					.prepareStatement("select * from PERSON")) {
				try (ResultSet rs = st.executeQuery()) {
					int cnt = 0;
					while (cnt < entryCnt && rs.next()) {
						Person person = new Person(rs.getInt(1),
								rs.getString(2), rs.getString(3));
						clo.apply(person.getAge(), person);
						cnt++;
					}
				}
			}
		} catch (SQLException e) {
			throw new CacheLoaderException(
					"Failed to load values from cache store.", e);
		}
	}

	// Opens JDBC connection and attaches it to the ongoing
	// session if within a transaction.
	private Connection connection() throws SQLException {
		if (ses.isWithinTransaction()) {
			Connection conn = ses.attachment();
			if (conn == null) {
				conn = openConnection(false);
				// Store connection in the session, so it can be accessed
				// for other operations within the same transaction.
				ses.attach(conn);
			}
			return conn;
		}
		// Transaction can be null in case of simple load or put operation.
		else
			return openConnection(true);
	}

	// Opens JDBC connection.
	private Connection openConnection(boolean autocommit) throws SQLException {
		
		/*DriverManager.registerDriver(new Driver());
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/ignite", "root", "123456");
		connection.setAutoCommit(autocommit);*/
		DriverManagerDataSource dateSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/ignite", "root", "123456");
		dateSource.setDriverClassName("com.mysql.jdbc.Driver");
		Connection conn=dateSource.getConnection();
		conn.setAutoCommit(autocommit);
		return conn;		
	}

	@Override
	public void write(Entry<? extends Integer, ? extends Person> entry) {
		/*try (Connection conn = connection()) {
			try (PreparedStatement st = conn
					.prepareStatement("insert into PERSON (age, name, address) VALUES (?, ?, ?)")) {
				Person val = entry.getValue();
				st.setInt(1, entry.getKey());
				st.setString(2, val.getName());
				st.setString(3, val.getAddress());
				st.execute();	
			}
		} catch (SQLException e) {
			throw new CacheWriterException("Failed to write [age="
					+ entry.getKey() + ']', e);
		}*/
		
		
		Connection conn = null;
		try {
			conn = connection();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try (PreparedStatement st = conn
				.prepareStatement("insert into PERSON (age, name, address) VALUES (?, ?, ?)")) {
			Person val = entry.getValue();
			st.setInt(1, entry.getKey());
			st.setString(2, val.getName());
			st.setString(3, val.getAddress());
			st.execute();
		} catch (SQLException e) {
			throw new CacheWriterException("Failed to write [age="
					+ entry.getKey() + ']', e);
		}
	}
	
}
