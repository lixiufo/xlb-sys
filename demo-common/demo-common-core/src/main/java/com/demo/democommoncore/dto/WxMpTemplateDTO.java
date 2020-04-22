package com.demo.democommoncore.dto;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * 模板列表信息
 * Created by Binary Wang on 2016-10-17.
 * </pre>
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Data
public class WxMpTemplateDTO implements Serializable {

    private static final long serialVersionUID = -7366474522571199372L;

    /**
     * template_id.
     * 模板ID
     */
    @SerializedName("template_id")
    private String templateId;

    /**
     * title.
     * 模板标题
     */
    @SerializedName("title")
    private String title;

    /**
     * primary_industry.
     * 模板所属行业的一级行业
     */
    @SerializedName("primary_industry")
    private String primaryIndustry;

    /**
     * deputy_industry.
     * 模板所属行业的二级行业
     */
    @SerializedName("deputy_industry")
    private String deputyIndustry;

    /**
     * content.
     * 模板内容
     */
    @SerializedName("content")
    private String content;

    /**
     * example.
     * 模板示例
     */
    @SerializedName("example")
    private String example;

}
