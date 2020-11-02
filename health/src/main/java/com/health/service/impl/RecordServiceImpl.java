package com.health.service.impl;

import com.health.entity.Record;
import com.health.mapper.RecordMapper;
import com.health.mapper.SportMapper;
import com.health.service.IRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
@Service
public class RecordServiceImpl implements IRecordService {
    @Resource
    private RecordMapper recordMapper;
    @Override
    public void setRecord(Record record) {
        recordMapper.setRecord(record);
    }

    @Override
    public void addRecord(Record record, Integer id) {
        recordMapper.addRecord(record, id);
    }
}
