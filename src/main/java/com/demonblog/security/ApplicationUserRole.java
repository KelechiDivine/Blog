package com.demonblog.security;

import com.google.common.collect.Sets;
import static com.demonblog.security.ApplicationUserPermission.*;

import java.util.Set;

public enum ApplicationUserRole {
	USER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(COMMENT, SHARE, POST));
	
	private final Set<ApplicationUserPermission> userPermissions;
	
	ApplicationUserRole(Set<ApplicationUserPermission> userPermissions) {
		this.userPermissions = userPermissions;
	}
}
