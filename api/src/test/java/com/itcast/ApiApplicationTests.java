package com.itcast;

import com.itcast.fmmall.mapper.CategoryMapper;
import com.itcast.fmmall.pojo.CategoryVO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = ApiApplication.class)
@RunWith(SpringRunner.class)
class ApiApplicationTests {

    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    void contextLoads() {
        List<CategoryVO> categoryVOS = categoryMapper.selectAllCategories1(0);
        for (CategoryVO categoryVO : categoryVOS) {
            System.out.println(categoryVO);
            List<CategoryVO> categories = categoryVO.getCategories();
            for (CategoryVO category : categories) {
                System.out.println(category);
                List<CategoryVO> categories1 = category.getCategories();
                for (CategoryVO vo : categories1) {
                    System.out.println(vo);
                }
            }
        }
    }

}
