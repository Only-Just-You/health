package com.health.service.impl;

import com.health.entity.Userweight;
import com.health.mapper.UserweightMapper;
import com.health.service.IUserweightService;
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
public class UserweightServiceImpl implements IUserweightService {
    @Resource
    private UserweightMapper userweightMapper;
    @Override
    public List<Userweight> getWeight(Integer id) {
        return userweightMapper.getWeight(id);
    }
}
