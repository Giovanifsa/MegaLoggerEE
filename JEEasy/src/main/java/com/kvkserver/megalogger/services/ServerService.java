package com.kvkserver.megalogger.services;

import java.util.Arrays;
import java.util.List;

import com.jeeasy.engine.database.entities.User;
import com.jeeasy.engine.services.AbstractService;
import com.jeeasy.engine.services.UserService;
import com.jeeasy.engine.utils.dependencies.IDependencyBean;
import com.kvkserver.megalogger.database.eaos.ServerEAO;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;
import com.kvkserver.megalogger.services.validators.ServerValidator;

public class ServerService extends AbstractService<Server, ServerVO, ServerValidator, ServerEAO> {
	@Override
	public List<Class<? extends IDependencyBean>> getDependencies() {
		return Arrays.asList(UserService.class);
	}
	
	@Override
	protected void onDependencyServicePreDelete(Class<? extends AbstractService<?, ?, ?, ?>> dependencyService, Object deletedEntity) {
		if (UserService.class.equals(dependencyService)) {
			delete(getEAO().findServersOwnedByUser((User) deletedEntity));
		}
	}
}
