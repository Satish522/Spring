package my.satish.jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;

public class PersonDao {
	public static final String INSERT="insert into person(p_id,p_name,p_country) values(?,?,?)";
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public int[] insert(final List<Person> listPerson) {
		
		return jdbcTemplate.batchUpdate(INSERT, new PersonBatchSetter(listPerson));
		
	}
	
	public static final class PersonBatchSetter implements BatchPreparedStatementSetter{
		List<Person> listPerson;
		
		
		
		public PersonBatchSetter(List<Person> listPerson) {
			this.listPerson = listPerson;
		}

		@Override
		public int getBatchSize() {
			// TODO Auto-generated method stub
			return listPerson.size();
		}

		@Override
		public void setValues(PreparedStatement ps, int index) throws SQLException {
			// TODO Auto-generated method stub
			ps.setInt(1, listPerson.get(index).getpId());
			ps.setString(2, listPerson.get(index).getpName());
			ps.setString(3, listPerson.get(index).getpCountry());
		}
		
	}
}
