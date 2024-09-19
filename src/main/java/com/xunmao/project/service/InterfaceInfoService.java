package com.xunmao.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xunmao.project.model.entity.InterfaceInfo;

/**
* @author 熏猫king
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-09-19 10:13:54
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {
    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);
}
