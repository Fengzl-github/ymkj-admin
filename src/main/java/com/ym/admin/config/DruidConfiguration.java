package com.ym.admin.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

/**
 * @Author Fengzl
 * @Date 2022/7/17 15:52
 * @Desc
 **/
@Configuration
public class DruidConfiguration {


    /**
     * 配置Druid 监控启动页面
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    public ServletRegistrationBean<Servlet> druidStartViewServlet() {
        ServletRegistrationBean<Servlet> registrationBean = new ServletRegistrationBean<>(
                new StatViewServlet(), "/druid/*");
        // 白名单
        registrationBean.addInitParameter("allow", "127.0.0.1");
        // 黑名单
        registrationBean.addInitParameter("deny", "192.168.1.100");
        // 登录查看信息的账密，用于登录Druid监控后台
        registrationBean.addInitParameter("loginUsername", "druid");
        registrationBean.addInitParameter("loginPassword", "druid");
        // 是否能够重置数据
        registrationBean.addInitParameter("resetEnable", "true");
        return registrationBean;
    }


    /**
     * Druid监控过滤器配置规则
     * ConditionalOnMissingBean 防止注册相同的bean
     * @return filterFilterRegistrationBean
     */
    @Bean
    @ConditionalOnMissingBean
    public FilterRegistrationBean<Filter> filterRegistrationBean() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        // 添加过滤规则
        filterFilterRegistrationBean.addUrlPatterns("/*");
        // 添加不需要忽略的格式信息
        filterFilterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterFilterRegistrationBean;
    }
}
