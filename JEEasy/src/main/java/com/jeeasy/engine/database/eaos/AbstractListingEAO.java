package com.jeeasy.engine.database.eaos;

import com.jeeasy.engine.database.entities.AbstractEntity;
import com.jeeasy.engine.queries.vos.AbstractVO;
import com.jeeasy.engine.utils.queries.PagedResultList;
import com.jeeasy.engine.utils.queries.QueryBuilder;

public abstract class AbstractListingEAO<E extends AbstractEntity, V extends AbstractVO> extends AbstractEAO<E> {
	public abstract PagedResultList<V> getDefaultPagedResultList(QueryBuilder querySettings);
}