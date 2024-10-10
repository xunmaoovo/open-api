package com.xunmao.project.service.impl.inner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunapi.xunapicommon.model.entity.UserInterfaceInfo;
import com.xunapi.xunapicommon.service.InnerUserInterfaceInfoService;
import com.xunmao.project.common.ErrorCode;
import com.xunmao.project.exception.BusinessException;
import com.xunmao.project.mapper.UserInterfaceInfoMapper;
import com.xunmao.project.service.UserInterfaceInfoService;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

@DubboService
public class InnerUserInterfaceInfoServiceImpl implements InnerUserInterfaceInfoService {

    @Resource
    private UserInterfaceInfoService userInterfaceInfoService;

    @Resource
    private UserInterfaceInfoMapper userInterfaceInfoMapper;

    @Override
    public boolean invokeCount(long interfaceInfoId, long userId) {
        return userInterfaceInfoService.invokeCount(interfaceInfoId, userId);
    }

    @Override
    public int haveInvokeCount(long interfaceInfoId) {
        if(interfaceInfoId < 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", interfaceInfoId);

        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoMapper.selectOne(queryWrapper);
        Integer leftNum = userInterfaceInfo.getLeftNum();

        return leftNum;
    }
}
