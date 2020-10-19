package com.jeeasy.engine.resources.rest;

import javax.inject.Inject;

import com.jeeasy.engine.database.entities.AbstractEntity;
import com.jeeasy.engine.queries.vos.AbstractVO;
import com.jeeasy.engine.resources.dtos.AbstractDTO;
import com.jeeasy.engine.services.AbstractService;
import com.jeeasy.engine.utils.queries.PagedResultList;
import com.jeeasy.engine.utils.queries.QueryBuilder;


public abstract class CRUDResource<E extends AbstractEntity, D extends AbstractDTO<E>, V extends AbstractVO, 
								   S extends AbstractService<E, V, ?, ?>> extends AbstractDTOResource<E, D>  
									implements IWriteResource<E, D>, IReadResource<E, D>, IDeleteResource, IPagedReadResource<V> {
	@Inject
	private S service;
	
	@Override
	public D save(D incomming) {
		return convertEntityToDTO(service.save(convertDTOToEntity(incomming)));
	}

	@Override
	public D find(Long id) {
		return convertEntityToDTO(service.find(id));
	}
	
	@Override
	public void delete(Long id) {
		service.delete(id);
	}
	
	@Override
	public PagedResultList<V> defaultPagedSearch(QueryBuilder queryHelper) {
		return service.defaultPagedSearch(queryHelper);
	}

	public S getService() {
		return service;
	}
}
