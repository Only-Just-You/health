package com.health.service.impl;

import com.health.entity.Sport;
import com.health.mapper.SportMapper;
import com.health.service.ISportService;
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
public class SportServiceImpl implements ISportService {
    @Resource
    private SportMapper sportMapper;
    @Override
    public List<Sport> getSport(Integer id) {
        return sportMapper.getSport(id);
    }

    @Override
    public void addImage(String path, Integer id) {
        sportMapper.addImage(path, id);
    }
}
