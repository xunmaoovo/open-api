package com.xunapi.xunapicommon.service;


import com.xunapi.xunapicommon.model.entity.InterfaceInfo;

/**
* @author 熏猫king
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-09-19 10:13:54
*/
public interface InnerInterfaceInfoService {

    /**
     * 从数据库中查询模拟接口是否存在（请求路径、请求方法
     * @param path
     * @param method
     * @return
     */
    InterfaceInfo getInterfaceInfo(String path, String method);
}
