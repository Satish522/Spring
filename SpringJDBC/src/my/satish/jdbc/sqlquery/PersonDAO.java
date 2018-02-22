package my.satish.jdbc.sqlquery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.object.UpdatableSqlQuery;
import org.springframework.jdbc.support.KeyHolder;

import my.satish.jdbc.Person;

public class PersonDAO {
	public static final String SELECT="select * from person where p_name=?";
	
	public static final String UPDATE="update person set P_name = ? where p_id=?";
	
	private DataSource dataSource;

	public void setdDtaSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<Person> serchByName(String name){
		return new SelectPerson(dataSource).searchPersonByName(name);
	}
	
	public int update(String name,int id) {
		return new UpdatePerson(dataSource).update(name, id);
	}
	
	private final class SelectPerson extends MappingSqlQuery<Person>{

		public SelectPerson(DataSource dataSource) {
			 super(dataSource,SELECT);
			 super.declareParameter(new SqlParameter("p_name",Types.VARCHAR));
			 super.compile();
		}

		@Override
		protected Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			// TODO Auto-generated method stub
			return new Person(rs.getInt("p_id"), rs.getString("p_name"), rs.getString("p_country"));
		}

		public List<Person> searchPersonByName(String name) {
			// TODO Auto-generated method stub
			return execute(name);
		}
		
	}
	
	private final class UpdatePerson extends SqlUpdate{
		
		public UpdatePerson(DataSource dataSource) {
			super(dataSource, UPDATE);
			declareParameter(new SqlParameter(Types.VARCHAR));
			declareParameter(new SqlParameter(Types.INTEGER));
			compile();
		}
		
		public int update(String name,String id) {
			return update(new Object[] {name,id});
		}
	}
}
