package com.java.agents.dao;

import java.util.List;

import com.java.agents.bean.Agent;

public interface AgentDAO {

	List<Agent> list();
	
	String add(Agent agent);
	
	Agent get(int agentId);
	
	String update(int agentId);
	
	String delete(int agentId);
	
}
