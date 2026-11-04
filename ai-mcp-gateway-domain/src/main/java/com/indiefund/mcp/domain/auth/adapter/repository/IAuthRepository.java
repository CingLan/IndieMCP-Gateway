package com.indiefund.mcp.domain.auth.adapter.repository;

import com.indiefund.mcp.domain.auth.model.entity.LicenseCommandEntity;
import com.indiefund.mcp.domain.auth.model.valobj.McpGatewayAuthVO;
import com.indiefund.mcp.domain.auth.model.valobj.enums.AuthStatusEnum;

/**
 * 鉴权仓储服务接口
 *
 * 2026/2/22 10:57
 */
public interface IAuthRepository {

    void saveGatewayAuth(McpGatewayAuthVO mcpGatewayAuthVO);

    boolean validate(String gatewayId, String apiKey);

    int queryEffectiveGatewayAuthCount(String gatewayId);

    McpGatewayAuthVO queryEffectiveGatewayAuthInfo(LicenseCommandEntity commandEntity);

    AuthStatusEnum.GatewayConfig queryGatewayAuthStatus(String gatewayId);

    void deleteGatewayAuth(String gatewayId);

}
