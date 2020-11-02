package com.health.service;

import com.health.entity.Record;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IRecordService{
    void setRecord(Record record);
    void addRecord(Record record, Integer id);
}
