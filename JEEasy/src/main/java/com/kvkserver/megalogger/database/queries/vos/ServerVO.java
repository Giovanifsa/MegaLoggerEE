package com.kvkserver.megalogger.database.queries.vos;

import com.jeeasy.engine.database.entities.User;
import com.jeeasy.engine.queries.vos.AbstractVO;

public class ServerVO extends AbstractVO {
	private Long idServer;
	
	private User user;
	
	private String name;
	
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