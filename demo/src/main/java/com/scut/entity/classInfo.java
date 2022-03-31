//保存差异类信息的实体类
package com.scut.entity;

import lombok.Data;
import lombok.ToString;
import org.eclipse.jdt.internal.core.util.MethodInfo;

import java.util.List;

@Data
@ToString
public class classInfo {
    private String classFile;
    private String className;
    private String packages;
    private List<MethodInfo> methodInfos;
    private List<Integer> addLines;
    private List<Integer> delLines;
    private String type;
}
