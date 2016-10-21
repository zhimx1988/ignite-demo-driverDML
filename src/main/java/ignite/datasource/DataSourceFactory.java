package ignite.datasource;

import javax.cache.configuration.Factory;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class DataSourceFactory<T> implements Factory<T>{

	@Override
	public T create() {
		DriverManagerDataSource dataSource=new DriverManagerDataSource("jdbc:mysql://localhost:3306/ignite", "root","123456");
		return (T)dataSource;
	}

}
