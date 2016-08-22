package com.capgemini.chess.service;

import java.util.List;

import com.capgemini.chess.service.to.UserStatisticTO;
import com.capgemini.exception.UserStatisticException;

public interface UserStatisticService {

	/**
	 * 
	 * Method gets list of UserStatistic TO objects
	 * 
	 * @return UserStatistic TO objects
	 */
	List<UserStatisticTO> getList();

	/**
	 * 
	 * Method gets User with specified Id number
	 * 
	 * @param id idenity number
	 * @return UserStatistic TO object
	 * @throws UserStatisticException thrown when there was no user with specified id number.
	 */
	UserStatisticTO getUserById(long id) throws UserStatisticException;

}