package com.capgemini.chess.service.to;

public class UserStatisticTO {

	private String login;
	private String name;
	private long id;
	private int level;
	private int points;
	private int played;
	private int won;
	private int drawn;
	private int lost;

	public UserStatisticTO() {
		
	}
	
	public UserStatisticTO(String login, String name, long id, int level, int points, int played, int won, int drawn,
			int lost) {
		super();
		this.login = login;
		this.name = name;
		this.id = id;
		this.level = level;
		this.points = points;
		this.played = played;
		this.won = won;
		this.drawn = drawn;
		this.lost = lost;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + drawn;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + level;
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + lost;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + played;
		result = prime * result + points;
		result = prime * result + won;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserStatisticTO other = (UserStatisticTO) obj;
		if (drawn != other.drawn)
			return false;
		if (id != other.id)
			return false;
		if (level != other.level)
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (lost != other.lost)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (played != other.played)
			return false;
		if (points != other.points)
			return false;
		if (won != other.won)
			return false;
		return true;
	}

}
