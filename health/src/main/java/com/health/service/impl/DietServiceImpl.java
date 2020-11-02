package com.health.service.impl;

import com.health.entity.Diet;
import com.health.mapper.DietMapper;
import com.health.service.IDietService;
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
public class DietServiceImpl implements IDietService {
    @Resource
    public DietMapper dietMapper;
    @Override
    public List<Diet> getDiet(Integer id) {
        return dietMapper.getDiet(id);
    }
}
