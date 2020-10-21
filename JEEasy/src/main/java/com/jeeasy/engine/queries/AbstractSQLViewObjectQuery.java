package com.jeeasy.engine.queries;

import java.util.ArrayList;
import java.util.List;

import com.jeeasy.engine.queries.vos.AbstractVO;

public abstract class AbstractSQLViewObjectQuery<V extends AbstractVO> {
	private List<Object> queryParameters = new ArrayList<>();
	
	public abstract String getQuery();
	
	public abstract List<V> parseResultList(List<?> resultList);
	
	public List<Object> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(List<Object> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public boolean addQueryParameter(Object parameter) {
		return queryParameters.add(parameter);
	}
}
