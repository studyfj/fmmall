package com.itcast;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/12 17:44
 * @Description 致敬大师，致敬未来的自己
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "响应的vo对象", description = "封装了接口返回给前端的数据")
public class ResultVO {

    @ApiModelProperty(value = "状态状态码")
    private int code;
    @ApiModelProperty("成功或失败标志")
    private String msg;
    @ApiModelProperty("响应数据")
    private Object data;
}
