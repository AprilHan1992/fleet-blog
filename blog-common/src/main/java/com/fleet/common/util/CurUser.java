package com.fleet.common.util;

import com.fleet.common.entity.user.User;

public class CurUser {

	private static final ThreadLocal<User> context = new ThreadLocal<>();

	public static void remove() {
		CurUser.context.remove();
	}

	public static void setUser(User user) {
		CurUser.remove();
		context.set(user);
	}

	public static User getUser() {
		return context.get();
	}

}
