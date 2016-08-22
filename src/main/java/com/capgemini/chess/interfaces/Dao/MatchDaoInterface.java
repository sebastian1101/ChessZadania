package com.capgemini.chess.interfaces.Dao;

import java.util.List;

import com.capgemini.chess.dataaccess.entities.MatchEntity;

/**
 * 
 * DAO interface, created to store match data.
 * Created to execute matches when time
 * limit for move expired.
 * 
 * @author STOMCZYK
 *
 */
public interface MatchDaoInterface {

	/**
	 * Function return list of matches.
	 * 
	 * @return list of matches.
	 */
	public List<MatchEntity> getMatches();
	
	/**
	 * 
	 * Function return list of executed matches.
	 * 
	 * @return list of executed matches.
	 */
	public List<MatchEntity> getExecutedMatches();

	/**
	 * 
	 * Function executes matches which time to move has expired.
	 * 
	 * @param id ID of checking match.
	 * @return True when there was executed.
	 */
	boolean executeMatch(long id);

}