package cn.ron.meeting.controller;

import cn.ron.meeting.model.Department;
import cn.ron.meeting.model.Employee;
import cn.ron.meeting.model.Meeting;
import cn.ron.meeting.service.DepartmentService;
import cn.ron.meeting.service.EmployeeService;
import cn.ron.meeting.service.MeetingRoomService;
import cn.ron.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    MeetingRoomService meetingRoomService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    MeetingService meetingService;
    @RequestMapping("/bookmeeting")
    public String bookmeeting(Model model) {
        //让bookmeeting页面展示出数据库中的会议室名称
        model.addAttribute("mrs", meetingRoomService.getAllMr());
        return "bookmeeting";
    }

    @RequestMapping("/alldeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return departmentService.getAllDeps();
    }

    @RequestMapping("/getempbydepid")
    @ResponseBody
    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeService.getEmpsByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentuser = (Employee) session.getAttribute("currentuser");
        meeting.setReservationistid(currentuser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting,mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        }else{
            return "forward:/bookmeeting";
        }
    }

    @RequestMapping("/searchmeetings")
    public String searchmeetings() {
        return "searchmeetings";
    }
}
