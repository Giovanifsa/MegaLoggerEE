package com.jeeasy.engine.resources.rest.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

@Provider
public class DisableCorsFilter implements ContainerResponseFilter {
	private static final List<Object> ALLOW_ALL = Arrays.asList("*");
	
	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
		MultivaluedMap<String, Object> headers = responseContext.getHeaders();
		
		headers.put("Access-Control-Allow-Origin", ALLOW_ALL);
		headers.put("Access-Control-Allow-Headers", ALLOW_ALL);
		headers.put("Access-Control-Allow-Methods", ALLOW_ALL);
	}
}
