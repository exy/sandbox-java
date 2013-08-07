package org.alexis.mon1erMvc.config;

import java.io.File;

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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

@Configuration
@ComponentScan(basePackages = "org.alexis.mon1erMvc")
@EnableWebMvc
@PropertySource("classpath:monMvc.properties")
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	Log log = LogFactory.getLog(MvcConfiguration.class);

	@Autowired
	Environment env;
	@Bean(name = "freemarkerConfig")
	public FreeMarkerConfigurer getFreemarkerConfig() {
		FreeMarkerConfigurer conf = new FreeMarkerConfigurer();
		conf.setTemplateLoaderPath("/WEB-INF/freemarker/");
		return conf;
	}
	
	@Bean
	public ViewResolver getViewResolver() {
		FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver(); 
		viewResolver.setCache(false); // Put TRUE in production
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".ftl");
		return viewResolver;
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations(
				"/resources/");
	}

	@Bean(name = "monDataSource")
	public DataSource getMonDataSource() {
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
		return new JdbcTemplate(getMonDataSource());
	}

	@Bean(name = "namedjdbcTemplate")
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		log.debug("namedjdbcTemplate");
		return new NamedParameterJdbcTemplate(getMonDataSource());
	}
	

	@Bean(name="rootPath")
	public String getRootPath() {
		return "C:/Users/Public/Pictures/Sample Pictures";
	}

}
