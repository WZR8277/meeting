package cn.ron.meeting.mapper;

import cn.ron.meeting.model.MeetingRoom;
import cn.ron.meeting.model.RoomDTO;

import java.util.List;

public interface MeetingRoomMapper {

    List<MeetingRoom> getAllMr();

    MeetingRoom getMrById(Integer roomid);

    Integer updateroom(MeetingRoom meetingRoom);
    Integer addMr(MeetingRoom meetingRoom);
    List<RoomDTO> getAll();
}
