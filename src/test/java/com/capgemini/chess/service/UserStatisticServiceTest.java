package com.capgemini.chess.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.DAO.impl.UserStatisticDaoImpl;
import com.capgemini.chess.interfaces.Dao.UserStatisticDao;
import com.capgemini.chess.service.impl.UserStatisticServiceImpl;
import com.capgemini.chess.service.to.UserStatisticTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class UserStatisticServiceTest {

	@Autowired
	private UserStatisticService service;

	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public UserStatisticService userStatisticService() {
			return new UserStatisticServiceImpl();
		}

		@Bean
		public UserStatisticDao userStatisticDao() {
			return new UserStatisticDaoImpl();
		}
	}

	@Test
	public void testGetUserSuccessful() throws Exception {

		UserStatisticTO user = new UserStatisticTO();
		user.setDrawn(74);
		user.setId(1L);
		user.setLevel(10);
		user.setLogin("stomczyk123");
		user.setLost(40);
		user.setName("Sebastian Tomczyk");
		user.setPlayed(410);
		user.setPoints(76810);
		user.setWon(296);

		long id = 1L;
		UserStatisticTO userTo = service.getUserById(id);
		boolean isTrue = userTo.equals(user);
		assertTrue(isTrue);

	}
	
	@Test
	public void testGetWrongUser() throws Exception {

		UserStatisticTO user = new UserStatisticTO();
		user.setDrawn(50);
		user.setId(22L);
		user.setLevel(5);
		user.setLogin("pablo14");
		user.setLost(50);
		user.setName("Pablo Italiano");
		user.setPlayed(200);
		user.setPoints(767);
		user.setWon(100);

		long id = 1L;
		UserStatisticTO userTo = service.getUserById(id);
		boolean isTrue = userTo.equals(user);
		assertFalse(isTrue);

	}
}
