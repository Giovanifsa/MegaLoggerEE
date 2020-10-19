package com.jeeasy.engine.utils.queries;

public enum EnumOrderMethod {
	ORDER_ASCENDING("ASC"),
	ORDER_DESCENDING("DESC");
	
	private final String orderMethod;
	
	private EnumOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}

	public String getOrderMethod() {
		return orderMethod;
	}
}
