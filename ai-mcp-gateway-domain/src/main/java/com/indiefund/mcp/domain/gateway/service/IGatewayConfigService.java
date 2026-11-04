package com.indiefund.mcp.domain.gateway.service;

import com.indiefund.mcp.domain.gateway.model.entity.GatewayConfigCommandEntity;

/**
 * 网关配置接口
 *
 * 2026/3/21 07:56
 */
public interface IGatewayConfigService {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity);

}
