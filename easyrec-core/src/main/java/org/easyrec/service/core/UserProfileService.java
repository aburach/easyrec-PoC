package org.easyrec.service.core;

import java.util.List;
import java.util.Set;

public interface UserProfileService {
	Set<Integer> getFilteredItemsForUser(List<Integer> sourceItems,
			Integer userId);
}
