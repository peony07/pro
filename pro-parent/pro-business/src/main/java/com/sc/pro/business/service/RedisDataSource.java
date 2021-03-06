package com.sc.pro.business.service;


import redis.clients.jedis.ShardedJedis;

/**
 * Created by Administrator on 2015/8/19 0019.
 */
public interface RedisDataSource {
    /**
     *  取得redis的客户端，可以执行命令了。
     * @return
     */
    public abstract ShardedJedis getRedisClient();

    /**
     * 将资源返还给pool
     * @param shardedJedis
     */
    public void returnResource(ShardedJedis shardedJedis);

    /**
     *  出现异常后，将资源返还给pool （其实不需要第二个方法）
     * @param shardedJedis
     * @param broken
     */
    public void returnResource(ShardedJedis shardedJedis,boolean broken);
}
