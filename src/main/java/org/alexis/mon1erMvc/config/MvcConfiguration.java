package org.alexis.mon1erMvc.config;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.tomcat.dbcp.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.util.Log4jConfigurer;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "org.alexis.mon1erMvc")
@EnableWebMvc
@PropertySource("classpath:monMvc.properties")
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	Log log = LogFactory.getLog(MvcConfiguration.class);

	@Autowired
	Environment env;

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean(name = "monDataSource")
	public DataSource getDataSource() {
		log.debug("monDataSource");
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(env.getProperty("db.driverClassName"));
		ds.setUrl(env.getProperty("db.url"));
		ds.setUsername(env.getProperty("db.login"));
		ds.setPassword(env.getProperty("db.password"));
		return ds;
	}

	@Bean(name = "jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		log.debug("jdbcTemplate");
		return new JdbcTemplate(getDataSource());
	}

	@Bean(name = "namedjdbcTemplate")
	public NamedParameterJdbcTemplate getNAmedJdbcTemplate() {
		log.debug("namedjdbcTemplate");
		return new NamedParameterJdbcTemplate(getDataSource());
	}

}
