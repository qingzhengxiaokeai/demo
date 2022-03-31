package com.scut.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MethodInfo {
    /**
     * 方法的md5
     */
    public String md5;
    /**
     * 方法名
     */
    public String methodName;
    /**
     * 方法参数
     */
    public String parameters;
}
