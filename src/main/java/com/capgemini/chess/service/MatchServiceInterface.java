package com.capgemini.chess.service;

import java.util.List;

import org.joda.time.DateTime;

import com.capgemini.chess.dataaccess.entities.MatchEntity;

public interface MatchServiceInterface {

	boolean executeMatch(long id);

	List<MatchEntity> getMatches();

	List<MatchEntity> getExecutedMatches();

	void checkMatches(DateTime time);

}