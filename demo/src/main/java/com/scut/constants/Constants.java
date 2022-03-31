package com.scut.constants;




import java.nio.charset.Charset;

/**
 * 系统级常量类
 */
public class Constants {

    public static final String APP_NAME = "spring";

    /**
     * 系统编码
     */
    public static final Charset CHARSET = Charset.defaultCharset();

    /**
     * 标识：是/否、启用/禁用等
     */
    public interface Flag {

        Integer YES = 1;

        Integer NO = 0;
    }

    /**
     * 操作类型
     */
    public interface Operation {
        /**
         * 添加
         */
        String ADD = "add";
        /**
         * 更新
         */
        String UPDATE = "update";
        /**
         * 删除
         */
        String DELETE = "delete";
    }

    /**
     * 性别
     */
    public interface Sex {
        /**
         * 男
         */
        Integer MALE = 1;
        /**
         * 女
         */
        Integer FEMALE = 0;
    }

}