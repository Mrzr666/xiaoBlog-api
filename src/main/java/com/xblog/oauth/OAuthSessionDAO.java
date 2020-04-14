package com.xblog.oauth;

import java.io.Serializable;

import com.xblog.common.util.RedisUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;


/**
 * 将session保存到redis
 *
 * @author shimh
 * <p>
 * 2018年1月23日
 */
public class OAuthSessionDAO extends CachingSessionDAO implements InitializingBean {

    private static Logger logger = LoggerFactory.getLogger(OAuthSessionDAO.class);

    private RedisUtils redisManager;


    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        logger.info(sessionId.toString());

        redisManager.set(sessionId.toString(), session, RedisUtils.DEFAULT_EXPIRE);
        return sessionId;
    }


    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            return; //如果会话过期/停止 没必要再更新了
        }
        logger.info(session.getId().toString());
        redisManager.set(session.getId().toString(), session, RedisUtils.DEFAULT_EXPIRE);
    }

    @Override
    protected void doDelete(Session session) {
        redisManager.del(session.getId().toString());
    }


    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.info(sessionId.toString());
        return (Session) redisManager.get(sessionId.toString());
    }


    public RedisUtils getRedisManager() {
        return redisManager;
    }

    public void setRedisManager(RedisUtils redisManager) {
        this.redisManager = redisManager;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (null == this.redisManager) {
            logger.error("StringRedisTemplate should be not null.");
        }

    }


}
