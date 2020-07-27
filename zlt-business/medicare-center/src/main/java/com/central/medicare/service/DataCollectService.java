package com.central.medicare.service;

import com.central.medicare.common.PageResult;
import com.central.medicare.common.Result;
import com.central.medicare.model.DataCollect;

/**
 * @author swj
 */
public interface DataCollectService {
    /**
     * 插入mongodb
     */
    Result insert(String info);

    /**
     * 查询分页数据
     * @param info
     * @return
     */
    PageResult<DataCollect> queryData(String info);


}
