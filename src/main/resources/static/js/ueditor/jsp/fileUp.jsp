<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="ueditor.Uploader"%>


<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String contextPath = request.getContextPath();

    Uploader up = new Uploader(request);
    
    up.setSavePath("../../userfiles/file"); //保存路径
    String[] fileType = {".rar" , ".doc" , ".docx" , ".ppt" , ".pptx" , ".xls" , ".xlsx" , ".zip" , ".pdf" , ".txt" , ".swf", ".wmv"};  //允许的文件类型
    up.setAllowFiles(fileType);
    up.setMaxSize(1024*100);        //允许的文件最大尺寸，单位KB
    up.upload();
    
    String mmUrl = up.getUrl();
    if(!"".equals(contextPath))
    {
    	mmUrl = contextPath.replace("/", "") + "/" + mmUrl;
    }
    
    response.getWriter().print("{'url':'"+mmUrl+"','fileType':'"+up.getType()+"','state':'"+up.getState()+"','original':'"+up.getOriginalName()+"'}");
%>
