package com.indiefund.mcp.domain.gateway.service.tool;

import com.indiefund.mcp.domain.gateway.adapter.repository.IGatewayRepository;
import com.indiefund.mcp.domain.gateway.model.entity.GatewayToolConfigCommandEntity;
import com.indiefund.mcp.domain.gateway.model.valobj.GatewayToolConfigVO;
import com.indiefund.mcp.domain.gateway.service.IGatewayToolConfigService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 网关工具配置服务实现
 *
 * 2026/3/21 09:43
 */
@Slf4j
@Service
public class GatewayToolConfigService implements IGatewayToolConfigService {

    @Resource
    private IGatewayRepository repository;

    @Override
    public void saveGatewayToolConfig(GatewayToolConfigCommandEntity commandEntity) {
        repository.saveGatewayToolConfig(commandEntity);
    }

    @Override
    public void updateGatewayToolProtocol(GatewayToolConfigCommandEntity commandEntity) {
        repository.updateGatewayToolProtocol(commandEntity);
    }

    @Override
    public void deleteGatewayToolConfig(Long toolId) {
        repository.deleteGatewayToolConfig(toolId);
    }

    @Override
    public List<GatewayToolConfigVO> queryGatewayToolConfigList(String gatewayId) {
        return repository.queryGatewayToolConfigList(gatewayId);
    }

}
