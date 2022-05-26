package com.itcast.fmmall.service.impl;

import cn.hutool.core.codec.Base64Encoder;
import cn.hutool.crypto.digest.DigestUtil;
import com.itcast.ResultVO;
import com.itcast.constant.SystemConstants;
import com.itcast.fmmall.mapper.UsersMapper;
import com.itcast.fmmall.pojo.Users;
import com.itcast.fmmall.service.UserService;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/14 17:33
 * @Description 致敬大师，致敬未来的自己
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper userMapper;

    @Override
    @Transactional
    public ResultVO userRegister(String username, String password) {
        synchronized (this) {
            // 根据用户名查询是否被注册
            Example example = new Example(Users.class);
            example.createCriteria().andEqualTo("username", username);
            List<Users> user = userMapper.selectByExample(example);
            // 没有注册直接保存即可
            if (user.size() == 0){
                String encryptionPassword = DigestUtil.md5Hex(password);
                Users users = new Users();
                users.setUsername(username);
                users.setPassword(encryptionPassword);
                users.setUserRegtime(new Date());
                users.setUserModtime(new Date());
                users.setUserImg("img/default.png");
                int count = userMapper.insertUseGeneratedKeys(users);
                if (count > 0) {
                    return new ResultVO(SystemConstants.SUCCESS_CODE, "注册成功!", users);
                }else {
                    return new ResultVO(SystemConstants.ERROR_CODE, "注册失败!", null);
                }
            }else {
                return new ResultVO(SystemConstants.ERROR_CODE, "用户名已被注册!", null);
            }
        }
    }

    @Override
    public ResultVO checkLogin(String username, String password) {
        Example example = new Example(Users.class);
        example.createCriteria().andEqualTo("username", username);
        List<Users> user = userMapper.selectByExample(example);
        if (user.isEmpty()) {
            return new ResultVO(10001, "登录失败，用户名不存在!", null);
        }else {
            String encryptionPwd = DigestUtil.md5Hex(password);
            if (encryptionPwd.equals(user.get(0).getPassword())) {
                // 生成token令牌
                //String token = Base64Encoder.encode(username + 123456);
                JwtBuilder builder = Jwts.builder();
                // 主题 token中携带的数据 生成时间 map用户角色权限信息
                Map<String, Object> map = new HashMap<>();
                String token = builder.setSubject(username).setIssuedAt(new Date()).
                        setId(user.get(0).getUserId() + "")
                        .setClaims(map).setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                        .signWith(SignatureAlgorithm.HS256, "fengjun")
                        .compact();// 加密方式的密码

                return new ResultVO(SystemConstants.SUCCESS_CODE, token, user.get(0));
            }else {
                return new ResultVO(SystemConstants.ERROR_CODE, "登录失败,密码错误!", null);
            }
        }
    }
}
