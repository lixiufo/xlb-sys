package com.demo.demooperation.vo;

import com.demo.democommoncore.vo.BaseVO;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author WPF
 * @version xlb-sys
 * @date 2020/2/10.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class SellerQrVO extends BaseVO {

    /**
     * id
     */
    private String id;

    /**
     * 二维码路径
     */
    private String path;

    /**
     * 头像路径
     */
    private String imgPath;

    /**
     * 手机号码
     */
    private String phone;
}
