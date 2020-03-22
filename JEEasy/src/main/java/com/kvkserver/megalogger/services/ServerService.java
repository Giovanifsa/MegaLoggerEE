package com.kvkserver.megalogger.services;

import com.jeeasy.engine.services.AbstractService;
import com.kvkserver.megalogger.database.eaos.ServerEAO;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;
import com.kvkserver.megalogger.services.validators.ServerValidator;

public class ServerService extends AbstractService<Server, ServerVO, ServerValidator, ServerEAO> {
	
}
