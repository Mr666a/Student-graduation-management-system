//package com.hack.graduation_project_system.Interceptor;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Configuration
//public class InterceptorConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        List<String> excludes = new ArrayList<>();
//        excludes.add("/login");
//        excludes.add("/eid_login");
//        excludes.add("/sid_login");
//        excludes.add("/class/**");
//        excludes.add("/pj/**");
//        excludes.add("/pg/**");
//        excludes.add("/stu/**");
//        excludes.add("/teacher/**");
//        // 注册拦截器
//        InterceptorRegistration ir = registry.addInterceptor(new MyInterceptor());
//        // 添加拦截请求
//        ir.addPathPatterns("/*");
//        // 添加不拦截的请求
//        ir.excludePathPatterns(excludes);
//
//
//        // 以上三句代码可以使用下面的代替
//        // registry.addInterceptor(new MyInterceptor()).addPathPatterns("/*").excludePathPatterns("/login");
//    }
//}