package com.jeeasy.engine.queries;

import java.math.BigInteger;
import java.util.List;

import com.jeeasy.engine.queries.vos.UserVO;
import com.jeeasy.engine.utils.data.ListUtils;

public class UserDefaultQuery extends AbstractSQLViewObjectQuery<UserVO> {

	@Override
	public String getQuery() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" SELECT ");
		sb.append(" 	idUser, ");
		sb.append(" 	userName ");
		sb.append("	FROM User ");
		
		return sb.toString();
	}

	@Override
	public List<UserVO> parseResultList(List<?> resultList) {
		return ListUtils.convertList(resultList, (result) -> {
			Object[] resultItems = (Object[]) result;
			
			UserVO userVO = new UserVO();
			userVO.setIdUser(((BigInteger) resultItems[0]).longValue());
			userVO.setUserName((String) resultItems[1]);
			
			return userVO;
		});
	}
}
