package cn.ron.meeting.service;

import cn.ron.meeting.mapper.EmployeeMapper;
import cn.ron.meeting.mapper.MeetingParticipantsMapper;
import cn.ron.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    private MeetingParticipantsMapper meetingparticipantsMapper;
    public Employee doLogin(String username, String password) {
        Employee employee = employeeMapper.loadEmpByUsername(username);
        if(employee==null||!employee.getPassword().equals(password)){
            return null;
        }
        return employee;
    }

    public Integer doReg(Employee employee) {
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        if(emp!=null){
            return -1;
        }
        employee.setRole(1);
        employee.setStatus(0);
        return employeeMapper.doReg(employee);
    }

    public List<Employee> getAllEmpsByStatus(Integer status) {
        return employeeMapper.getAllEmpsByStatus(status);
    }

    public Integer updatestatus(Integer employeeid, Integer status) {
        return employeeMapper.updatestatus(employeeid,status);
    }

    public List<Employee> getAllEmps(Employee employee, Integer page, Integer pageSize) {
        //这个page是从第几行数据开始查
        page = (page - 1) * pageSize;
        return employeeMapper.getAllEmps(employee, page, pageSize);
    }

    public Long getTotal(Employee employee) {
        return employeeMapper.getTotal(employee);
    }

    public List<Employee> getEmpsByDepId(Integer depId) {
        return employeeMapper.getEmpsByDepId(depId);
    }
    public List<Employee> getEmpsByid(Integer meetingid) {

        List<Integer> list = meetingparticipantsMapper.getAllBymeetingid(meetingid);

        return employeeMapper.getAllEmpsByid(list);

    }

    public void doChang(String username, String newpassword) {
        employeeMapper.doChang(username, newpassword);
    }
}
