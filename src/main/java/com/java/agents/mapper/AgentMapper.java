package com.java.agents.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.CollectionUtils;

import com.java.agents.bean.AgentBean;
import com.java.agents.entity.Agent;

public class AgentMapper {

	public static List<AgentBean> entityListToBeanList(List<Agent> agents) {

		if (CollectionUtils.isEmpty(agents))
			return new ArrayList<AgentBean>();
		
		List<AgentBean> beans = new ArrayList<AgentBean>();
		
		for (Agent agent : agents) {
			beans.add(entityToBean(agent));
		}

		return beans;
	}

	public static AgentBean entityToBean(Agent agent) {
		if (agent == null)
			return null;

		AgentBean bean = new AgentBean();

		bean.setAgentId(agent.getAgentId());
		bean.setCity(agent.getCity());
		bean.setGender(agent.getGender());
		bean.setMaritalStatus(agent.getMaritalStatus());
		bean.setName(agent.getName());
		bean.setPremium(agent.getPremium());

		return bean;
	}

	public static Agent beanToEntity(AgentBean bean, Agent agent) {

		agent.setCity(bean.getCity());
		agent.setGender(bean.getGender());
		agent.setMaritalStatus(bean.getMaritalStatus());
		agent.setName(bean.getName());
		agent.setPremium(bean.getPremium());
		
		return agent;
	}

}
