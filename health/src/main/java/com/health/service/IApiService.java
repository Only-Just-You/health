package com.health.service;

import com.health.entity.User;

import java.util.List;

public interface IApiService {
    List<User> login(User user);

    void register(User user);

    List<Integer> queryByName(User user);
}
