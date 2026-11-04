package com.indiefund.mcp.domain.protocol.model.valobj.enums;

import com.indiefund.mcp.types.enums.ResponseCode;
import com.indiefund.mcp.types.exception.AppException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 协议状态枚举
 *
 * 2026/3/13 08:40
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ProtocolStatusEnum {

    ENABLE(1,"启用"),
    DISABLE(0,"禁用")

    ;

    private Integer code;
    private String info;

    public static ProtocolStatusEnum getByCode(Integer code){
        if(null == code){
            return null;
        }
        for (ProtocolStatusEnum anEnum : ProtocolStatusEnum.values()) {
            if(anEnum.getCode().equals(code)){
                return anEnum;
            }
        }

        throw new AppException(ResponseCode.ENUM_NOT_FOUND.getCode(), ResponseCode.ENUM_NOT_FOUND.getInfo());
    }

}
