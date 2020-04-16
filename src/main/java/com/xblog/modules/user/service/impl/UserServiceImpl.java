package com.xblog.modules.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xblog.common.exception.BaseException;
import com.xblog.common.result.Result;
import com.xblog.modules.user.entity.User;
import com.xblog.modules.user.mapper.UserMapper;
import com.xblog.modules.user.request.UserLoginRequest;
import com.xblog.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xsy
 * @since 2020-04-13
 */
@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private RedisSessionDAO sessionDAO;

    @Override
    public User queryUserByAccount(String account) {
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(User::getUserName,account);
        wrapper.eq(User::getDeleted,0);
        User user = getBaseMapper().selectOne(wrapper);
        return user;
    }

    @Override
    public Result login(UserLoginRequest request) {
        // 获取Subject实例对象，用户实例
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(request.getUserName(), request.getPassWord());
        User user = null;
        try {
            // 传到 MyShiroRealm 类中的方法进行认证
            currentUser.login(token);
            // 构建缓存用户信息返回给前端
            user = (User) currentUser.getPrincipals().getPrimaryPrincipal();
            log.warn("User{}", user.toString());
        } catch (UnknownAccountException e) {
            log.error("账户不存在异常：", e);
            throw new BaseException("404","账户不存在");
        } catch (IncorrectCredentialsException e) {
            log.error("凭据错误（密码错误）异常：", e);
            throw new BaseException("404","密码错误");
        } catch (AuthenticationException e) {
            throw new BaseException("404","用户验证失败");
        }
        return Result.success(user);
    }

    @Override
    public Result queryLoginedUser() {

        Collection<Session> sessions = sessionDAO.getActiveSessions();
        List<User> onlineUserList = new ArrayList<>();
        for(Session session : sessions){
            if(null != session){
                SimplePrincipalCollection principalCollection = new SimplePrincipalCollection();
                if (session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY) != null) {
                    User u = new User();
                    principalCollection = (SimplePrincipalCollection) session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
                    u = (User) principalCollection.getPrimaryPrincipal();
                    onlineUserList.add(u);
                }
            }
        }
        return Result.success(onlineUserList);
    }
}
