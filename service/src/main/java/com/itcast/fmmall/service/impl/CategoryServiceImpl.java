package com.itcast.fmmall.service.impl;

import com.itcast.ResultVO;
import com.itcast.constant.SystemConstants;
import com.itcast.fmmall.mapper.CategoryMapper;
import com.itcast.fmmall.pojo.CategoryVO;
import com.itcast.fmmall.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/24 15:23
 * @Description 致敬大师，致敬未来的自己
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public ResultVO listCategories() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories();
        return new ResultVO(SystemConstants.SUCCESS_CODE, "success", categoryVOS);
    }
}
