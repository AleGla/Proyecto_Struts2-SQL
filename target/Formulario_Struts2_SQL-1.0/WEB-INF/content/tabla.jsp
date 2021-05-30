<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="form.titulo.title2"/></title>
    </head>
    <body style="background: #fff8d9">
        
        <table align="center" border= 2px width="80%">
            
            <caption><h1 style="font-size: 40px"><s:text name="form.titulo.title2"/></h1></caption>
            
            <tr style="background: #eba83a; color: black" >
                <th><s:text name="form.id"/></th>
                <th><s:text name="form.usuario"/></th>
                <th><s:text name="form.password"/></th>
                <th><s:text name="form.nombre"/></th>
                <th><s:text name="form.apellido"/></th>
                <th><s:text name="form.email"/></th>
                <th><s:text name="form.edad"/></th>
                <th><s:text name="form.telefono"/></th>
            </tr>     
                       
            <s:iterator value="personas">
                <tr style="background: white; color:black">
                <th><s:property value="idPersona"/></th>
                <th><s:property value="usuario"/></th>
                <th><s:property value="password"/></th>
                <th><s:property value="nombre"/></th>
                <th><s:property value="apellido"/></th>
                <th><s:property value="email"/></th>
                <th><s:property value="edad"/></th>
                <th><s:property value="telefono"/></th>  
            </tr> 
            
            </s:iterator>
        </table>
            
                <h2 align="center"><s:a href="volver" style="color: white; text-decoration: none; background: #bb371a; border: 2px solid black; color: #fff8d9"><s:text name="form.agregar" /></s:a></h2>
            
    </body>
</html>
