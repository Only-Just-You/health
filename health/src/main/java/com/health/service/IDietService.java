package com.health.service;

import com.health.entity.Diet;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author oo
 * @since 2020-03-11
 */
public interface IDietService{
    List<Diet> getDiet(Integer id);

}
