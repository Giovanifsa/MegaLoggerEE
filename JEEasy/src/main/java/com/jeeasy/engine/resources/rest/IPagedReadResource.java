package com.jeeasy.engine.resources.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.jeeasy.engine.queries.vos.AbstractVO;
import com.jeeasy.engine.utils.queries.PagedResultList;
import com.jeeasy.engine.utils.queries.QueryBuilder;

public interface IPagedReadResource<V extends AbstractVO> {
	@POST
	@Path("/paged")
	public PagedResultList<V> defaultPagedSearch(QueryBuilder queryHelper);
}
