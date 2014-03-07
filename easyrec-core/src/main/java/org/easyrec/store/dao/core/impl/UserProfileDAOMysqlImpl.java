package org.easyrec.store.dao.core.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.easyrec.store.dao.UserProfileDAO;
import org.easyrec.utils.spring.store.dao.DaoUtils;
import org.easyrec.utils.spring.store.dao.annotation.DAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

@DAO
public class UserProfileDAOMysqlImpl extends JdbcDaoSupport implements UserProfileDAO {
	private static final String format = "select id from recipe where id in (%s) "
			+ "and cuisine not in (select dislike from user_dislikes where userId = %d) and "
			+ "id not in (select id from ingredients where ingredient in (select allergy from user_allergies where userId = %d));";

	public UserProfileDAOMysqlImpl(DataSource dataSource) {
		setDataSource(dataSource);

		// output connection information
		if (logger.isInfoEnabled()) {
			try {
				logger.info(DaoUtils.getDatabaseURLAndUserName(dataSource));
			} catch (Exception e) {
				logger.error(e);
			}
		}
	}

	@Override
	public Set<Integer> getFilteredItemsForUser(List<Integer> sourceItems, Integer userId) {
		String list = toIdList(sourceItems);
		String preparedQuery = String.format(format, list, userId, userId);
		
		List<Integer> result = getJdbcTemplate().queryForList(preparedQuery, Integer.class);
		
		return new HashSet<Integer>(result);
	}

	private String toIdList(List<Integer> sourceItems) {
		StringBuilder res = new StringBuilder();
		
		for (Integer integer : sourceItems) {
			if (res.length() > 0) {
				res.append(',');
			}
			res.append(integer);
		}

		return res.toString();
	}
}
