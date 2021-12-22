package com.java.agents.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.java.agents.bean.Agent;
import com.java.agents.dao.AgentDAO;

@Controller
public class HomeController {
	
	@Autowired
	private AgentDAO agentDAO;

	@RequestMapping(value="/")
	public ModelAndView listAgents(ModelAndView model) throws IOException{
		List<Agent> agents = agentDAO.list();
		
		model.setViewName("home");
		model.addObject("agents", agents);
		
		return model;
	}
	
	@RequestMapping(value = "addagent", method = RequestMethod.GET)
	public ModelAndView addAgent(ModelAndView model) {
		Agent agent = new Agent();
		model.addObject("agent", agent);
		model.setViewName("agentform");
		
		return model;
	}
	
	@RequestMapping(value = "saveagent", method = RequestMethod.POST)
	 public ModelAndView saveComplaint(@ModelAttribute Agent agent) {
	     agentDAO.add(agent);
	     return new ModelAndView("redirect:/");
	 } 
}
