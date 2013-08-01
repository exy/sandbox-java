/**
 * 
 */
package org.alexis.mon1erMvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author AlexisD
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	Log log = LogFactory.getLog(UserDaoImpl.class);

	@SuppressWarnings(value = {"unused" })
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
	
	/*
	@Resource(name="monDataSource")
	public void setDataSource(DataSource dataSource) {
		namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	*/
	
	@Override
	public List<UserDto> getUsers() {
		log.debug("getUsers()");
		String sql = "select * from login";
		return jdbcTemplate.query(sql, new UserMapper());
	}
	
	private static final class UserMapper implements RowMapper<UserDto>{

		@Resource(name="userDto")
		private UserDto userDto;
		
		@Override
		public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
			userDto.setName(rs.getString("name"));
			userDto.setLogin(rs.getString("login"));
			userDto.setPassword(rs.getString("password"));
			return userDto;
		}
	}
}
