<!DOCTYPE html>
<html>
    <head>
        <title>CoolMeeting会议管理系统</title>
        <link rel="stylesheet" href="/styles/common.css"/>
        <style type="text/css">
            
        </style>
    </head>
    <body>
        <div class="page-header">
            <div class="header-banner">
                <img src="/images/header.png" alt="CoolMeeting"/>
            </div>
            <div class="header-title">
                欢迎访问Cool-Meeting会议管理系统
            </div>
            <div class="header-quicklink">
                欢迎您，<strong>admin</strong>
                <a href="changepassword.ftl">[修改密码]</a>
            </div>
        </div>
        <div class="page-body">
            <div class="page-sidebar">
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">个人中心</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="notifications.ftl">最新通知</a></li>
                        <li class="sidebar-menuitem active"><a href="mybookings.ftl">我的预定</a></li>
                        <li class="sidebar-menuitem"><a href="mymeetings.ftl">我的会议</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">人员管理</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="departments.ftl">部门管理</a></li>
                        <li class="sidebar-menuitem"><a href="register.ftl">员工注册</a></li>
                        <li class="sidebar-menuitem"><a href="approveaccount.ftl">注册审批</a></li>
                        <li class="sidebar-menuitem"><a href="searchemployees.ftl">搜索员工</a></li>
                    </ul>
                </div>
                <div class="sidebar-menugroup">
                    <div class="sidebar-grouptitle">会议预定</div>
                    <ul class="sidebar-menu">
                        <li class="sidebar-menuitem"><a href="addmeetingroom.ftl">添加会议室</a></li>
                        <li class="sidebar-menuitem"><a href="meetingrooms.ftl">查看会议室</a></li>
                        <li class="sidebar-menuitem"><a href="bookmeeting.ftl">预定会议</a></li>
                        <li class="sidebar-menuitem"><a href="searchmeetings.ftl">搜索会议</a></li>
                    </ul>
                </div>
            </div>
            <div class="page-content">
                <div class="content-nav">
                    会议预定 > 搜索员工
                </div>
                <form action="/admin/searchemployees" method="get">
                    <fieldset>
                        <legend>搜索会议</legend>
                        <table class="formtable">
                            <tr>
                                <td>姓名：</td>
                                <td>
                                    <input name="employeename" type="text" id="employeename"
                                           value="<#if employee??>${employee.employeename!''}</#if>" maxlength="20"/>
                                </td>
                                <td>账号名：</td>
                                <td>
                                    <input name="username" type="text" id="accountname"
                                           value="<#if employee??>${employee.username!''}</#if>" maxlength="20"/>
                                </td>
                                <td>状态：</td>
                                <td>
                                    <#if employee??>
                                        <#if employee.status == 0>
                                            <input type="radio" id="status" name="status" value="1"/><label>已批准</label>
                                            <input checked="checked" type="radio" id="status" name="status" value="0"/>
                                            <label>待审批</label>
                                            <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                        <#elseif employee.status == 1>
                                            <input checked="checked" type="radio" id="status" name="status" value="1"/>
                                            <label>已批准</label>
                                            <input type="radio" id="status" name="status" value="0"/>
                                            <label>待审批</label>
                                            <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                        <#elseif employee.status == 2 >
                                            <input type="radio" id="status" name="status" value="1"/>
                                            <label>已批准</label>
                                            <input type="radio" id="status" name="status" value="0"/>
                                            <label>待审批</label>
                                            <input checked="checked" type="radio" id="status" name="status" value="2"/>
                                            <label>已关闭</label>
                                        </#if>
                                    <#else >
                                        <input type="radio" id="status" name="status" value="1"
                                               checked="checked"/><label>已批准</label>
                                        <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                                        <input type="radio" id="status" name="status" value="2"/><label>已关闭</label>
                                    </#if>
                                </td>

                            </tr>
                            <tr>
                                <td colspan="6" class="command">
                                    <input type="submit" class="clickbutton" value="查询"/>
                                    <input type="reset" class="clickbutton" value="重置"/>
                                </td>
                            </tr>
                        </table>
                    </fieldset>
                </form>
                <div>
                    <h3 style="text-align:center;color:black">查询结果</h3>
                    <div class="pager-header">
                        <div class="header-info">
                            共<span class="info-number">${total}</span>条结果，
                            分成<span class="info-number">${pagenum}</span>页显示，
                            当前第<span class="info-number">${page}</span>页
                        </div>
                        <div class="header-nav">
                            <a type="button" class="clickbutton"
                               href="/admin/searchemployees?status=${employee.status}&page=1">首页</a>
                            <a type="button" class="clickbutton"
                                    <#if page!=1>
                                        href="/admin/searchemployees?status=${employee.status}&page=${page-1}"
                                    </#if>
                            >上页</a>
                            <a type="button" class="clickbutton"
                                    <#if page!=pagenum>
                                        href="/admin/searchemployees?status=${employee.status}&page=${page+1}"
                                    </#if>
                            >下页</a>
                            <a type="button" class="clickbutton"
                               href="/admin/searchemployees?status=${employee.status}&page=${pagenum}">末页</a>
                            <form action="/admin/searchemployees"
                                  style="display: inline"
                                  method="get">
                                <input type="hidden" name="status" value="${employee.status}">
                                跳到第<input name="page" type="text" id="pagenum" class="nav-number"/>页
                                <input type="submit" class="clickbutton" value="跳转"/>
                            </form>
                        </div>
                    </div>
                </div>
                <table class="listtable">
                    <tr class="listheader">
                        <th>姓名</th>
                        <th>账号名</th>
                        <th>联系电话</th>
                        <th>电子邮件</th>
                        <th>操作</th>
                    </tr>
                    <#if emps??>
                        <#list emps as emp>
                            <tr>
                                <td>${emp.employeename}</td>
                                <td>${emp.username}</td>
                                <td>${emp.phone}</td>
                                <td>${emp.email}</td>
                                <td>
                                    <a class="clickbutton" href="/admin/updateemp?id=${emp.employeeid}">关闭账号</a>
                                </td>
                            </tr>
                        </#list>
                    </#if>
                </table>
            </div>
        </div>
        <div class="page-footer">
            <hr/>
            更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
            <img src="/images/footer.png" alt="CoolMeeting"/>
        </div>
    </body>
</html>