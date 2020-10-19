package com.jeeasy.engine.utils.queries;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.jeeasy.engine.queries.vos.AbstractVO;

public class PagedResultList<V extends AbstractVO> implements Iterable<V>, Serializable {
	private static final long serialVersionUID = 1L;
	
	private List<V> pagedResults = new ArrayList<>();
	private Long resultCount = 0L;

	public List<V> getPagedResults() {
		return pagedResults;
	}

	public void setPagedResults(List<V> pagedResults) {
		this.pagedResults = pagedResults;
	}

	public Long getResultCount() {
		return resultCount;
	}

	public void setResultCount(Long resultCount) {
		this.resultCount = resultCount;
	}

	public boolean addAll(Collection<V> collection) {
		return pagedResults.addAll(collection);
	}

	@Override
	public Iterator<V> iterator() {
		return pagedResults.iterator();
	}
}
