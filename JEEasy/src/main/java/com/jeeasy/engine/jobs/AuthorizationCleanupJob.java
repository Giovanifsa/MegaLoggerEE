package com.jeeasy.engine.jobs;

import javax.ejb.ScheduleExpression;

import com.jeeasy.engine.context.annotations.ForcedSystemUserContext;
import com.jeeasy.engine.services.UserAuthorizationService;
import com.jeeasy.engine.utils.cdi.CDIUtils;

public class AuthorizationCleanupJob implements ITimedJob {
	@Override
	public ScheduleExpression getSchedule() {
		ScheduleExpression scheduleExpression = new ScheduleExpression();
		scheduleExpression.hour("*");
		scheduleExpression.minute("*");
		
		return scheduleExpression;
	}

	@Override
	@ForcedSystemUserContext
	public void runJob() {
		UserAuthorizationService authService = CDIUtils.inject(UserAuthorizationService.class);
		
		authService.cleanupExpiredAuthorizations();
	}
}
