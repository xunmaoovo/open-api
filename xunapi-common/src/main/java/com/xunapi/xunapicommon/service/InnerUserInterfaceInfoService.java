package com.xunapi.xunapicommon.service;

import com.xunapi.xunapicommon.model.entity.UserInterfaceInfo;

/**
* @author 熏猫king
* @description 针对表【user_interface_info(用户调用接口关系)】的数据库操作Service
* @createDate 2024-09-30 22:32:42
*/
public interface InnerUserInterfaceInfoService {

    /**
     * 调用接口统计
     * @param interfaceInfoId
     * @param userId
     * @return
     */
    boolean invokeCount(long interfaceInfoId, long userId);

    /**
     * 查询用户剩余调用次数
     * @param interfaceInfoId
     * @return
     */
    int haveInvokeCount(long interfaceInfoId);
}
