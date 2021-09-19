package com.example.WebProject1.Controller;

import com.example.WebProject1.DAO;
import com.example.WebProject1.Service;
import com.example.WebProject1.StudentGrade;
import com.example.WebProject1.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class ServletController {

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public String ViewLogin()
    {
        return "Login";
    }
    @RequestMapping(value = "/viewprocess", method= RequestMethod.POST)
    public String ProcessLoginAndViewPageUser(HttpServletRequest request, Model m){
        String Email=request.getParameter("email");
        String Password=request.getParameter("psw");
        String TypeUser= Service.ExtractTypeUser(Email);
        HttpSession session = request.getSession();
        User user= DAO.Login(Email,Password,TypeUser);
        session.setAttribute("UID",String.valueOf(user.getID()));
        session.setAttribute("TypeUser",TypeUser);
        if(user!=null){
            session.setAttribute("UEmail",user.getEmail());
            if(TypeUser.equals("Student")){
                Map<String,String> map= DAO.getAllCoursesForStudent(String.valueOf(user.getID()));
                m.addAttribute("Courses",map);
                m.addAttribute("FName",user.getFName());
                return "StudentCourses";
            }
            else if(TypeUser.equals("Instructor")){
                Map <String,String> map= DAO.getAllCoursesForInstructor(String.valueOf(user.getID()));
                m.addAttribute("Courses",map);
                m.addAttribute("FName",user.getFName());
                return "InstructorCourses";
            }
            else if(TypeUser.equals("Admin")){
                m.addAttribute("FName",user.getFName());
                return "AdminOperation";
            }
            else {
                m.addAttribute("errorMessage", "Email or password invalid !!");
                return "Login";
            }

        }
        else {
            m.addAttribute("errorMessage", "Email or password not found in data base");
            return "Login";
        }
    }
    @RequestMapping(value = "/courseinfo", method= RequestMethod.POST)
    public String ViewInfoStudentForInstructor(HttpServletRequest request, @RequestParam("CID") String CID, Model m){
        Map <Integer, StudentGrade> map= DAO.getStudentsAndGrade(CID);
        HttpSession session=request.getSession();
        session.setAttribute("CID",CID);
        m.addAttribute("Student",map);
        return "StudentInfo";
    }
    @RequestMapping(value = "/savechangegrade", method= RequestMethod.POST)
    public String SaveChangeGrade(HttpServletRequest request, @RequestParam("Grade") String Grade,@RequestParam("SID") int SID, Model m){
        HttpSession session=request.getSession();
        String CID= (String) session.getAttribute("CID");
        DAO.ChangeGrade(Grade,CID,SID);
        Map<Integer,StudentGrade> map= DAO.getStudentsAndGrade(CID);
        m.addAttribute("Student",map);
        return "StudentInfo";
    }
    @RequestMapping(value = "/logout", method= RequestMethod.POST)
    public String Logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.invalidate();
        return "Login";
    }


}
