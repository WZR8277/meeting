package cn.ron.meeting.controller;

import cn.ron.meeting.model.MeetingRoom;
import cn.ron.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MeetingRoomController {

    @Autowired
    MeetingRoomService meetingRoomService;
    @RequestMapping("/meetingrooms")
    public String meetingrooms(Model model){
        model.addAttribute("mrs",meetingRoomService.getAllMr());
        return "meetingrooms";
    }

    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model) {
        model.addAttribute("mr", meetingRoomService.getMrById(roomid));
        return "roomdetails";
    }

    @RequestMapping("/updateroom")
    public String updateroom(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.updateroom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        } else {
            return "forward:/roomdetails";
        }
    }

    @RequestMapping("/admin/addmeetingroom")
    public String addmeetingroom() {
        return "addmeetingroom";
    }

    @RequestMapping("/admin/doAddMr")
    public String doAddMr(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.addMr(meetingRoom);
        return "redirect:/meetingrooms";
    }

}
