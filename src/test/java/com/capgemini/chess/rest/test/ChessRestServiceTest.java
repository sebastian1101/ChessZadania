package com.capgemini.chess.rest.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.chess.service.UserStatisticService;
import com.capgemini.chess.service.to.UserStatisticTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class ChessRestServiceTest {

	@Autowired
	private UserStatisticService statService;
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		Mockito.reset(statService);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void testShouldGetAllBooks() throws Exception {

		// given:
		Long id = new Long(1);
		final UserStatisticTO user = new UserStatisticTO();
		user.setName("Jan");
		user.setId(id);
		user.setLevel(4);
		user.setPoints(1210);
		user.setPlayed(46);
		user.setDrawn(20);
		user.setWon(11);
		user.setLost(15);

		Mockito.when(statService.getUserById(1L)).thenReturn(user);
		// when
		ResultActions response = this.mockMvc.perform(get("/getUser").param("id", Long.toString(user.getId()))
				.accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				.andExpect(jsonPath("name").value(user.getName()))
				// .andExpect(jsonPath("id").value(user.getId()))
				.andExpect(jsonPath("level").value(user.getLevel()))
				.andExpect(jsonPath("points").value(user.getPoints()))
				.andExpect(jsonPath("played").value(user.getPlayed())).andExpect(jsonPath("won").value(user.getWon()))
				.andExpect(jsonPath("drawn").value(user.getDrawn())).andExpect(jsonPath("lost").value(user.getLost()));
	}

	@Test
	public void testShouldSearchBookByTitleAndAuthor() throws Exception {

		// given:
		Long id = new Long(1);
		final UserStatisticTO user1 = new UserStatisticTO();
		user1.setName("Jan");
		user1.setId(id);
		user1.setLevel(4);
		user1.setPoints(1210);
		user1.setPlayed(46);
		user1.setDrawn(20);
		user1.setWon(11);
		user1.setLost(15);

		List<UserStatisticTO> usersStat = new ArrayList<UserStatisticTO>();
		usersStat.add(user1);

		Mockito.when(statService.getList()).thenReturn(Arrays.asList(user1));
		// when
		ResultActions response = this.mockMvc.perform(
				get("/getAll").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).content("1"));

		response.andExpect(status().isOk())//
				// .andExpect(jsonPath("id").value(user.getId()))
				.andExpect(jsonPath("[0].level").value(user1.getLevel()))
				.andExpect(jsonPath("[0].points").value(user1.getPoints()))
				.andExpect(jsonPath("[0].played").value(user1.getPlayed()))
				.andExpect(jsonPath("[0].won").value(user1.getWon()))
				.andExpect(jsonPath("[0].drawn").value(user1.getDrawn()))
				.andExpect(jsonPath("[0].lost").value(user1.getLost()));

	}
}
