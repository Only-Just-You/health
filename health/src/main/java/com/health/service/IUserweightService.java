package com.health.service;

import com.health.entity.Userweight;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IUserweightService{
    List<Userweight> getWeight(Integer id);
}
