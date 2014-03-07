package org.easyrec.service.core.impl;

import java.util.List;
import java.util.Set;

import org.easyrec.service.core.UserProfileService;
import org.easyrec.store.dao.UserProfileDAO;

public class UserProfileServiceImpl implements UserProfileService {
	private UserProfileDAO userProfileDao;
	
	public UserProfileServiceImpl(UserProfileDAO userProfileDao) {
		this.userProfileDao = userProfileDao;
	}
	
	@Override
	public Set<Integer> getFilteredItemsForUser(List<Integer> sourceItems,
			Integer userId) {
		return userProfileDao.getFilteredItemsForUser(sourceItems, userId);
	}
}
