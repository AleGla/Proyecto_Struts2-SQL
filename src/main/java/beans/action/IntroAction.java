package beans.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

@Result(name="success", location="/WEB-INF/content/formulario.jsp")
public class IntroAction extends ActionSupport{
    
    @Action("intro")
    public String execute(){
        return SUCCESS;
    }
    
}
