package com.demo.democommoncore.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Daniel Qian
 */
@Data
public class WxMpTemplateDataDTO implements Serializable {

    private static final long serialVersionUID = 6301835292940277870L;

    private String name;

    private String value;

    private String color;

    public WxMpTemplateDataDTO() {
    }

    public WxMpTemplateDataDTO(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public WxMpTemplateDataDTO(String name, String value, String color) {
        this.name = name;
        this.value = value;
        this.color = color;
    }

}
