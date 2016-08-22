package com.capgemini.chess.dataaccess.entities;


public class UserStatisticEntity {

	private long id;
	private String login;
	private String name;
	private int points;
	private int played;
	private int level;
	private int drawn;
	private int lost;
	private int won;

	public UserStatisticEntity() {

	}

	public UserStatisticEntity(final String login, final String name, final long id, final int level, final int points,
			final int played, final int won, final int lost) {

		this.login = login;
		this.name = name;
		this.id = id;
		this.level = level;
		this.points = points;
		this.played = played;
		this.won = won;
		this.lost = lost;
		this.drawn = played - won - lost;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getPlayed() {
		return played;
	}

	public void setPlayed(int played) {
		this.played = played;
	}

	public int getWon() {
		return won;
	}

	public void setWon(int won) {
		this.won = won;
	}

	public int getDrawn() {
		return drawn;
	}

	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	public int getLost() {
		return lost;
	}

	public void setLost(int lost) {
		this.lost = lost;
	}

}
