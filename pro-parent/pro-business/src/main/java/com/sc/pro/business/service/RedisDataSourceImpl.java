package com.sc.pro.business.service;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Administrator on 2015/8/19 0019.
 */
public class RedisDataSourceImpl implements RedisDataSource {
        private static final Log log = LogFactory.getLog(RedisDataSourceImpl.class);

        @Autowired
        private ShardedJedisPool shardedJedisPool;

        public ShardedJedis getRedisClient() {
            try {
                ShardedJedis shardJedis = shardedJedisPool.getResource();
                return shardJedis;
            } catch (Exception e) {
                log.error("getRedisClent error", e);
            }
            return null;
        }

        public void returnResource(ShardedJedis shardedJedis) {
            shardedJedisPool.returnResource(shardedJedis);
        }

        public void returnResource(ShardedJedis shardedJedis, boolean broken) {
            if (broken) {
                shardedJedisPool.returnBrokenResource(shardedJedis);
            } else {
                shardedJedisPool.returnResource(shardedJedis);
            }
        }
}
