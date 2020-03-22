package com.kvkserver.megalogger.database.eaos;

import com.jeeasy.engine.database.eaos.AbstractListingEAO;
import com.jeeasy.engine.queries.PagedResultList;
import com.jeeasy.engine.queries.QuerySettings;
import com.kvkserver.megalogger.database.entities.Server;
import com.kvkserver.megalogger.database.queries.vos.ServerVO;

public class ServerEAO extends AbstractListingEAO<Server, ServerVO> {
	@Override
	public PagedResultList<ServerVO> getDefaultPagedResultList(QuerySettings querySettings) {
		// TODO Auto-generated method stub
		return null;
	}
}
