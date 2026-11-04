package com.indiefund.mcp.cases.admin;

import com.indiefund.mcp.domain.protocol.model.entity.StorageCommandEntity;

/**
 * 协议配置管理
 *
 * 2026/3/24 08:10
 */
public interface IAdminProtocolService {

    void saveGatewayProtocol(StorageCommandEntity commandEntity);

    void deleteGatewayProtocol(Long protocolId);

    void importGatewayProtocol(com.indiefund.mcp.domain.protocol.model.entity.AnalysisCommandEntity commandEntity);

    java.util.List<com.indiefund.mcp.domain.protocol.model.valobj.http.HTTPProtocolVO> analysisProtocol(com.indiefund.mcp.domain.protocol.model.entity.AnalysisCommandEntity commandEntity);

}
