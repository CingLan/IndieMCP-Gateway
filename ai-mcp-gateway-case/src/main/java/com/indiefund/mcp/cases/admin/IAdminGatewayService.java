package com.indiefund.mcp.cases.admin;

import com.indiefund.mcp.domain.gateway.model.entity.GatewayConfigCommandEntity;
import com.indiefund.mcp.domain.gateway.model.entity.GatewayToolConfigCommandEntity;

/**
 * 网关配置管理
 *
 * 2026/3/24 08:09
 */
public interface IAdminGatewayService {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity);

    void deleteGatewayToolConfig(Long toolId);

}
