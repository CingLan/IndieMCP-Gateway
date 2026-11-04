package com.indiefund.mcp.domain.admin.service;

import com.indiefund.mcp.domain.admin.model.entity.GatewayConfigEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayConfigPageEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayConfigQueryEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayProtocolConfigEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayProtocolPageEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayProtocolQueryEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayToolConfigEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayToolPageEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayToolQueryEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayAuthConfigEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayAuthPageEntity;
import com.indiefund.mcp.domain.admin.model.entity.GatewayAuthQueryEntity;

import java.util.List;

/**
 * 2026/3/26
 */
public interface IAdminService {

    List<GatewayConfigEntity> queryGatewayConfigList();

    GatewayConfigPageEntity queryGatewayConfigPage(GatewayConfigQueryEntity queryEntity);

    List<GatewayToolConfigEntity> queryGatewayToolList();

    GatewayToolPageEntity queryGatewayToolPage(GatewayToolQueryEntity queryEntity);

    List<GatewayToolConfigEntity> queryGatewayToolListByGatewayId(String gatewayId);

    List<GatewayProtocolConfigEntity> queryGatewayProtocolList();

    GatewayProtocolPageEntity queryGatewayProtocolPage(GatewayProtocolQueryEntity queryEntity);

    List<GatewayProtocolConfigEntity> queryGatewayProtocolListByGatewayId(String gatewayId);

    List<GatewayAuthConfigEntity> queryGatewayAuthList();

    GatewayAuthPageEntity queryGatewayAuthPage(GatewayAuthQueryEntity queryEntity);

    /**
     * 根据网关ID查询该网关下的认证配置列表
     */
    List<GatewayAuthConfigEntity> queryGatewayAuthListByGatewayId(String gatewayId);

}
