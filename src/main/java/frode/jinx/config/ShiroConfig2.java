package frode.jinx.config;

import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

/**
 * @Author: frode
 * @Date: 2018/9/17 11:52
 * @Description:
 */
//@Configuration
public class ShiroConfig2 {
    private static final Logger logger = LoggerFactory.getLogger(ShiroConfig2.class);

    //取redis连接
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.isRedisCache}")
    private int isRedisCache;

    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        redisManager.setExpire(1800);//过期时间
        logger.info("配置redis连接设置###host:"+host+"port:"+port);
        return redisManager;
    }


    @Bean
    public RedisCacheManager cacheManager(){
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

 /*   @Bean
    public SessionManager sessionManager(){
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        Collection<SessionListener> listeners = new ArrayList<SessionListener>();
        listeners.add(new SessionListener() {
        })
    }*/

}
