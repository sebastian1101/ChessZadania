package com.capgemini.chess.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.chess.interfaces.Dao.UserStatisticDao;
import com.capgemini.chess.service.UserStatisticService;
import com.capgemini.chess.service.mapper.UserStatisticMapper;
import com.capgemini.chess.service.to.UserStatisticTO;
import com.capgemini.exception.UserStatisticException;

@Service
public class UserStatisticServiceImpl implements UserStatisticService {

	@Autowired
	private UserStatisticDao userStatisticDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.capgemini.chess.service.impl.UserStatisticService#getList()
	 */
	@Override
	public final List<UserStatisticTO> getList() {
		return UserStatisticMapper.mapEntities2TOs(userStatisticDao.getList());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.capgemini.chess.service.impl.UserStatisticService#getUserById(int)
	 */
	@Override
	public final UserStatisticTO getUserById(final long id) throws UserStatisticException {
		return UserStatisticMapper.entity2TO(userStatisticDao.getUserById(id));
	}
}
