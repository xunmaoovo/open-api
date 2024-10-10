package com.xunapi.xunapicommon.service;


import com.xunapi.xunapicommon.model.entity.User;

/**
 * 用户服务
 *
 * @author xunmao
 */
public interface InnerUserService {

    /**
     * 去数据库查 ak、sk 是否已经分配给用户（accessKey
     * @param accessKey
     * @return
     */
    User getInvokeUser(String accessKey);
}
