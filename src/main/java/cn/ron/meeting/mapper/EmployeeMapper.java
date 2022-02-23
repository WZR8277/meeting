package cn.ron.meeting.mapper;

import cn.ron.meeting.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {

    Employee loadEmpByUsername(String username);

    Integer doReg(Employee employee);

    List<Employee> getAllEmpsByStatus(Integer status);

    Integer updatestatus(@Param("employeeid") Integer employeeid, @Param("status") Integer status);

    List<Employee> getAllEmps(@Param("emp") Employee employee, @Param("page") Integer page,
                              @Param("pagesize") Integer pageSize);

    Long getTotal(Employee employee);

    List<Employee> getEmpsByDepId(Integer depId);
    List<Employee> getAllEmpsByid(List<Integer> list);
    void doChang(@Param("username") String username, @Param("newpassword") String newpassword);
}
