package com.java.agents.dao;

import java.util.List;

import com.java.agents.bean.AgentBean;

public interface AgentDAO {

	List<AgentBean> list();
	
	String add(AgentBean agent);
	
	AgentBean get(int agentId);
	
	String update(AgentBean agent);
	
	String delete(int agentId);
	
}
