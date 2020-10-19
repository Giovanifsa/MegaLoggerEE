package com.kvkserver.megalogger.database.eaos;

import java.util.List;

import javax.persistence.TypedQuery;

import com.jeeasy.engine.database.eaos.AbstractListingEAO;
import com.jeeasy.engine.database.entities.User;
import com.jeeasy.engine.utils.queries.PagedResultList;
import com.jeeasy.engine.utils.queries.QueryBuilder;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;

public class ServerEAO extends AbstractListingEAO<Server, ServerVO> {
	@Override
	public PagedResultList<ServerVO> getDefaultPagedResultList(QueryBuilder querySettings) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Long> findServersOwnedByUser(User user) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT sv.idServer ");
		sb.append(" FROM Server sv ");
		sb.append(" WHERE sv.user = :user ");
		
		TypedQuery<Long> query = createTypedQuery(sb, Long.class);
		query.setParameter("user", user);
		
		return getResultList(query);
	}
}
