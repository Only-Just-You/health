package com.health.service.impl;

import com.health.entity.User;
import com.health.mapper.UserMapper;
import com.health.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
public class UserServiceImpl implements IUserService {
    @Resource
    public UserMapper userMapper;
    @Override
    public boolean setUser(User user, Integer id) {
        return userMapper.setUser(user, id);
    }

    @Override
    public void addImage(String path, Integer id) {
        userMapper.addImage(path, id);
    }
}
