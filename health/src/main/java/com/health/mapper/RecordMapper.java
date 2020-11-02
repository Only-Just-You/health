package com.health.mapper;

import com.health.entity.Record;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface RecordMapper {
    void setRecord(@Param("record") Record record);
    void addRecord(@Param("record") Record record, @Param("id") Integer id);
}
