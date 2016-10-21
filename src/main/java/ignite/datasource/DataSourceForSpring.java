package ignite.datasource;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class DataSourceForSpring{
	@Bean(name="sourceFactory")
public DataSourceFactory<DataSource> getFactory(){
	return new DataSourceFactory<DataSource>();
}
}
