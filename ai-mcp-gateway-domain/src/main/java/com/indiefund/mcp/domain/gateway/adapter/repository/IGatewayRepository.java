package com.indiefund.mcp.domain.gateway.adapter.repository;

import com.indiefund.mcp.domain.gateway.model.entity.GatewayConfigCommandEntity;
import com.indiefund.mcp.domain.gateway.model.entity.GatewayToolConfigCommandEntity;
import com.indiefund.mcp.domain.gateway.model.valobj.GatewayToolConfigVO;

import java.util.List;

/**
 * 网关仓储服务接口
 *
 * 2026/3/21 07:57
 */
public interface IGatewayRepository {

    void saveGatewayConfig(GatewayConfigCommandEntity commandEntity);

    void updateGatewayAuthStatus(GatewayConfigCommandEntity commandEntity);

    void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity);

    void updateGatewayToolProtocol(GatewayToolConfigCommandEntity commandEntity);

    void deleteGatewayToolConfig(Long toolId);

    List<GatewayToolConfigVO> queryGatewayToolConfigList(String gatewayId);

}

