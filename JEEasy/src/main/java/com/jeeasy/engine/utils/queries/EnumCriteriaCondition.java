package com.jeeasy.engine.utils.queries;

public enum EnumCriteriaCondition {
	EQUALS("="),
	NOT_EQUALS("<>"),
	LIKE("LIKE")
	;
	
	private final String criteriaCondition;
	
	private EnumCriteriaCondition(String criteriaCondition) {
		this.criteriaCondition = criteriaCondition;
	}

	public String getCriteriaCondition() {
		return criteriaCondition;
	}
}
