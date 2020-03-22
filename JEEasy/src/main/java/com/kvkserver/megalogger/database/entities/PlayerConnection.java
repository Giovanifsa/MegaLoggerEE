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
public class PlayerConnection {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPlayerConnection;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	
	@ManyToOne
	@JoinColumn(name = "idServer", nullable = false)
	private Server server;
	
	@ManyToOne
	@JoinColumn(name = "idPlayer", nullable = false)
	private Player player;
	
	@Column(length = 16, nullable = false)
	private String ip;
	
	@Column(nullable = false)
	private Integer port;

	public Long getIdPlayerConnection() {
		return idPlayerConnection;
	}

	public void setIdPlayerConnection(Long idPlayerConnection) {
		this.idPlayerConnection = idPlayerConnection;
	}

	public Server getServer() {
		return server;
	}

	public void setServer(Server server) {
		this.server = server;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
}
