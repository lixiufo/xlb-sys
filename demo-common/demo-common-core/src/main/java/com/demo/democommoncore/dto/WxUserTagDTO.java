package com.demo.democommoncore.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 *  用户标签对象
 *  Created by Binary Wang on 2016/9/2.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
public class WxUserTagDTO implements Serializable {

    private static final long serialVersionUID = -7722428695667031252L;

    /**
     * 标签id，由微信分配.
     */
    private Long id;

    /**
     * 标签名，UTF8编码.
     */
    private String name;

    /**
     * 此标签下粉丝数.
     */
    private Integer count;

}
