package com.kvkserver.megalogger.database.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class PlayerName {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayerName;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@ManyToOne
	@JoinColumn(name = "idPlayerConnection", nullable = false)
	private PlayerConnection playerConnection;
	
	@Column(length = 32, nullable = false)
	private String name;

	public Long getIdPlayerName() {
		return idPlayerName;
	}

	public void setIdPlayerName(Long idPlayerName) {
		this.idPlayerName = idPlayerName;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public PlayerConnection getPlayerConnection() {
		return playerConnection;
	}

	public void setPlayerConnection(PlayerConnection playerConnection) {
		this.playerConnection = playerConnection;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
