package com.jeeasy.engine.utils.queries;

import java.io.Serializable;

public class QueryOrdering implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String orderColumn;
	private EnumOrderMethod method;
	
	public String getOrderColumn() {
		return orderColumn;
	}
	
	public void setOrderColumn(String orderColumn) {
		this.orderColumn = orderColumn;
	}

	public EnumOrderMethod getMethod() {
		return method;
	}

	public void setMethod(EnumOrderMethod method) {
		this.method = method;
	}
}
