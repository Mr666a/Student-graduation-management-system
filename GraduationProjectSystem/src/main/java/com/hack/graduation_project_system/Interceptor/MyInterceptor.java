//package com.hack.graduation_project_system.Interceptor;
//
//import fr.opensagres.xdocreport.document.json.JSONObject;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//
//public class MyInterceptor implements HandlerInterceptor {
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println(request.getServletPath());
//        if (request.getServletPath().equals("/eid_login") || request.getServletPath().equals("/sid_login")){
//            return true;
//        }else if (request.getSession().getAttribute("stu")!=null){
//            return true;
//        }else if (request.getSession().getAttribute("teacher")!=null){
//            return true;
//        }else if (request.getSession().getAttribute("leader")!=null){
//            return true;
//        }
//        try {
//            response.sendRedirect("/login");
//            return false;
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendError(500);
//            return false;
//        }
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}