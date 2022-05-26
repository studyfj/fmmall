package com.itcast.fmmall.controller;

import com.itcast.ResultVO;
import com.itcast.fmmall.service.CategoryService;
import com.itcast.fmmall.service.IndexImgService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/23 17:09
 * @Description 致敬大师，致敬未来的自己
 */
@RestController
@RequestMapping("/index")
@CrossOrigin
@Api(tags = "轮播图获取的接口", value = "首页所需要的接口")
public class IndexController {

    @Autowired
    private IndexImgService indexImgService;

    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取轮播图信息接口")
    @GetMapping("/indeximg")
    public ResultVO listIndexImage() {
        return indexImgService.listIndexImage();
    }

    @GetMapping("/category-list")
    @ApiOperation("商品分类查询接口")
    public ResultVO categoryList() {
        return categoryService.listCategories();
    }
}
