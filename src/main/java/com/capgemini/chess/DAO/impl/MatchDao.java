package com.capgemini.chess.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.PlayerTurn;
import com.capgemini.chess.interfaces.Dao.MatchDaoInterface;

/**
 * 
 * DAO implementation for storing match data. 
 * 
 * @author STOMCZYK
 *
 */
@Repository
public class MatchDao implements MatchDaoInterface {

	private List<MatchEntity> matches = new ArrayList<MatchEntity>();
	
	private List<MatchEntity> executedMatches = new ArrayList<MatchEntity>();

	public MatchDao() {
		addMatches();
	}

	public void addExecutedMatches(MatchEntity match) {
		executedMatches.add(match);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.chess.DAO.impl.MatchDaoInterface#deleteMatch(long)
	 */
	@Override
	public boolean executeMatch(long id) {
		for (int i = 0; i < matches.size(); i++) {
			if (matches.get(i).getIdMatch() == id) {
				addExecutedMatches(matches.get(i));
				matches.remove(i);
				return true;
			}
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.chess.DAO.impl.MatchDaoInterface#getMatches()
	 */
	@Override
	public List<MatchEntity> getMatches() {
		return matches;
	}

	@Override
	public List<MatchEntity> getExecutedMatches() {
		return executedMatches;
	}

	private void addMatches() {
		DateTime timeInit = new DateTime();
		timeInit.minusSeconds(7);
		matches.add(new MatchEntity(1L, 1L, 2L, MatchResult.Undefined, PlayerTurn.Player1, timeInit));
		matches.add(new MatchEntity(2L, 2L, 3L, MatchResult.Undefined, PlayerTurn.Player2, timeInit));
		matches.add(new MatchEntity(3L, 3L, 4L, MatchResult.Undefined, PlayerTurn.Player2, timeInit.minusSeconds(7)));
		matches.add(new MatchEntity(4L, 4L, 5L, MatchResult.Undefined, PlayerTurn.Player1, timeInit.minusSeconds(7)));
	}
}
