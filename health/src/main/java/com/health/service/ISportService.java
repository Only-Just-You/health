package com.health.service;

import com.health.entity.Sport;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface ISportService {
    List<Sport> getSport(Integer id);
    void addImage(String path, Integer id);
}
