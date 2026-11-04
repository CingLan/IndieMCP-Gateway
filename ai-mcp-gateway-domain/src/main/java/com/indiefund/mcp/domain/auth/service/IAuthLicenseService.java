package com.indiefund.mcp.domain.auth.service;

import com.indiefund.mcp.domain.auth.model.entity.LicenseCommandEntity;

/**
 * 权限证书服务接口
 *
 * 2026/2/22 10:11
 */
public interface IAuthLicenseService {

    boolean checkLicense(LicenseCommandEntity commandEntity);

}
