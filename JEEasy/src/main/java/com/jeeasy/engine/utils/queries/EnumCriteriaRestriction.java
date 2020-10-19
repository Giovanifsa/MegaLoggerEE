package com.jeeasy.engine.utils.queries;

public enum EnumCriteriaRestriction {
	AND("AND"),
	OR("OR"),
	;
	
	private final String criteriaRestriction;
	
	private EnumCriteriaRestriction(String criteriaRestriction) {
		this.criteriaRestriction = criteriaRestriction;
	}

	public String getCriteriaRestriction() {
		return criteriaRestriction;
	}
}
