package com.xblog.common.controlleradvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xblog.common.util.RedisUtils;
import org.apache.shiro.session.Session;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.xblog.common.result.Result;
import com.xblog.oauth.OAuthSessionManager;

//@ControllerAdvice
@Deprecated
public class ClearTokenResponseBodyAdvice implements ResponseBodyAdvice {

    //@Autowired
    private RedisUtils redisManager;


    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getGenericParameterType().equals(Result.class);
    }


    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        HttpServletRequest httpRequest = ((ServletServerHttpRequest) request).getServletRequest();
        String token = httpRequest.getHeader(OAuthSessionManager.OAUTH_TOKEN);

        HttpServletResponse httpResponse = ((ServletServerHttpResponse) response).getServletResponse();

        if (null != token) {
            Session s = (Session) redisManager.get(token);

            if (null == s || null == s.getId()) {
                httpResponse.setHeader("SESSION_TIME_OUT", "timeout");
            }
        }


        return body;
    }


    public RedisUtils getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisUtils redisManager) {
        this.redisManager = redisManager;
    }


}
