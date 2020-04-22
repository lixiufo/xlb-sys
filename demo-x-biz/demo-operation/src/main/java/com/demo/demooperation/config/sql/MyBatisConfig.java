package com.demo.demooperation.config.sql;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import com.demo.demooperation.utils.sys.CurrentUser;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.time.LocalDateTime;

/**
 * @author WPF
 * @version springcloud
 * @date 2019-06-26.
 */

@EnableTransactionManagement
@Configuration
@MapperScan("com.demo.demooperation.mapper")
public class MyBatisConfig implements MetaObjectHandler {


    /**
     * 乐观锁插件 相应字段需要@Version注解 -> 一般使用update_time
     *
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 分页插件
     * List<User> selectUserList(Pagination page, Integer state);
     * <p>
     * objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        paginationInterceptor.setLimit(-1);
        return paginationInterceptor;
    }

    /**
     * 公共字段自动新增
     *
     * @param metaObject
     *         nn
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        if (getFieldValByName("createBy", metaObject) == null) {
            strictInsertFill(metaObject, "createBy", String.class, CurrentUser.username());
        }
        if (getFieldValByName("updateBy", metaObject) == null) {
            strictInsertFill(metaObject, "updateBy", String.class, CurrentUser.username());
        }
        LocalDateTime createDate = LocalDateTime.now();
        strictInsertFill(metaObject, "createTime", LocalDateTime.class, createDate);
        strictInsertFill(metaObject, "updateTime", LocalDateTime.class, createDate);
    }

    /**
     * 公共字段自动删除
     *
     * @param metaObject
     *         nn
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        LocalDateTime updateDate = LocalDateTime.now();
        strictUpdateFill(metaObject, "updateBy", String.class, CurrentUser.username());
        strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, updateDate);
    }
}
