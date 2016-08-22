package com.capgemini.chess.service.mapper;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.dataaccess.entities.UserStatisticEntity;
import com.capgemini.chess.service.to.UserStatisticTO;

public class UserStatisticMapper {

	public static UserStatisticTO entity2TO(UserStatisticEntity entity) {

		if (entity != null) {
			UserStatisticTO statTO = new UserStatisticTO();
			statTO.setDrawn(entity.getDrawn());
			statTO.setId(entity.getId());
			statTO.setLevel(entity.getLevel());
			statTO.setLogin(entity.getLogin());
			statTO.setLost(entity.getLost());
			statTO.setName(entity.getName());
			statTO.setPlayed(entity.getPlayed());
			statTO.setPoints(entity.getPoints());
			statTO.setWon(entity.getWon());

			return statTO;
		}
		return null;
	}

	public static UserStatisticEntity TO2Entity(UserStatisticTO statTO) {

		if (statTO != null) {
			UserStatisticEntity entity = new UserStatisticEntity();
			entity.setDrawn(statTO.getDrawn());
			entity.setId(statTO.getId());
			entity.setLevel(statTO.getLevel());
			entity.setLogin(statTO.getLogin());
			entity.setLost(statTO.getLost());
			entity.setName(statTO.getName());
			entity.setPlayed(statTO.getPlayed());
			entity.setPoints(statTO.getPoints());
			entity.setWon(statTO.getWon());

			return entity;
		}
		return null;
	}

	public static List<UserStatisticTO> mapEntities2TOs(List<UserStatisticEntity> entities) {
		List<UserStatisticTO> TOs = new ArrayList<UserStatisticTO>();

		for (UserStatisticEntity entity : entities) {
			TOs.add(entity2TO(entity));
		}
		return TOs;
	}

	public static List<UserStatisticEntity> mapTOs2Entities(List<UserStatisticTO> TOs) {
		List<UserStatisticEntity> entities = new ArrayList<UserStatisticEntity>();

		for (UserStatisticTO to : TOs) {
			entities.add(TO2Entity(to));
		}
		return entities;
	}

}
