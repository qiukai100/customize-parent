package com.customize.common.utils;

import com.google.common.collect.Lists;

import java.util.List;

public class ListUtils<T> {

    private List<T> list;

    public ListUtils(List<T> list) {
        this.list = list;
    }

    public T getOne() {
        return list.get(0);
    }

    public static void main(String[] args) {
        List<User> userList = Lists.newArrayList();
        userList.add(new User("TEST"));
        User user = new ListUtils<>(userList).getOne();
        System.out.println(user.getUserName());
    }

    static class User {
        private String userName;

        public User(String userName) {
            this.userName = userName;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
}

