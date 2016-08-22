package com.capgemini.chess.service;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.capgemini.chess.DAO.impl.MatchDao;
import com.capgemini.chess.service.impl.MatchServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class MatchExecutionTest {

	@Autowired
	private MatchServiceImpl service;

	@Configuration
	static class RankServiceTestContextConfiguration {
		@Bean
		public MatchServiceImpl matchServiceImpl() {
			return new MatchServiceImpl();
		}

		@Bean
		public MatchDao matchDao() {
			return new MatchDao();
		}
	}

	@Test
	public void test() {
		// given
		DateTime actualTime = new DateTime();
		service.checkMatches(actualTime);

		// when
		int size = service.getExecutedMatches().size();

		// then
		assertEquals(2, size);
	}
}
