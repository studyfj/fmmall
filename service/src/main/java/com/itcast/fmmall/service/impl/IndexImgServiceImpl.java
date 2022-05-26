package com.itcast.fmmall.service.impl;

import com.itcast.ResultVO;
import com.itcast.constant.SystemConstants;
import com.itcast.fmmall.mapper.IndexImgMapper;
import com.itcast.fmmall.pojo.IndexImg;
import com.itcast.fmmall.service.IndexImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/23 17:06
 * @Description 致敬大师，致敬未来的自己
 */
@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVO listIndexImage() {
        List<IndexImg> indexImg = indexImgMapper.listIndexImg();
        if (indexImg.isEmpty()) {
            return new ResultVO(SystemConstants.ERROR_CODE, "error", null);
        }else {
            return new ResultVO(SystemConstants.SUCCESS_CODE, "success", indexImg);
        }
    }
}
