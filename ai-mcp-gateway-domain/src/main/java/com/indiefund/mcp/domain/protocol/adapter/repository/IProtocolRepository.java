package com.indiefund.mcp.domain.protocol.adapter.repository;

import com.indiefund.mcp.domain.protocol.model.valobj.http.HTTPProtocolVO;

import java.util.List;

/**
 * 协议仓储服务接口
 *
 * 2026/3/13 08:21
 */
public interface IProtocolRepository {

    List<Long> saveHttpProtocolAndMapping(List<HTTPProtocolVO> httpProtocolVOS);

    void deleteGatewayProtocol(Long protocolId);

}
