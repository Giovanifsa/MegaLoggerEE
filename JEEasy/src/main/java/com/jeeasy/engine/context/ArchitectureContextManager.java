package com.jeeasy.engine.context;

import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class ArchitectureContextManager {
	private static final ThreadLocal<ArchitectureContext> contextualizedThreads = new ThreadLocal<>();

	@Produces
	public static ArchitectureContext getForThread() {
		ArchitectureContext context = contextualizedThreads.get();
		
		if (context == null) {
			context = new ArchitectureContext();
		}
		
		setForThread(context);
		
		return context;
	}
	
	public static void setForThread(ArchitectureContext context) {
		contextualizedThreads.set(context);
	}

	public static void destroyForThread() {
		contextualizedThreads.remove();
	}
	
	public static void forceSystemUserContext() {
		
	}
}
