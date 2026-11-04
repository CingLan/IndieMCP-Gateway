package com.indiefund.mcp.infrastructure.adapter.repository;

import com.indiefund.mcp.domain.auth.adapter.repository.IAuthRepository;
import com.indiefund.mcp.domain.auth.model.entity.LicenseCommandEntity;
import com.indiefund.mcp.domain.auth.model.valobj.McpGatewayAuthVO;
import com.indiefund.mcp.domain.auth.model.valobj.enums.AuthStatusEnum;
import com.indiefund.mcp.infrastructure.dao.IMcpGatewayAuthDao;
import com.indiefund.mcp.infrastructure.dao.IMcpGatewayDao;
import com.indiefund.mcp.infrastructure.dao.po.McpGatewayAuthPO;
import com.indiefund.mcp.infrastructure.dao.po.McpGatewayPO;
import com.indiefund.mcp.types.enums.McpErrorCodes;
import com.indiefund.mcp.types.exception.AppException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * 鉴权仓储服务
 *
 * 2026/2/22 10:57
 */
@Slf4j
@Repository
public class AuthRepository implements IAuthRepository {

    @Resource
    private IMcpGatewayAuthDao mcpGatewayAuthDao;

    @Resource
    private IMcpGatewayDao mcpGatewayDao;

    @Override
    public boolean validate(String gatewayId, String apiKey) {
        McpGatewayAuthPO poReq = new McpGatewayAuthPO();
        poReq.setGatewayId(gatewayId);
        poReq.setApiKey(apiKey);
        McpGatewayAuthPO mcpGatewayAuthPO = mcpGatewayAuthDao.queryMcpGatewayAuthPO(poReq);
        if (null == mcpGatewayAuthPO) return false;
        return mcpGatewayAuthPO.getStatus() == AuthStatusEnum.AuthConfig.ENABLE.getCode();
    }

    @Override
    public int queryEffectiveGatewayAuthCount(String gatewayId) {
        return mcpGatewayAuthDao.queryEffectiveGatewayAuthCount(gatewayId);
    }

    @Override
    public McpGatewayAuthVO queryEffectiveGatewayAuthInfo(LicenseCommandEntity commandEntity) {

        McpGatewayAuthPO poReq = new McpGatewayAuthPO();
        poReq.setGatewayId(commandEntity.getGatewayId());
        poReq.setApiKey(commandEntity.getApiKey());

        McpGatewayAuthPO mcpGatewayAuthPO = mcpGatewayAuthDao.queryMcpGatewayAuthPO(poReq);
        if (null == mcpGatewayAuthPO) return null;

        return McpGatewayAuthVO.builder()
                .gatewayId(mcpGatewayAuthPO.getGatewayId())
                .apiKey(mcpGatewayAuthPO.getApiKey())
                .rateLimit(mcpGatewayAuthPO.getRateLimit())
                .expireTime(mcpGatewayAuthPO.getExpireTime())
                .status(AuthStatusEnum.AuthConfig.get(mcpGatewayAuthPO.getStatus()))
                .build();
    }

    @Override
    public void saveGatewayAuth(McpGatewayAuthVO mcpGatewayAuthVO) {
        McpGatewayAuthPO existingAuth = mcpGatewayAuthDao.queryMcpGatewayAuthPO(McpGatewayAuthPO.builder().gatewayId(mcpGatewayAuthVO.getGatewayId()).build());
        
        McpGatewayAuthPO mcpGatewayAuthPO = McpGatewayAuthPO.builder()
                .gatewayId(mcpGatewayAuthVO.getGatewayId())
                .apiKey(mcpGatewayAuthVO.getApiKey())
                .rateLimit(mcpGatewayAuthVO.getRateLimit())
                .expireTime(mcpGatewayAuthVO.getExpireTime())
                .status(mcpGatewayAuthVO.getStatus().getCode())
                .build();
                
        if (existingAuth != null) {
            mcpGatewayAuthDao.updateByGatewayId(mcpGatewayAuthPO);
        } else {
            mcpGatewayAuthDao.insert(mcpGatewayAuthPO);
        }
    }

    @Override
    public AuthStatusEnum.GatewayConfig queryGatewayAuthStatus(String gatewayId) {
        McpGatewayPO mcpGatewayPO = mcpGatewayDao.queryMcpGatewayByGatewayId(gatewayId);
        if (null == mcpGatewayPO) {
            throw new AppException(McpErrorCodes.INVALID_PARAMS, "无效参数 gatewayId 不存在");
        }
        return AuthStatusEnum.GatewayConfig.get(mcpGatewayPO.getAuth());
    }

    @Override
    public void deleteGatewayAuth(String gatewayId) {
        mcpGatewayAuthDao.deleteByGatewayId(gatewayId);
    }

}
