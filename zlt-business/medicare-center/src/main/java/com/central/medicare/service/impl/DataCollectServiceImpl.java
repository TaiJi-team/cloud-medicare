package com.central.medicare.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.central.medicare.common.Result;
import com.central.medicare.common.ResultGenerator;
import com.central.medicare.model.DataCollect;
import com.central.medicare.common.PageResult;
import com.central.medicare.service.DataCollectService;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


/**
 * @author swj
 */
@Service
public class DataCollectServiceImpl implements DataCollectService {

    @Resource
    MongoTemplate mongoTemplate;

    @Override
    public Result insert(final String info) {
        mongoTemplate.insert(info, "DataCollect");
        return ResultGenerator.genSuccessResult();
    }

    @Override
    public PageResult<DataCollect> queryData(final String info) {
        final PageResult<DataCollect> result = new PageResult<>();
        final Criteria criteria = new Criteria();
        final Query query = new Query(criteria);
        final JSONObject jsonObject = JSON.parseObject(info);
        final String pageNo = StringUtils.defaultIfEmpty(jsonObject.getString("pageNo"), "1");
        final String pageSize = StringUtils.defaultIfEmpty(jsonObject.getString("pageSize"), "10");
        addCriterias(criteria, jsonObject);
        final long totalCount = mongoTemplate.count(query, DataCollect.class);
        query.skip(((jsonObject.getInteger("pageNo")) - 1) * jsonObject.getInteger("pageSize"));
        query.limit(jsonObject.getInteger("pageSize"));
        final List<DataCollect> list = mongoTemplate.find(query, DataCollect.class);
        result.setResult(list);
        result.setPageNo(Integer.parseInt(pageNo));
        result.setPageSize(Integer.parseInt(pageSize));
        result.setTotalCount(totalCount);
        return result;
    }

    private void addCriterias(final Criteria criteria, final JSONObject jsonObject) {
        addCriteria(criteria, jsonObject, "ybbm");
        addCriteria(criteria, jsonObject, "babm");
        addCriteria(criteria, jsonObject, "yljgmc");
        addCriteria(criteria, jsonObject, "yljgdm");
        addCriteria(criteria, jsonObject, "ybjsdj");
        addCriteria(criteria, jsonObject, "sbsj");
        addCriteria(criteria, jsonObject, "tbbm");
        addCriteria(criteria, jsonObject, "tbr");
    }

    private void addCriteria(Criteria criteria, JSONObject jsonObject, String field) {
        if(StringUtils.isNotEmpty(jsonObject.getString(field))){
            criteria.and(field).is(jsonObject.get(field));
        }
    }
}