package com.indiefund.mcp.domain.gateway.service.gateway;

import com.indiefund.mcp.domain.gateway.adapter.repository.IGatewayRepository;
import com.indiefund.mcp.domain.gateway.model.entity.GatewayConfigCommandEntity;
import com.indiefund.mcp.domain.gateway.service.IGatewayConfigService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 网关配置服务
 *
 * 2026/3/21 08:01
 */
@Slf4j
@Service
public class GatewayConfigService implements IGatewayConfigService {

    @Resource
    private IGatewayRepository repository;

    @Override
    public void saveGatewayConfig(GatewayConfigCommandEntity commandEntity) {
        repository.saveGatewayConfig(commandEntity);
    }

    @Override
    public void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity) {
        repository.updateGatewayAuthStatus(commandEntity);
    }
}
