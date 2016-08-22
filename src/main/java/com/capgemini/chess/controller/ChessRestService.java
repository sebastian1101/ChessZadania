package com.capgemini.chess.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.capgemini.chess.service.UserStatisticService;
import com.capgemini.chess.service.to.UserStatisticTO;
import com.capgemini.exception.UserStatisticException;

/**
 * 
 * Chess Rest Service
 * 
 * @author STOMCZYK
 *
 */
@Controller
@ResponseBody
public class ChessRestService {

	@Autowired
	private UserStatisticService statService;
	
	/**
	 * 
	 * Rest GET method finds and gets all books
	 * 
	 * @return list of UserStatistic TO objects
	 */
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public final List<UserStatisticTO> findAllStat() {
		return statService.getList();
	}
	
	/**
	 * 
	 * Rest GET methods finds and gets user with specified id number
	 * 
	 * @param id idenity number
	 * @return UserStatistic TO objects with specified id number
	 * @throws UserStatisticException thrown when there was no user with specified id number
	 */
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public final UserStatisticTO findUserById(@RequestParam("id") final Long id) throws UserStatisticException {
		return statService.getUserById(id);
	}
	
}
