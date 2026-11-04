package com.indiefund.mcp.cases.admin.auth;

import com.indiefund.mcp.cases.admin.IAdminAuthService;
import com.indiefund.mcp.domain.auth.model.entity.RegisterCommandEntity;
import com.indiefund.mcp.domain.auth.service.IAuthRegisterService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 运营；认证配置管理
 *
 * 2026/3/24 08:11
 */
@Slf4j
@Service
public class AdminAuthService implements IAdminAuthService {

    @Resource
    private IAuthRegisterService authRegisterService;

    @Override
    public void saveGatewayAuth(RegisterCommandEntity commandEntity) {
        authRegisterService.register(commandEntity);
    }

    @Override
    public void deleteGatewayAuth(String gatewayId) {
        authRegisterService.deleteGatewayAuth(gatewayId);
    }

}
