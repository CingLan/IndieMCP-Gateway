package com.indiefund.mcp.domain.auth.service.register;

import com.indiefund.mcp.domain.auth.adapter.repository.IAuthRepository;
import com.indiefund.mcp.domain.auth.model.entity.RegisterCommandEntity;
import com.indiefund.mcp.domain.auth.model.valobj.McpGatewayAuthVO;
import com.indiefund.mcp.domain.auth.model.valobj.enums.AuthStatusEnum;
import com.indiefund.mcp.domain.auth.service.IAuthRegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * 认证服务注册
 *
 * 2026/3/13 08:35
 */
@Slf4j
@Service
public class AuthRegisterService implements IAuthRegisterService {

    @Resource
    private IAuthRepository repository;

    @Override
    public void register(RegisterCommandEntity commandEntity) {
        // 1. 生成 API Key | gw 网关缩写，方便区分
        String apiKey = "gw-" + RandomStringUtils.randomAlphanumeric(48);

        // 2. 构建聚合对象
        McpGatewayAuthVO mcpGatewayAuthVO = McpGatewayAuthVO.builder()
                .gatewayId(commandEntity.getGatewayId())
                .apiKey(apiKey)
                .rateLimit(commandEntity.getRateLimit())
                .expireTime(commandEntity.getExpireTime())
                .status(AuthStatusEnum.AuthConfig.ENABLE)
                .build();

        // 3. 保存数据
        repository.saveGatewayAuth(mcpGatewayAuthVO);
    }

    @Override
    public void deleteGatewayAuth(String gatewayId) {
        repository.deleteGatewayAuth(gatewayId);
    }

}
