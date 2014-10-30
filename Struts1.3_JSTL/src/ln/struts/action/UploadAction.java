package ln.struts.action;

import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ln.struts.actionform.UploadActionForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

/**
 * 上傳的程式範例
 * 此版本在1.3.10似乎有問題
 * 程式範例目前無法執行，待有實際用到再花時間除錯
 * 
 * @author Ian Chen
 */
public class UploadAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		UploadActionForm uploadFormAction = (UploadActionForm) form;
		FormFile file = uploadFormAction.getUploadFile();
		String filePath = this.getServlet().getServletContext().getRealPath("upload") + "\\" + file.getFileName();
        FileOutputStream fileOutput = new FileOutputStream(filePath);

        fileOutput.write(file.getFileData());
        fileOutput.flush();
        fileOutput.close();
        file.destroy() ;  // destroy temperaty file
        
        request.setAttribute("filePath", filePath);
		
		return mapping.findForward("success");
		
	}
}
