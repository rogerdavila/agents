package com.java.agents.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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

	@RequestMapping(value = "/")
	public ModelAndView listAgents(ModelAndView model) throws IOException {
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
	public ModelAndView saveAgent(@ModelAttribute Agent agent) {
		agentDAO.add(agent);
		return new ModelAndView("redirect:/");
	}

	@RequestMapping(value = "/editagent")
	public ModelAndView editAgent(HttpServletRequest request) {
		int agentId = Integer.parseInt(request.getParameter("agentId"));
		Agent agent = agentDAO.get(agentId);
		ModelAndView model = new ModelAndView("agentsearchform");
		model.addObject("agent", agent);

		return model;
	}

	@RequestMapping(value = "/updateagent", method = RequestMethod.POST)
	public ModelAndView updateagent(@ModelAttribute Agent agent) {
		agentDAO.update(agent);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteagent", method = RequestMethod.GET)
	public ModelAndView deleteAgent(HttpServletRequest request) {
		int agentId = Integer.parseInt(request.getParameter("agentId"));
		agentDAO.delete(agentId);
		return new ModelAndView("redirect:/");
	}
}
