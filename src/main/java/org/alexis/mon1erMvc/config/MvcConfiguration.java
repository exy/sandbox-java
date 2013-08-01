package org.alexis.mon1erMvc.config;

import javax.sql.DataSource;

import org.alexis.mon1erMvc.dao.UserDao;
import org.alexis.mon1erMvc.dao.UserDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages="org.alexis.mon1erMvc")
@EnableWebMvc
@PropertySource("classpath:/monMvc.properties")
public class MvcConfiguration extends WebMvcConfigurerAdapter{
	
	@Autowired
	Environment env;

	@Bean
	public ViewResolver getViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean(name="monDataSource")
	public DataSource getDataSource() {
		return new DriverManagerDataSource(env.getProperty("db.url"), env.getProperty("db.login"), env.getProperty("db.password"));
    }
}
