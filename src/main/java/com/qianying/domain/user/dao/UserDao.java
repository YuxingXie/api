package com.qianying.domain.user.dao;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.qianying.common.base.BaseMongoDao;
import com.qianying.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2015/5/22.
 */
@Repository
public class UserDao extends BaseMongoDao<User>  {
    private static Logger logger = LogManager.getLogger();
    //单个插入
    @Resource
    private MongoOperations mongoTemplate;

    public User findByEmailOrPhone(String emailOrPhone) {
        DBObject queryCondition = new BasicDBObject();
        queryCondition = new BasicDBObject();
        BasicDBList values = new BasicDBList();
        values.add(new BasicDBObject("phone", emailOrPhone));
        values.add(new BasicDBObject("email", emailOrPhone));
        queryCondition.put("$or", values);
        Query query=new BasicQuery(queryCondition);


        return mongoTemplate.findOne(query,User.class);
    }

}
