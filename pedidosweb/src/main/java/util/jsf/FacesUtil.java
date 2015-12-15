package util.jsf;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
    
    public static void addErrorMessage(String message) {
        FacesContext.getCurrentInstance().addMessage(message, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, message,message));
        
    }    
    
    public static boolean isPostBack() {
    	return FacesContext.getCurrentInstance().isPostback();
	}
    
    public static boolean isNotPostBack() {
    	return !isPostBack();
	}
}
