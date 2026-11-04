package com.indiefund.mcp.infrastructure.dao;

import com.indiefund.mcp.infrastructure.dao.po.McpProtocolMappingPO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IMcpProtocolMappingDao {

    int insert(McpProtocolMappingPO po);

    int deleteById(Long id);

    int deleteByProtocolId(Long protocolId);

    int updateById(McpProtocolMappingPO po);

    McpProtocolMappingPO queryById(Long id);

    List<McpProtocolMappingPO> queryAll();

    List<McpProtocolMappingPO> queryMcpGatewayToolConfigListByProtocolId(Long protocolId);

    List<McpProtocolMappingPO> queryListByProtocolIds(List<Long> protocolIds);

}

