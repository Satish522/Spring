package my.satish.jdbc;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

public class SimplePersonInsertDao {
	SimpleJdbcInsert simpleJdbcInsert;

	public SimplePersonInsertDao(DataSource dataSource) {
		simpleJdbcInsert = new SimpleJdbcInsert(dataSource);
	}
	
	public void insert(Person p) {
		simpleJdbcInsert.setTableName("person");
		SqlParameterSource source=new BeanPropertySqlParameterSource(p);
		simpleJdbcInsert.execute(source);
	}
	
	public void insert(int id,String name,String country) {
		simpleJdbcInsert.setTableName("person");
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("p_id", id);
		map.put("p_name", name);
		map.put("p_country", country);
		simpleJdbcInsert.execute(map);
	}
}
