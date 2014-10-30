package ln.struts.actionform;


import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

public class UploadActionForm extends ActionForm {
	private FormFile uploadfile;

    public void setUploadFile(FormFile uploadfile) { 
        this.uploadfile = uploadfile; 
    }

    public FormFile getUploadFile() { 
        return uploadfile; 
    }
}
