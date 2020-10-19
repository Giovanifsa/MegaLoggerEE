package com.jeeasy.engine.utils.queries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryBuilder implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<QueryCriteria> queryCriterias = new ArrayList<>();
	private List<QueryOrdering> queryOrderings = new ArrayList<>();
	private Long limit = 10L;
	private Long offset = 0L;

	public Long getLimit() {
		return limit;
	}

	public void setLimit(Long limit) {
		this.limit = limit;
	}

	public Long getOffset() {
		return offset;
	}

	public void setOffset(Long offset) {
		this.offset = offset;
	}

	public List<QueryCriteria> getQueryCriterias() {
		return queryCriterias;
	}

	public void setQueryCriterias(List<QueryCriteria> queryCriterias) {
		this.queryCriterias = queryCriterias;
	}

	public List<QueryOrdering> getQueryOrderings() {
		return queryOrderings;
	}

	public void setQueryOrderings(List<QueryOrdering> queryOrderings) {
		this.queryOrderings = queryOrderings;
	}
	
	public void addQueryCriteria(QueryCriteria queryCriteria) {
		getQueryCriterias().add(queryCriteria);
	}
}
