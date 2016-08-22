package com.capgemini.chess.dataaccess.entities;

import org.joda.time.DateTime;

import com.capgemini.chess.enums.MatchResult;
import com.capgemini.chess.enums.PlayerTurn;

public class MatchEntity {

	private Long idMatch;
	private Long idPlayer1;
	private Long idPlayer2;
	private MatchResult result;
	private PlayerTurn playerTurn;
	private DateTime lastPlayerMove;

	private static final int timeDiff = 5;

	public MatchEntity(Long idMatch, Long idPlayer1, Long idPlayer2, MatchResult result, PlayerTurn playerTurn,
			DateTime timeMovePlayer) {

		this.idMatch = idMatch;
		this.idPlayer1 = idPlayer1;
		this.idPlayer2 = idPlayer2;
		this.result = result;
		this.playerTurn = playerTurn;
		this.lastPlayerMove = timeMovePlayer;
	}

	public static int getTimeDiff() {
		return timeDiff;
	}

	public PlayerTurn getPlayerTurn() {
		return playerTurn;
	}

	public void setPlayerTurn(PlayerTurn playerTurn) {
		this.playerTurn = playerTurn;
	}

	public Long getIdMatch() {
		return idMatch;
	}

	public void setIdMatch(Long idMatch) {
		this.idMatch = idMatch;
	}

	public Long getIdPlayer1() {
		return idPlayer1;
	}

	public void setIdPlayer1(Long idPlayer1) {
		this.idPlayer1 = idPlayer1;
	}

	public Long getIdPlayer2() {
		return idPlayer2;
	}

	public void setIdPlayer2(Long idPlayer2) {
		this.idPlayer2 = idPlayer2;
	}

	public MatchResult getResult() {
		return result;
	}

	public void setResult(MatchResult result) {
		this.result = result;
	}

	public DateTime getTimeAtLastPlayerMove() {
		return lastPlayerMove;
	}

	public void setLastPlayerMove(DateTime lastPlayerMove) {
		this.lastPlayerMove = lastPlayerMove;
	}

}
