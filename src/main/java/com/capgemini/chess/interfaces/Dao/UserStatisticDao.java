package com.capgemini.chess.interfaces.Dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserStatisticEntity;
import com.capgemini.exception.UserStatisticException;

/**
 * 
 * Interface for StatisticDao implementation.
 * 
 * @author STOMCZYK
 *
 */
public interface UserStatisticDao {

	/**
	 * 
	 * Function return list of Users statistics.
	 * 
	 * @return List of user statistic entity.
	 */
	List<UserStatisticEntity> getList();

	/**
	 * 
	 * Function returns User statistics with specified id.
	 * 
	 * @param id ID number
	 * @return User statistics
	 * @throws UserStatisticException thrown when no user statistic were found. 
	 */
	UserStatisticEntity getUserById(final long id) throws UserStatisticException;

}