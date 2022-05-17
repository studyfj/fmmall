package com.itcast.fmmall.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.itcast.ResultVO;
import com.itcast.fmmall.mapper.UsersMapper;
import com.itcast.fmmall.pojo.Users;
import com.itcast.fmmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

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
                    return new ResultVO(10000, "注册成功!", users);
                }else {
                    return new ResultVO(100001, "注册失败!", null);
                }
            }else {
                return new ResultVO(10001, "用户名已被注册!", null);
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
                return new ResultVO(10000, "登录成功!", user.get(0));
            }else {
                return new ResultVO(10001, "登录失败,密码错误!", null);
            }
        }
    }
}
