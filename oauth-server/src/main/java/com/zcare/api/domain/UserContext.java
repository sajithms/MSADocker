package com.zcare.api.domain;

public class UserContext {
	private static ThreadLocal<Object> currentUser = new ThreadLocal<>();
	public static void setCurrentUser(Object user) {
        currentUser.set(user);
    }

    public static Object getCurrentUser() {
        return currentUser.get();
    }

}
