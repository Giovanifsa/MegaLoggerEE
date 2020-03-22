package com.kvkserver.megalogger.resources.rest;

import com.jeeasy.engine.resources.rest.CRUDResource;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;
import com.kvkserver.megalogger.resources.dto.ServerDTO;
import com.kvkserver.megalogger.services.ServerService;

public class ServerResource extends CRUDResource<Server, ServerDTO, ServerVO, ServerService> {
	
}
