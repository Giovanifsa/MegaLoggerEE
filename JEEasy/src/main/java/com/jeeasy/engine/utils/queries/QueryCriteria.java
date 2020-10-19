package com.jeeasy.engine.utils.queries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class QueryCriteria implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String column;
	private Object criteriaData;
	private EnumCriteriaCondition condition;
	private EnumCriteriaRestriction restriction;
	private List<QueryCriteria> linkedCriterias = new ArrayList<>();

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public Object getCriteriaData() {
		return criteriaData;
	}

	public void setCriteriaData(Object criteriaData) {
		this.criteriaData = criteriaData;
	}

	public EnumCriteriaCondition getCondition() {
		return condition;
	}

	public void setCondition(EnumCriteriaCondition condition) {
		this.condition = condition;
	}

	public EnumCriteriaRestriction getRestriction() {
		return restriction;
	}

	public void setRestriction(EnumCriteriaRestriction restriction) {
		this.restriction = restriction;
	}

	public List<QueryCriteria> getLinkedCriterias() {
		return linkedCriterias;
	}

	public void setLinkedCriterias(List<QueryCriteria> linkedCriterias) {
		this.linkedCriterias = linkedCriterias;
	}
	
	public void linkQueryCriteria(QueryCriteria queryCriteria) {
		getLinkedCriterias().add(queryCriteria);
	}
}
