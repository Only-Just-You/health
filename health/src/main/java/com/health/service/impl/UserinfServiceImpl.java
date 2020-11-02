package com.health.service.impl;

import com.health.entity.Userinf;
import com.health.mapper.UserinfMapper;
import com.health.service.IUserinfService;
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
public class UserinfServiceImpl implements IUserinfService {
    @Resource
    public UserinfMapper userinfMapper;
    @Override
    public List<Userinf> getInf(Integer id) {
        return userinfMapper.getInf(id);

    }
}
