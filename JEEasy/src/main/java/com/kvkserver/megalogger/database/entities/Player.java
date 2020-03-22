package com.kvkserver.megalogger.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayer;
	
	@Column(length = 32, nullable = false)
	private String steamID64;
	
	public Long getIdPlayer() {
		return idPlayer;
	}
	
	public void setIdPlayer(Long idPlayer) {
		this.idPlayer = idPlayer;
	}
	
	public String getSteamID64() {
		return steamID64;
	}
	
	public void setSteamID64(String steamID64) {
		this.steamID64 = steamID64;
	}
}
