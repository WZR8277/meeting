package cn.ron.meeting.service;

import cn.ron.meeting.mapper.MeetingRoomMapper;
import cn.ron.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    MeetingRoomMapper meetingRoomMapper;
    public List<MeetingRoom> getAllMr() {
        return meetingRoomMapper.getAllMr();
    }

    public MeetingRoom getMrById(Integer roomid) {
        return meetingRoomMapper.getMrById(roomid);
    }

    public Integer updateroom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.updateroom(meetingRoom);
    }
    public Integer addMr(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addMr(meetingRoom);
    }
}
