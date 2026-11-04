package com.indiefund.mcp.domain.protocol.service;

import com.indiefund.mcp.domain.protocol.model.entity.AnalysisCommandEntity;
import com.indiefund.mcp.domain.protocol.model.valobj.http.HTTPProtocolVO;

import java.util.List;

/**
 * 协议解析接口
 *
 * 2026/3/3 07:29
 */
public interface IProtocolAnalysis {

    List<HTTPProtocolVO> doAnalysis(AnalysisCommandEntity commandEntity);

}
