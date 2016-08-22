package com.capgemini.chess.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.capgemini.chess.dataaccess.entities.UserStatisticEntity;
import com.capgemini.chess.interfaces.Dao.UserStatisticDao;
import com.capgemini.exception.UserStatisticException;

/**
 * 
 * DAO implementation for storing statistic data. 
 * 
 * @author STOMCZYK
 *
 */
@Repository
public class UserStatisticDaoImpl implements UserStatisticDao {

	public UserStatisticDaoImpl() {
		addStatistic();
	}

	private List<UserStatisticEntity> ranking = new ArrayList<UserStatisticEntity>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.chess.DAO.impl.UserStatisticDao#showList(java.lang.String)
	 */
	@Override
	public final List<UserStatisticEntity> getList() {

		return ranking;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.chess.DAO.impl.UserStatisticDao#findUser(java.lang.String)
	 */
	@Override
	public final UserStatisticEntity getUserById(final long id) throws UserStatisticException {
		for(UserStatisticEntity user : ranking) {
			if( user.getId() == id) {
				return user;
			}
		}
		throw new UserStatisticException("UserStatistic not found.");
	}

	private void addStatistic() {
		ranking.add(new UserStatisticEntity("stomczyk123", "Sebastian Tomczyk", 1L, 10, 76810, 410, 296, 40));
		ranking.add(new UserStatisticEntity("adamRex", "Adam Rekelski", 2L, 10, 76802, 405, 292, 41));
		ranking.add(new UserStatisticEntity("basiaSuper", "Barbara Kot", 3L, 8, 19250, 240, 137, 43));
		ranking.add(new UserStatisticEntity("ewcia3", "Ewa Mikulska", 4L, 7, 9650, 182, 90, 37));
		ranking.add(new UserStatisticEntity("pitek21", "Piotrek Wilk", 5L, 6, 4820, 130, 54, 58));
		ranking.add(new UserStatisticEntity("arkooMistrz", "Arkadiusz Styczeń", 6L, 5, 2422, 85, 29, 53));
		ranking.add(new UserStatisticEntity("paulaXxX", "Paulina Kowalska", 7L, 2, 350, 15, 2, 7));
		ranking.add(new UserStatisticEntity("Radoo_Mutant", "Radosław Zarwal", 8L, 2, 330, 12, 1, 10));
	}

}
