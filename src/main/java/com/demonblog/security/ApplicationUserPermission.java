package com.demonblog.security;

public enum ApplicationUserPermission {
	POST  ("user:post"),
	COMMENT ("user:comment"),
	SHARE ("user:share");
	
	private String permission;
	
	ApplicationUserPermission(String permission) {
		this.permission = permission;
	}
	
	private String getPermission(){return permission;}
}
