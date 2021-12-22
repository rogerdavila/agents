package com.java.agents.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.java.agents.bean.Agent;
import com.java.agents.bean.Gender;

public class AgentDAOImpl implements AgentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public AgentDAOImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Agent> list() {
		String sql = "select * from agent";

		List<Agent> agents = jdbcTemplate.query(sql, new RowMapper<Agent>() {

			@Override
			public Agent mapRow(ResultSet rs, int rowNum) throws SQLException {
				Agent agent = new Agent();

				agent.setAgentId(rs.getInt("agentId"));
				agent.setName(rs.getString("name"));
				agent.setCity(rs.getString("city"));
				agent.setGender(Gender.valueOf(rs.getString("gender")));
				agent.setMaritalStatus(rs.getInt("maritalstatus"));
				agent.setPremium(rs.getDouble("premium"));

				return agent;
			}

		});

		return agents;
	}

	@Override
	public String add(Agent agent) {
		String sql = "INSERT INTO AGENT(name,city,gender,"
				+ "maritalstatus,premium) values (?,?,?,?,?)";
		
		jdbcTemplate.update(sql, agent.getName(), agent.getCity(), agent.getGender().toString(),
				agent.getMaritalStatus(), agent.getPremium());
		
		return "Agent created successfully";
	}

	@Override
	public Agent get(int agentId) {
		String sql = "select * from Agent where agentId=?";
		return jdbcTemplate.query(sql, new Object[] { agentId }, new ResultSetExtractor<Agent>() {
			@Override
			public Agent extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Agent agent = new Agent();

					agent.setName(rs.getString("name"));
					agent.setCity(rs.getString("city"));
					agent.setGender(Gender.valueOf(rs.getString("gender")));
					agent.setMaritalStatus(rs.getInt("maritalstatus"));
					agent.setPremium(rs.getDouble("premium"));

					return agent;
				}
				return null;
			}
		});
	}

	@Override
	public String update(int agentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(int agentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
