package com.demo.democommoncore.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import me.chanjar.weixin.mp.bean.menu.WxMpSelfMenuInfoDTO;

import java.io.Serializable;

/**
 * <pre>
 * Created by Binary Wang on 2016-11-25.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
public class WxMpGetSelfMenuInfoResultDTO implements Serializable {

    private static final long serialVersionUID = -5612495636936835166L;

    @SerializedName("selfmenu_info")
    private WxMpSelfMenuInfoDTO selfMenuInfo;

    @SerializedName("is_menu_open")
    private Integer isMenuOpen;


}
