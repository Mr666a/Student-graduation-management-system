package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.Utils.FileOperation;
import com.hack.graduation_project_system.domain.Project;
import com.hack.graduation_project_system.domain.Student;
import com.hack.graduation_project_system.pojo.ProgressInfo;
import com.hack.graduation_project_system.pojo.ProjectInfo;
import com.hack.graduation_project_system.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 进度管理controller实现
 */
@Controller
@RequestMapping("/pg")
public class ProgressController {
    private ProgressInfo progressInfo;
    private ProjectService projectService;

    @Autowired
    public void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }
    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @ResponseBody
    @RequestMapping("/getProgress/{percentage}")
    public Collection<ProgressInfo> getProgressToStu(HttpServletRequest request, @PathVariable("percentage") Integer percentage){
        HttpSession httpSession = request.getSession();
        Map<String, ProgressInfo> pgInfos = new HashMap<>();
        switch (percentage){
            case 50:{
                progressInfo.setPercentage(50);
                progressInfo.setProgressMsg("提交课题计划文档");
                Student student = (Student) httpSession.getAttribute("stu");
                Project project = projectService.getProjectById(student.getProjectid());
                FileOperation.writeFile(project.getProjectname(), progressInfo);
                //返回
                pgInfos.put("pgInfo", progressInfo);
            }break;
            case 75:{
                progressInfo.setPercentage(75);
                progressInfo.setProgressMsg("提交课题成品和测试文档");
                Student student = (Student) httpSession.getAttribute("stu");
                Project project = projectService.getProjectById(student.getProjectid());
                FileOperation.writeFile(project.getProjectname(), progressInfo);
                //返回
                pgInfos.put("pgInfo", progressInfo);
            }break;
            case 100:{
                progressInfo.setPercentage(100);
                progressInfo.setProgressMsg("提交课题成品展示文档");
                Student student = (Student) httpSession.getAttribute("stu");
                Project project = projectService.getProjectById(student.getProjectid());
                FileOperation.writeFile(project.getProjectname(), progressInfo);
                //返回
                pgInfos.put("pgInfo", progressInfo);
            }break;
        }
        return pgInfos.values();
    }
}
