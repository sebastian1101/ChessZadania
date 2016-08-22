package com.capgemini.chess.service.impl;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.DAO.impl.MatchDao;
import com.capgemini.chess.dataaccess.entities.MatchEntity;
import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.PlayerTurn;
import com.capgemini.chess.service.MatchServiceInterface;

@Service
public class MatchServiceImpl implements MatchServiceInterface {

	@Autowired
	private MatchDao matches;

	/* (non-Javadoc)
	 * @see com.capgemini.chess.service.impl.MatchServiceInterface#executeMatch(long)
	 */
	@Override
	public boolean executeMatch(long id) {
		return matches.executeMatch(id);
	}

	/* (non-Javadoc)
	 * @see com.capgemini.chess.service.impl.MatchServiceInterface#getMatches()
	 */
	@Override
	public List<MatchEntity> getMatches() {
		return matches.getMatches();
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.chess.service.impl.MatchServiceInterface#getExecutedMatches()
	 */
	@Override
	public List<MatchEntity> getExecutedMatches() {
		return matches.getExecutedMatches();
	}

	/* (non-Javadoc)
	 * @see com.capgemini.chess.service.impl.MatchServiceInterface#checkMatches(org.joda.time.DateTime)
	 */
	@Override
	public void checkMatches(DateTime time) {
		int timeSecDiff;
		for (MatchEntity match : matches.getMatches()) {
			if(time.getMinuteOfHour() == match.getTimeAtLastPlayerMove().getMinuteOfHour()) {
				timeSecDiff = Math.abs(time.getSecondOfMinute() - match.getTimeAtLastPlayerMove().getSecondOfMinute());				
			} else {
				timeSecDiff = 60 - match.getTimeAtLastPlayerMove().getSecondOfMinute() + time.getSecondOfMinute();
			}
			if (match.getPlayerTurn() == PlayerTurn.Player1) {
				if (timeSecDiff > MatchEntity.getTimeDiff()) {
					match.setResult(MatchResult.Player1Lost);
				}
			} else {
				if (timeSecDiff > MatchEntity.getTimeDiff()) {
					match.setResult(MatchResult.Player2Lost);
				}
			}
		}
		for (MatchEntity match : matches.getMatches()) {
			if (match.getResult() == MatchResult.Player1Lost || match.getResult() == MatchResult.Player2Lost) {
				matches.addExecutedMatches(match);
			}
		}
	}

}
