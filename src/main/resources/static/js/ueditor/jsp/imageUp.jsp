
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="ueditor.Uploader"%>

<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String contextPath = request.getContextPath();
    
    Uploader up = new Uploader(request);
    
    up.setSavePath("../../userfiles/image");
    String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
    up.setAllowFiles(fileType);
    up.setMaxSize(10000); //单位KB
    up.upload();
    
    String mmUrl = up.getUrl();
    if(!"".equals(contextPath))
    {
    	mmUrl = contextPath.replace("/", "") + "/" + mmUrl;
    }
    
    response.getWriter().print("{'original':'"+up.getOriginalName()+"','url':'"+ mmUrl+"','title':'"+up.getTitle()+"','state':'"+up.getState()+"'}");
    %>
