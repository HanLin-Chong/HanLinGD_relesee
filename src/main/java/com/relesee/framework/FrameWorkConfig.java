package com.relesee.framework;

/**
 * 接口定义了框架的所有配置文件中的属性
 */

public interface FrameWorkConfig {
    /**
     * 框架默认的配置文件
     */
    String DEFAULT_CONFIG_FILE_NAME = "smart.properties";

    /**
     * 数据库配置
     */
    String DB_DRIVER = "database.driver";
    String DB_URL = "database.url";
    String DB_ROLE = "database.username";
    String DB_PASSWORD = "database.password";
}
