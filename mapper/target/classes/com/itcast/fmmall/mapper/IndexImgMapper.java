package com.itcast.fmmall.mapper;

import com.itcast.fmmall.generator.GeneratorMapper;
import com.itcast.fmmall.pojo.IndexImg;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneratorMapper<IndexImg> {

    /**
     * 查询status=1且安装seq进行排序
     */
    public List<IndexImg> listIndexImg();
}