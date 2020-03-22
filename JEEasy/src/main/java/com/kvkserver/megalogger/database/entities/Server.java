package com.kvkserver.megalogger.database.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.jeeasy.engine.database.entities.AbstractEntity;
import com.jeeasy.engine.database.entities.User;

@Entity
public class Server extends AbstractEntity {
	public static final String SERVER_ENTITY = "Server";
	public static final String USER_ATTRIBUTE = "user";
	public static final String NAME_ATTRIBUTE = "name";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idServer;
	
	@ManyToOne
	@JoinColumn(name = "idUser", nullable = false)
	private User user;
	
	@Column(length = 64, nullable = false)
	private String name;
	
	@Column(length = 16)
	private String lastIp;
	
	private Integer port;

	public Long getIdServer() {
		return idServer;
	}

	public void setIdServer(Long idServer) {
		this.idServer = idServer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastIp() {
		return lastIp;
	}

	public void setLastIp(String lastIp) {
		this.lastIp = lastIp;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	@Override
	public Long getId() {
		return getIdServer();
	}
}
