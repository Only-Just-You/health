package com.health.service.impl;

import com.health.entity.User;
import com.health.mapper.ApiMapper;
import com.health.service.IApiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ApiServiceimpl implements IApiService {
    @Resource
    private ApiMapper apiMapper;
    @Override
    public List<User> login(User user) {
        return apiMapper.getUser(user);
    }

    @Override
    public void register(User user) {
        apiMapper.setUser(user);
    }

    @Override
    public List<Integer> queryByName(User user) {
        return apiMapper.getUserName(user);
    }
}
