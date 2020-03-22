package com.kvkserver.megalogger.resources.dto;

import com.jeeasy.engine.resources.dtos.AbstractDTO;
import com.jeeasy.engine.resources.dtos.UserDTO;
import com.kvkserver.megalogger.database.entities.Server;

public class ServerDTO extends AbstractDTO<Server> {
	private Long idServer;
	
	private UserDTO user;
	
	private String name;
	
	private String lastIp;
	
	private Integer port;
	
	public Long getIdServer() {
		return idServer;
	}

	public void setIdServer(Long idServer) {
		this.idServer = idServer;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
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
	public void readFromEntity(Server entity) {
		if (entity != null) {
			if (entity.getUser() != null) {
				user = new UserDTO();
				user.readFromEntity(entity.getUser());
			}
			
			setIdServer(entity.getId());
			setName(entity.getName());
			setLastIp(entity.getLastIp());
			setPort(entity.getPort());
		}
	}

	@Override
	public Server convertDTOtoEntity() {
		Server server = new Server();
		
		if (getUser() != null) {
			server.setUser(getUser().convertDTOtoEntity());
		}
		
		server.setIdServer(getIdServer());
		server.setLastIp(getLastIp());
		server.setName(getName());
		server.setPort(getPort());
		
		return server;
	}

	@Override
	public Long getId() {
		return getIdServer();
	}
}
