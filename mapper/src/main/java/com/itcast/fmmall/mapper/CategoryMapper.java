package com.itcast.fmmall.mapper;

import com.itcast.fmmall.generator.GeneratorMapper;
import com.itcast.fmmall.pojo.Category;
import com.itcast.fmmall.pojo.CategoryVO;

import java.util.List;

public interface CategoryMapper extends GeneratorMapper<Category> {

    /**
     * 连接查询实现
     * @return
     */
    public List<CategoryVO> selectAllCategories();

    /**
     * 子查询实现
     */
    public List<CategoryVO> selectAllCategories1(Integer id);

}