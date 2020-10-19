package com.jeeasy.engine.context.annotations;

import java.io.Serializable;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jeeasy.engine.context.ArchitectureContext;
import com.jeeasy.engine.context.ArchitectureContextManager;
import com.jeeasy.engine.database.eaos.UserEAO;
import com.jeeasy.engine.database.entities.User;
import com.jeeasy.engine.exceptions.FailureRuntimeException;
import com.jeeasy.engine.exceptions.codes.EnumFailureExceptionCodes;
import com.jeeasy.engine.jobs.TimedJobManager;
import com.jeeasy.engine.translations.EnumFailuresTranslations;
import com.jeeasy.engine.translations.Translator;
import com.jeeasy.engine.utils.cdi.CDIUtils;

@ForcedSystemUserContext
@Interceptor
public class ForcedSystemUserContextInterceptor implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LogManager.getLogger(TimedJobManager.class);

	@Inject
	private UserEAO userEAO;
	
	@Inject
	private Translator translator;
	
	@AroundInvoke
	public Object forceSystemUserContext(InvocationContext invocationContext) throws Exception {
		ArchitectureContext lastContext = CDIUtils.inject(ArchitectureContext.class);
		
		ArchitectureContext newContext = new ArchitectureContext();
		ArchitectureContextManager.setForThread(newContext);
		
		User systemUser = userEAO.findByUserName("system");
		
		if (systemUser == null) {
			rollbackContext(lastContext);
			
			throw new FailureRuntimeException(translator.translateForContextLanguage(
					EnumFailuresTranslations.FAILED_TO_FIND_SYSTEM_USER),
					EnumFailureExceptionCodes.FAILED_TO_FIND_SYSTEM_USER);
		}
		
		newContext.setUser(systemUser);
		
		logger.info("Enforcing System User (from {})", lastContext.getUser() != null ? 
													   lastContext.getUser().getUserName() : 
													   "NO USER");
		
		try {
			Object invocationReturn = invocationContext.proceed();
			return invocationReturn;
		} 
		
		finally {
			rollbackContext(lastContext);
		}
	}
	
	private void rollbackContext(ArchitectureContext lastContext) {
		ArchitectureContextManager.setForThread(lastContext);
	}
}
