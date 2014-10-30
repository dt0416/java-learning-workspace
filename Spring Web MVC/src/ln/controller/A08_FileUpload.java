package ln.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

/**
 * 檔案上傳
 * 
 * @author Ian Chen
 */
@Controller
public class A08_FileUpload {

    /**
     * 使用MultipartFile，參數名稱需與jsp裡的input name要一致
     */
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String upload(MultipartFile attach, HttpServletRequest req) throws IOException {
        String realpath = req.getSession().getServletContext().getRealPath("upload");
        System.out.println("上傳路徑:" + realpath);
        File file = new File(realpath + "/" + attach.getOriginalFilename());
        FileUtils.copyInputStreamToFile(attach.getInputStream(), file);
        return "uploadSuccess";
    }
}
