package org.easyrec.store.dao;

import java.util.List;
import java.util.Set;

public interface UserProfileDAO {
	Set<Integer> getFilteredItemsForUser(List<Integer> sourceItems, Integer userId);
}
