package com.itcast.fmmall.generator;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/15 16:43
 * @Description 致敬大师，致敬未来的自己
 */
public interface GeneratorMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
