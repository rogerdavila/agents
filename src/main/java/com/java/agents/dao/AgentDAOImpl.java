package com.java.agents.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.java.agents.bean.AgentBean;
import com.java.agents.entity.Agent;
import com.java.agents.mapper.AgentMapper;

public class AgentDAOImpl implements AgentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<AgentBean> list() {
		Session session = sessionFactory.openSession();
		
		Query q = session.createQuery("from Agent");
		
		List<Agent> agents = q.list();
		
		return AgentMapper.entityListToBeanList(agents);
	}

	@Override
	public String add(AgentBean bean) {
		Agent agent = AgentMapper.beanToEntity(bean, new Agent());
		
		Session session = sessionFactory.openSession();
		Transaction t = session.beginTransaction();
		session.save(agent);
		t.commit();
		
		return "Agent created successfully";
	}

	@Override
	public AgentBean get(int agentId) {
		Session session = sessionFactory.openSession();
		
		Agent agent = (Agent) session.byId(Agent.class).load(agentId);
		
		return AgentMapper.entityToBean(agent);
//		Query q = session.createQuery("from Agent where agentId = " + agentId);
//		List<Agent> agents = q.list();
//		if (agents.size() == 1) {
//			return AgentMapper.entityToBean(agents.get(0));
//		}
//		return null;
	}

	@Override
	public String update(AgentBean bean) {
		Session session = sessionFactory.openSession();
		
		Agent agent = (Agent) session.byId(Agent.class).load(bean.getAgentId());
		Transaction t = session.beginTransaction();
		AgentMapper.beanToEntity(bean, agent);
		session.save(agent);
		t.commit();
		
		return "Agent updated successfully";
	}

	@Override
	public String delete(int agentId) {
		Session session = sessionFactory.openSession();
		Agent agent = (Agent) session.byId(Agent.class).load(agentId);
		Transaction t = session.beginTransaction();
		session.delete(agent);
		t.commit();
		
		return "Agent deleted successfully";
	}

}
