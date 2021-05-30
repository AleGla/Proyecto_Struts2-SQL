<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><s:text name="form.titulo.title"/></title>
        <s:head/>
    </head>
    <body style="background: #fff8d9">
               
        
        <s:form action="validarFormulario" method="POST" style="font-family: Arial;padding-left: 230px; background: transparent">
        <caption><h3 style="font-size: 23px; margin-top: 5px; padding-left: 230px;  " ><s:text name="form.titulo"/></h3></caption>
             <div>
                <s:textfield key="form.usuario" name="forma.usuario"/>
            </div>
             
            
            <div>
                <s:password key="form.password" name="forma.password"/>
            </div>
                       
            
            <div>
                <s:textfield key="form.nombre" name="forma.nombre"/>
            </div>
                       
            
            <div>
                <s:textfield key="form.apellido" name="forma.apellido"/>
            </div>
                       
                                   
            
            <div>
                <s:textfield key="form.email" name="forma.email"/>
            </div>
                       
            
            <div>
                <s:textfield key="form.edad" type="number" name="forma.edad" min="1" max="151"/>
            </div>
              
            
            <div>
                <s:textfield key="form.telefono" name="forma.telefono"/>
            </div>
            
             
            <div>
            <s:submit key="form.boton"/>
            </div>
        
        <div style="color: red">
        <s:reset key="form.restablecer"/>
        </div>

        
        </s:form>
        
        
            <s:url var="localeEN" action="intro">
                <s:param name="request_locale">en</s:param>
            </s:url>   
            
            <s:url var="localeES" action="intro">
                <s:param name="request_locale">es</s:param>
            </s:url> 
            
                <div style="padding-left: 570px; padding-top: 5px">
                <s:a href="%{localeEN}"  style="color:black">Ingles</s:a>
                |
                <s:a href="%{localeES}" style="color:black">Español</s:a>
               </div>
    </body>
</html>
