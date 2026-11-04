package com.indiefund.mcp.infrastructure.dao;

import com.indiefund.mcp.infrastructure.dao.po.McpGatewayToolPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMcpGatewayToolDao {

    int insert(McpGatewayToolPO po);

    int updateProtocolByGatewayId(McpGatewayToolPO po);

    List<McpGatewayToolPO> queryEffectiveTools(String gatewayId);

    List<McpGatewayToolPO> queryListByGatewayId(String gatewayId);

    Long queryToolProtocolIdByToolName(McpGatewayToolPO mcpGatewayToolPOReq);

    List<McpGatewayToolPO> queryToolList(McpGatewayToolPO query);

    Long queryToolListCount(McpGatewayToolPO query);

    List<McpGatewayToolPO> queryAll();

    int deleteByToolId(Long toolId);

}
