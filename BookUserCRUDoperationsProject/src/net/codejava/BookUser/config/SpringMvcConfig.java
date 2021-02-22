package net.codejava.BookUser.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.BookUser.dao.BookDAO;
import net.codejava.BookUser.dao.BookDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="net.codejava.BookUser")
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Bean
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/hb_book_user");
		dataSource.setUsername("bookuser");
		dataSource.setPassword("bookuser");
		
		return dataSource;
	}
	@Bean
	public ViewResolver getViewResolver(){
		
		InternalResourceViewResolver resolver= new InternalResourceViewResolver();
			
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		return resolver;
		
	}
	
	@Bean
	public BookDAO getBookDAO(){
		return new BookDAOImpl(getDataSource());
		
	}

}
