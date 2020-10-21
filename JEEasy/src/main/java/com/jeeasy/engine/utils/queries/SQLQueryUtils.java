package com.jeeasy.engine.utils.queries;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import com.jeeasy.engine.database.eaos.PersistenceManager;
import com.jeeasy.engine.queries.AbstractSQLViewObjectQuery;
import com.jeeasy.engine.queries.vos.AbstractVO;
import com.jeeasy.engine.utils.cdi.CDIUtils;
import com.jeeasy.engine.utils.data.ListUtils;

public final class SQLQueryUtils {
	private SQLQueryUtils() {};
	
	public static <V extends AbstractVO> PagedResultList<V> getPagedResultList(AbstractSQLViewObjectQuery<V> voQuery, QueryBuilder queryBuilder) {
		PersistenceManager entityManager = CDIUtils.inject(PersistenceManager.class);
		
		List<Object> queryParameters = new ArrayList<>(voQuery.getQueryParameters());
		queryParameters.addAll(getQueryBuilderParameters(queryBuilder));

		String selectQuery = prepareQuery(voQuery.getQuery(), false, queryBuilder);
		
		Query queryForColumns = entityManager.createNativeQuery(selectQuery);
		setQueryParameters(queryParameters, queryForColumns);
		
		List<V> parsedResultList = voQuery.parseResultList(queryForColumns.getResultList());
		
		String selectCount = prepareQuery(voQuery.getQuery(), true, queryBuilder);
		
		Query queryForCount = entityManager.createNativeQuery(selectCount);
		setQueryParameters(queryParameters, queryForCount);
		
		BigInteger parsedCount = (BigInteger) queryForCount.getSingleResult(); 
		
		PagedResultList<V> pagedResults = new PagedResultList<>();
		pagedResults.addAll(parsedResultList);
		pagedResults.setResultCount(parsedCount.longValue());
		
		return pagedResults;
	}
	
	public static void setQueryParameters(List<Object> queryParameters, Query query) {
		for (int idx = 0; idx < queryParameters.size(); idx++) {
			query.setParameter(idx, queryParameters.get(idx));
		}
	}
	
	public static String prepareQuery(String query, boolean countQuery, QueryBuilder queryBuilder) {
		StringBuilder sb = new StringBuilder();
		
		if (countQuery) {
			sb.append(" SELECT COUNT(*) FROM ( ");
		}
		
		else {
			sb.append(" SELECT * FROM ( ");
		}
		
		sb.append(		query);
		sb.append(" ) ML_SUBSELECT ");
		
		if (ListUtils.listHasItems(queryBuilder.getQueryCriterias())) {
			sb.append(" WHERE ");
			sb.append(prepareWhereClause(queryBuilder));
		}
		
		if (ListUtils.listHasItems(queryBuilder.getQueryOrderings())) {
			sb.append(" ORDER BY ");
			sb.append(prepareOrderingClause(queryBuilder));
		}
		
		sb.append(prepareLimitClause(queryBuilder));
		
		return sb.toString();
	}
	
	public static String prepareWhereClause(QueryBuilder queryBuilder) {
		StringBuilder sb = new StringBuilder();
		
		ListUtils.newListOnNull(queryBuilder.getQueryCriterias()).forEach(queryCriteria -> {
			sb.append(getClauseForCriteria(queryCriteria));
		});
		
		return sb.toString();
	}
	
	public static String getClauseForCriteria(QueryCriteria queryCriteria) {
		StringBuilder sb = new StringBuilder();
		
		if (queryCriteria.getRestriction() != null) {
			sb.append(" ");
			sb.append(queryCriteria.getRestriction().getCriteriaRestriction());
			sb.append(" ");
		}
		
		if (ListUtils.listHasItems(queryCriteria.getLinkedCriterias())) {
			sb.append(" ( ");
		}
		
		sb.append(queryCriteria.getColumn());
		sb.append(" ");
		sb.append(queryCriteria.getCondition().getCriteriaCondition());
		sb.append(" ? ");
		
		ListUtils.newListOnNull(queryCriteria.getLinkedCriterias()).forEach(linkedCriteria -> {
			sb.append(getClauseForCriteria(linkedCriteria));
		});
		
		if (ListUtils.listHasItems(queryCriteria.getLinkedCriterias())) {
			sb.append(" ) ");
		}
		
		return sb.toString();
	}
	
	public static String prepareOrderingClause(QueryBuilder queryBuilder) {
		return ListUtils.buildString(queryBuilder.getQueryOrderings(), (index, ordering) -> {
			return (index > 0 ? ", " : "") + getClauseForOrdering(ordering);
		});
	}
	
	public static String getClauseForOrdering(QueryOrdering queryOrdering) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(queryOrdering.getOrderColumn());
		sb.append(" ");
		sb.append(queryOrdering.getMethod().getOrderMethod());
		
		return sb.toString();
	}
	
	public static String prepareLimitClause(QueryBuilder queryBuilder) {
		StringBuilder sb = new StringBuilder();
		
		sb.append(" LIMIT ");
		sb.append(queryBuilder.getOffset());
		sb.append(", ");
		sb.append(queryBuilder.getLimit());
		
		return sb.toString();
	}
	
	public static List<Object> getQueryBuilderParameters(QueryBuilder queryBuilder) {
		List<Object> parameters = new ArrayList<>();
		
		ListUtils.newListOnNull(queryBuilder.getQueryCriterias()).forEach(criteria -> {
			parameters.addAll(getQueryCriteriaParameters(criteria));
		});
		
		return parameters;
	}
	
	public static List<Object> getQueryCriteriaParameters(QueryCriteria queryCriteria) {
		List<Object> parameters = new ArrayList<>();
		
		parameters.add(queryCriteria.getCriteriaData());
		
		ListUtils.newListOnNull(queryCriteria.getLinkedCriterias()).forEach(linkedCriteria -> {
			parameters.addAll(getQueryCriteriaParameters(linkedCriteria));
		});
		
		return parameters;
	}
	
	public static void main(String[] args) {
		String sql = " SELECT * FROM TABELA ";
		
		QueryCriteria criteria = new QueryCriteria();
		criteria.setColumn("colunaTeste");
		criteria.setCondition(EnumCriteriaCondition.EQUALS);
		criteria.setCriteriaData(null);
		
		QueryCriteria criteria2 = new QueryCriteria();
		criteria2.setColumn("colunaTeste2");
		criteria2.setCondition(EnumCriteriaCondition.LIKE);
		criteria2.setCriteriaData("%TEXTO%");
		criteria2.setRestriction(EnumCriteriaRestriction.AND);
		
		QueryCriteria sub = new QueryCriteria();
		sub.setColumn("colunaTeste2");
		sub.setCondition(EnumCriteriaCondition.EQUALS);
		sub.setCriteriaData(null);
		sub.setRestriction(EnumCriteriaRestriction.OR);
		criteria2.linkQueryCriteria(sub);
		
		QueryBuilder query = new QueryBuilder();
		query.addQueryCriteria(criteria);
		query.addQueryCriteria(criteria2);
		query.setOffset(400L);
		query.setLimit(100L);
		
		System.out.println(SQLQueryUtils.prepareQuery(sql, false, query));
	}
}
