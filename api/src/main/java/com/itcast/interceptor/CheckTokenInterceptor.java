package com.itcast.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itcast.ResultVO;
import com.itcast.constant.SystemConstants;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author fengjun
 * @version 1.0
 * @Email fengjun3@asiainfo.com
 * @date 2022/5/21 14:39
 * @Description 致敬大师，致敬未来的自己
 */
@Component
public class CheckTokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getMethod();
        // 自定义请求头，处理浏览器的预检请求
        if (method.equalsIgnoreCase("options")) {
            return true;
        }
        String token = request.getHeader("token");
        if (token == null) {
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            PrintWriter writer = response.getWriter();
            String str = new ObjectMapper().writeValueAsString(new ResultVO(SystemConstants.ERROR_CODE, "请先登录", null));
            writer.print(str);
        }else {
            try {
                JwtParser parser = Jwts.parser();
                // token正确 正确执行 否则抛出异常
                parser.setSigningKey("fengjun").parseClaimsJws(token);
                return true;
            }catch(ExpiredJwtException e) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                String str = new ObjectMapper().writeValueAsString(new ResultVO(SystemConstants.ERROR_CODE, "登录过期,请重新登录!", null));
                writer.print(str);
            }catch (UnsupportedJwtException e) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                String str = new ObjectMapper().writeValueAsString(new ResultVO(SystemConstants.ERROR_CODE, "token无效!", null));
                writer.print(str);
            }catch (Exception e) {
                response.setContentType("application/json");
                response.setCharacterEncoding("utf-8");
                PrintWriter writer = response.getWriter();
                String str = new ObjectMapper().writeValueAsString(new ResultVO(SystemConstants.ERROR_CODE, "请先登录!", null));
                writer.print(str);
            }
        }
        return false;
    }
}
