package com.health.service;

import com.health.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IUserService {

    boolean setUser(User user, Integer id);
    void addImage(String path, Integer id);
}
