package com.demo.democommoncore.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 关注者列表
 */
@Data
public class WxMpUserListDTO implements Serializable {

    private static final long serialVersionUID = 1389073042674901032L;

    protected long total = -1;

    protected int count = -1;

    protected List<String> openids = new ArrayList<>();

    protected String nextOpenid;

}
