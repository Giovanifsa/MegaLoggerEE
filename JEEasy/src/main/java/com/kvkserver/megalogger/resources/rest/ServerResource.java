package com.kvkserver.megalogger.resources.rest;

import javax.ws.rs.Path;

import com.jeeasy.engine.resources.rest.CRUDResource;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;
import com.kvkserver.megalogger.resources.dto.ServerDTO;
import com.kvkserver.megalogger.services.ServerService;

@Path(ServerResource.PATH)
public class ServerResource extends CRUDResource<Server, ServerDTO, ServerVO, ServerService> {
	public static final String PATH = "/server";
}
