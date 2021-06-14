package com.hack.graduation_project_system.controller;

import com.hack.graduation_project_system.Utils.DateUtils;
import com.hack.graduation_project_system.Utils.FileOperation;
import com.hack.graduation_project_system.Utils.ReadHtmlFileUtil;
import com.hack.graduation_project_system.Utils.WordAndHtmlExchangeUtil;
import com.hack.graduation_project_system.domain.*;
import com.hack.graduation_project_system.pojo.Message;
import com.hack.graduation_project_system.pojo.ProgressInfo;
import com.hack.graduation_project_system.pojo.ProjectInfo;
import com.hack.graduation_project_system.service.ProgressService;
import com.hack.graduation_project_system.service.ProjectService;
import com.hack.graduation_project_system.service.StudentService;
import com.hack.graduation_project_system.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/pj")
public class ProjectController {

    private ProjectInfo projectInfo;
    private ProgressInfo progressInfo;
    private ProjectService projectService;
    private TeacherService teacherService;
    private StudentService studentService;
    private ProgressService progressService;

    @Autowired
    public void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }
    @Autowired
    public void setProjectInfo(ProjectInfo projectInfo) {
        this.projectInfo = projectInfo;
    }

    @Autowired
    public void setProjectService(ProjectService projectService){
        this.projectService = projectService;
    }
    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }
    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    @Autowired
    public void setProgressService(ProgressService progressService) {
        this.progressService = progressService;
    }

    @ResponseBody
    @RequestMapping("/getPjInfoByStu")
    public Collection<ProjectInfo> getPjInfoByStu(HttpServletRequest request){
        HttpSession httpSession = request.getSession();
        Student student = (Student) httpSession.getAttribute("stu");
        Map<String, ProjectInfo> pInfo = new HashMap<>();
        Integer pid = student.getProjectid();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Project project = null;
        String teacherName = null;
        try{
            project = projectService.getProjectById(pid);
            teacherName = teacherService.getNameById(Integer.parseInt(project.getSubmitid()));
        }catch (NullPointerException e){
            projectInfo.setChoice(false);
            pInfo.put("null", projectInfo);
            return pInfo.values();
        }

        projectInfo.setpName(project.getProjectname());
        projectInfo.settName(teacherName);
        projectInfo.setpDate(sdf.format(project.getTime()));
        projectInfo.setpLast(sdf.format(project.getTime()));
        projectInfo.setChoice(true);
        pInfo.put("projectInfo", projectInfo);
        return pInfo.values();
    }
    @RequestMapping("/showPjs")
    public String showPjToStu(){
        return "/project/stu-choicePj";
    }
    /**
     * 获取所有未被选择的课题
     * @return
     */
    @ResponseBody
    @PostMapping("/stuGetPjsToStu")
    public Collection<ProjectInfo> getAllPjToStu(){
        List<Project> projects = projectService.getNotChoiceProjects();
        Map<Integer, ProjectInfo> projectInfos = new HashMap<>();

        int i = 0;
        for (Project project : projects) {

            if (project.getStatus()){
                //获取教师姓名
                System.out.println(project.getStatus());
                String tName = teacherService.getNameById(Integer.parseInt(project.getSubmitid().trim()));
                ProjectInfo pInfo = new ProjectInfo();
                pInfo.setpName(project.getProjectname());
                pInfo.setChoice(false);
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                pInfo.setId(project.getProjectid());
                pInfo.setpDate(sdf.format(project.getTime()));
                pInfo.setNeed(project.getNeed());
                pInfo.settName(tName);
                pInfo.setDescription(project.getProjectname());
                pInfo.setpLast(sdf.format(project.getTime()));
                projectInfos.put(i, pInfo);
                i++;
            }
        }
        return projectInfos.values();
    }

    @RequestMapping("/showPjInfo/{id}")
    public ModelAndView showPjInfo(@PathVariable("id") Integer id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/project/project-info");
        modelAndView.addObject("id", id);
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/showH5File")
    public String showH5File(HttpServletRequest request, @RequestParam(value = "id" ) Integer id){
        //"uploadFile/1000/1840224173-侯广龙-实验04-Redis数据类型-3.html"
//        String html = ReadHtmlFileUtil.readFile(fileName.trim());
//        Student student = (Student) request.getSession().getAttribute("stu");
        String html = projectService.getProjectById(id).getContentfilename();
        return "../" + html;
    }

    @RequestMapping("/showPjsByTeacher")
    public String showPjsByTeacher(){
        return "project/stu-choicePjByTeacher";
    }

    @ResponseBody
    @RequestMapping("/getInfoByID")
    public Collection<ProjectInfo> getPjInfoById(@RequestParam(value = "id") Integer id){
        Project project = projectService.getProjectById(id);
        Map<Integer, ProjectInfo> pMap = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat();
        String tName =  teacherService.getNameById(Integer.parseInt(project.getSubmitid()));
        projectInfo.setpName(project.getProjectname());
        projectInfo.settName(tName);
        projectInfo.setpDate(sdf.format(project.getTime()));
        projectInfo.setpLast(sdf.format(project.getTime()));
        projectInfo.setNeed(project.getNeed());
        projectInfo.setDescription(project.getProjectname());
        projectInfo.setChoice(false);
        projectInfo.setFile(project.getContentfilename());
        pMap.put(1, projectInfo);
        return pMap.values();
    }
    @ResponseBody
    @RequestMapping("/getPjsByTeacher")
    public Collection<ProjectInfo> getProjectsByTeacher(@RequestParam(value = "teacherId") Integer teacherId){
        List<Project> projects = projectService.getProjectsBySubmitId(teacherId);
        Map<Integer, ProjectInfo> pInfos = new HashMap<>();
        int i = 0;
        for (Project project : projects){
            ProjectInfo pInfo = new ProjectInfo();
            String teacherName = teacherService.getNameById(Integer.parseInt(project.getSubmitid()));
            pInfo.setpName(project.getProjectname());
            pInfo.settName(teacherName);
            pInfo.setFile(project.getContentfilename());
            pInfo.setChoice(true);
            pInfo.setDescription(project.getProjectname());
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            pInfo.setpDate(sdf.format(project.getTime()));
            pInfo.setpLast(sdf.format(project.getTime()));
            pInfo.setNeed(project.getNeed());
            pInfo.setId(project.getProjectid());
            pInfos.put(i, pInfo);
            i++;
        }
        return pInfos.values();
    }

    /**
     * 毕业生选择毕业课题controller
     * v0.0.1 未完成：选择成功后的操作
     * @param request
     * @param pid
     * @return
     */
    @RequestMapping("/selectPj")
    public String selectProject(HttpServletRequest request, @RequestParam(value = "pid") String pid){
        //用过Session获取学生用户信息，并关联课题id
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("stu");
        //判断学生是否已经选择了课题，如果没有选择则可以进行选择，如果已经选择则将跳转错误界面
        if (student.getProjectid()==null){
            student.setProjectid(Integer.parseInt(pid));
            studentService.updateStudent(student);

            //改变课题状态，choice状态false -> true
            Project project = projectService.getProjectById(Integer.parseInt(pid));
            project.setChoose(true);
            projectService.updateProject(project);

            //选题成功后，创建对应的progress对象和文件
            progressInfo.setPercentage(20);
            progressInfo.setProgressMsg("选择课题成功！");
            FileOperation.writeFile(project.getProjectname(), progressInfo);

            Progress progress = new Progress();
            progress.setProjectid(Integer.parseInt(pid));
            progress.setStudentid(student.getStudentid());
            progress.setContentfilename(project.getProjectname()+".txt");
            progressService.addProgress(progress);
            return "project/project-manager";
        }else{
            return "error/SelectedError";
        }

    }


    @RequestMapping("cancelPj")
    public String cancelProject(HttpServletRequest request, @RequestParam(value = "pid") String id){
        HttpSession session = request.getSession();
        Student student = (Student) session.getAttribute("stu");
        //从HttpSession中获取student，判断该student是否有进行过课题选择
        if (student.getProjectid()!=null){
            student.setProjectid(null);
            studentService.updateStudent(student);

            //从课题表中修改课题状态 true -> false
            Project project = projectService.getProjectById(Integer.parseInt(id));
            project.setChoose(false);
            projectService.updateProject(project);

            //从progress中删除信息
            Progress progress = progressService.getProgressByProjectId(Integer.parseInt(id));
            progressService.deleteProgress(progress);
            return "project/project-manager";
        }else {
            return "project/project-info";
        }

    }

    //teacher
    /**
     * 查看已开设课题
     *
     * @return
     */
    @GetMapping("/showPublishPjList")
    public ModelAndView showPublishPjList() {
        String viewName = "project/publish_project_table";
        ModelAndView modelAndView = new ModelAndView(viewName);
        List<Project> projects = projectService.getProjectByTime(new Date(DateUtils.getYearStartTime(System.currentTimeMillis())));
        Map datas = new HashMap();
        for (Project project : projects) {
            Teacher teacher = teacherService.getTeacherById(Integer.valueOf(project.getSubmitid()));
            datas.put(teacher, project);

        }
        modelAndView.addObject("datas", datas);
        return modelAndView;
    }

    /**
     * 获取历年课题
     */
    @GetMapping(value = "/showPjListByYear/{year}")
    public ModelAndView showPjListByYear(@PathVariable("year") String year) {
        String viewName = "project/project_table_by_year";
        ModelAndView modelAndView = new ModelAndView(viewName);
        List<Project> projects = projectService.getProjectByTime(new Date(DateUtils.getYearStartTime(DateUtils.getYearTimeStamp(year))));
        Map datas = new HashMap();
        for (Project project : projects) {
            Teacher teacher = teacherService.getTeacherById(Integer.valueOf(project.getSubmitid()));
            datas.put(teacher, project);
        }
        modelAndView.addObject("datas", datas);
        return modelAndView;
    }

    @GetMapping("/uploadProject")
    public String uploadProject() {
        return "/project/project_uploadFile";
    }

    /**
     * 上传课题为html
     * @param file
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping("/uploadProject")
    public String uploadProject(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        //保存到临时文件,并获取临时文件路径
        String filePath = fileSaveTemp(file, request);
        // 定义上传文件保存文件名
        String path = "";
        path += filename.split("\\.")[0] + ".html";
        //用户id
        String userId = null;
        HttpSession session = request.getSession();
        if (session.getAttribute("teacher") != null) {
            userId = String.valueOf(((Teacher) session.getAttribute("teacher")).getTeacherid());
        } else if (session.getAttribute("leader") != null) {
            userId = String.valueOf(((Leader) session.getAttribute("leader")).getLeaderid());
        } else if (session.getAttribute("stu") != null) {
            userId = String.valueOf(((Student) session.getAttribute("stu")).getStudentid());
        }

        //保存文件,word转html
        if (filename.split("\\.")[1].equals("doc")) {
            WordAndHtmlExchangeUtil.docToHtml(filePath, path, userId);
            WordAndHtmlExchangeUtil.docToHtmlToTarget(filePath, path, userId);
        } else if (filename.split("\\.")[1].equals("docx")) {
            WordAndHtmlExchangeUtil.docxToHtml(filePath, path, userId);
            WordAndHtmlExchangeUtil.docxToHtmlToTarget(filePath, path, userId);
        } else {
            return "error";
        }

        System.out.println(filePath);
        return "redirect:/pj/publishAndCheckProject";
    }

    /**
     * 发布课题
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping("publishAndCheckProject")
    public ModelAndView publishAndCheckProject(HttpServletRequest request) throws Exception {
        String viewName = "project/publish_project";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        String teacherId = String.valueOf(((Teacher) session.getAttribute("teacher")).getTeacherid());
        List<Project> projects = projectService.getTeacherProjectListBySubmitId(teacherId);
        modelAndView.addObject("projects", projects);

        //从本地文件中读取课题
        List<Map<String, String>> publishProjects = getProjectFile(teacherId);
        if (publishProjects != null) {
            //判断本地文件中的发布状态
            for (Map map: publishProjects) {
                outer: for (Project project: projects) {
                    if (project.getProjectname().equals(map.get("filename"))) {
                        map.put("publish", "已发布");
                        break outer;
                    } else {
                        map.put("publish", "未发布");
                    }
                }
                //根据文件路径获取url
                String path = (String) map.get("path");
                String[] pathArray = path.split("\\\\");
                String url = "";
                for (int i=4; i<pathArray.length-1; i++) {
                    url = url + pathArray[i] + "/";
                }
                url += pathArray[pathArray.length-1];
                map.put("url", url);

                if (map.get("publish") == null) {
                    map.put("publish", "未发布");
                }
            }
            modelAndView.addObject("publishProjects", publishProjects);
        }
        return modelAndView;
    }

    @GetMapping("/addProject")
    public ModelAndView addProject(@RequestParam("filename") String filename, HttpServletRequest request) throws Exception {
        String viewName ="project/add_project_form";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        String teacherId = String.valueOf(((Teacher) session.getAttribute("teacher")).getTeacherid());
        Map<String, String> map = getProjectFileByName(filename, teacherId);
        modelAndView.addObject("projectFile", map);
        return modelAndView;
    }

    /**
     * 获取project信息，写入数据库
     * @param filename
     * @param path
     * @param need
     * @param submitId
     * @return
     */
    @PostMapping("/addProject")
    public String addProject(@RequestParam("filename") String filename,
                             @RequestParam("path") String path,
                             @RequestParam("need") String need,
                             @RequestParam("submitId") String submitId) {
        //根据文件路径获取url
        String[] pathArray = path.split("\\\\");
        String url = "";
        for (int i=4; i<pathArray.length-1; i++) {
            url = url + pathArray[i] + "/";
        }
        url += pathArray[pathArray.length-1];

        //写入数据库
        Project project = new Project();
        project.setProjectname(filename);
        project.setNeed(need);
        project.setSubmitid(submitId);
        project.setTime(new Date());
        project.setStatus(false);
        project.setChoose(false);
        project.setSpecialproject(false);
        project.setContentfilename(url);
        projectService.addProject(project);
        return "redirect:/pj/publishAndCheckProject";
    }

    @GetMapping("/deleteProject")
    public String deleteProject(@RequestParam("filename") String filename, HttpServletRequest request) {
        HttpSession session = request.getSession();
        String teacherId = String.valueOf(((Teacher) session.getAttribute("teacher")).getTeacherid());
        Project project = projectService.getProjectByFilenameAndSubmitId(filename, teacherId);
        projectService.deleteProject(project);
        return "redirect:/pj/publishAndCheckProject";
    }

    @GetMapping("/projectStatusCheck")
    public ModelAndView projectStatusCheck(HttpServletRequest request){
        String viewName ="project/project_status_check";
        ModelAndView modelAndView = new ModelAndView(viewName);
        HttpSession session = request.getSession();
        String teacherId = String.valueOf(((Teacher) session.getAttribute("teacher")).getTeacherid());
        List<Project> projects = projectService.getTeacherProjectListBySubmitId(teacherId);
        List datas = new ArrayList();
        Teacher teacher = teacherService.getTeacherById(Integer.valueOf(teacherId));
        for (Project project : projects) {
            Map<String, Object> map = new HashMap<>();
            map.put("teacher", teacher);
            map.put("project", project);
            datas.add(map);
        }
        modelAndView.addObject("datas", datas);
        return modelAndView;
    }


    //保存上传文件到临时文件夹temp
    private String fileSaveTemp(MultipartFile file, HttpServletRequest request) throws IOException {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = ResourceUtils.getURL("classpath:").getPath() + "static\\uploadFile\\temp\\";
        String realPath = path.replace('/', '\\').substring(1, path.length());
        //保存到临时文件
        File file1 = new File(realPath);
        if (!file1.exists()) file1.mkdirs();
        file.transferTo(new File(file1 + "\\" + filename));

        return realPath + filename;
    }

    //获取文件名和路径
    private static List<Map<String, String>> getProjectFile(String userId) throws Exception {
        List list = new ArrayList();
        File fileDir = ResourceUtils.getFile("src\\main\\resources\\static\\uploadFile\\"+userId);
        if (!fileDir.exists()) {
//            fileDir.mkdirs();
            System.out.println("文件路径错误");
            return null;
        }
        File[] allFiles = fileDir.listFiles();

        for (File f: allFiles) {
            if (f.isFile()) {
                Map<String, String> fileData = new HashMap<>();
                fileData.put("filename",f.getName().split("\\.")[0]);
                fileData.put("path", f.getPath());
                fileData.put("submitId", userId);
                list.add(fileData);
            }
        }
        return list;
    }

    //根据文件名获取文件基本信息
    private static Map<String, String> getProjectFileByName(String filename, String userId) throws Exception {
        Map<String, String> fileData = new HashMap<>();
        File fileDir = ResourceUtils.getFile("src\\main\\resources\\static\\uploadFile\\"+userId);
        if (!fileDir.exists()) {
            System.out.println("文件路径错误");
            return null;
        }
        File[] allFiles = fileDir.listFiles();

        for (File f: allFiles) {
            if (f.isFile() && f.getName().equals(filename + ".html")) {
                fileData.put("filename",filename);
                fileData.put("path", f.getPath());
                fileData.put("submitId", userId);
            }
        }
        return fileData;
    }

//admin

    @GetMapping("/ProjectStatusUnVerify")
    public ModelAndView ProjectStatusUnVerify() {
        String viewName = "project/project_status_unVerify";
        ModelAndView modelAndView = new ModelAndView(viewName);
        List<Project> projects = projectService.getProjectByTime(new Date(DateUtils.getYearStartTime(System.currentTimeMillis())));
        List datas = new ArrayList();
        for (Project project : projects) {
            //获取未审核课题
            if (!project.getStatus()) {
                Map<String, Object> data = new HashMap();
                Teacher teacher = teacherService.getTeacherById(Integer.valueOf(project.getSubmitid()));
                data.put("project", project);
                data.put("teacher",teacher);
                datas.add(data);
            }
        }
        modelAndView.addObject("datas", datas);
        return modelAndView;
    }

    @PostMapping("/CheckProject")
    public String CheckProject(@RequestParam("id") String id) {

        Project project = projectService.getProjectById(Integer.parseInt(id));
        project.setStatus(true);
        projectService.updateProject(project);
        return "redirect:/pj/ProjectStatusUnVerify";
    }

    /**
     * 获取本专业所有本年的课题
     * @param request
     * @return
     */
    @GetMapping("/allProjectByMajor")
    public ModelAndView AllprojectByMajor(HttpServletRequest request) {
        String viewName = "project/project_major";
        ModelAndView modelAndView = new ModelAndView(viewName);

        HttpSession session = request.getSession();
        String majorId = ((Leader) session.getAttribute("leader")).getMajorid();
        List datas = new ArrayList();

        //根据专业负责人的专业，获取本专业的下所有的教师id
        List<Teacher> teacherList = teacherService.getAllTeacherByMajorId(majorId);
        for (Teacher teacher : teacherList) {
            String teacherId = String.valueOf(teacher.getTeacherid());
            List<Project> projects = projectService.getTeacherProjectListBySubmitId(teacherId);
            for (Project project : projects) {
                Map<String, Object> map = new HashMap<>();
                map.put("teacher", teacher);
                map.put("project", project);
                datas.add(map);
            }
        }

        modelAndView.addObject("datas", datas);
        return modelAndView;
    }


}
