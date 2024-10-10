package com.xunmao.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunapi.xunapicommon.model.entity.InterfaceInfo;
import com.xunapi.xunapicommon.model.entity.User;
import com.xunapi.xunapicommon.model.entity.UserInterfaceInfo;
import com.xunapi.xunapicommon.service.InnerInterfaceInfoService;
import com.xunmao.project.common.ErrorCode;
import com.xunmao.project.exception.BusinessException;
import com.xunmao.project.mapper.InterfaceInfoMapper;
import com.xunmao.project.mapper.UserInterfaceInfoMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerInterfaceInfoServiceImpl implements InnerInterfaceInfoService {

    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;


    @Override
    public InterfaceInfo getInterfaceInfo(String url, String method) {
        if(StringUtils.isAnyBlank(url, method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("url", url);
        queryWrapper.eq("method", method);

        InterfaceInfo interfaceInfo = interfaceInfoMapper.selectOne(queryWrapper);
        return interfaceInfo;
    }

}
