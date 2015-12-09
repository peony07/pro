package com.peony.reptile.images.mongodb;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoOptions;
import com.mongodb.util.JSON;

import java.net.UnknownHostException;

public class MongoDBUtil {
	private static Mongo mongo = null;

	private static String DBString = "ImageServer";// 数据库名
	private static String hostName = "localhost";// 主机名
	private static int port = 27017;// 端口号
	private static int poolSize = 100;// 连接池大小

	private MongoDBUtil() {

	}

	// 获取数据库连接
	public static DB getDB() {
		try {
			if (mongo == null) {
				init();
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return mongo.getDB(DBString);
	}

	// 初始化数据库
	private static void init() throws UnknownHostException {
		// 实例化Mongo
		mongo = new Mongo(hostName, port);
		MongoOptions opt = mongo.getMongoOptions();
		// 设置连接池大小
		opt.connectionsPerHost = poolSize;
	}
	
	/**
	 * 将普通Object对象转换成mongodb的DBObject对象
	 * 
	 * @param obj
	 * @return
	 */
	public static DBObject toDBObject(Object obj) {
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		return (DBObject) JSON.parse(json);
	}
}
