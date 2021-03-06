package com.soloud.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileUpload;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public class AjaxMultipartResolver extends CommonsMultipartResolver {
    
	private static ThreadLocal<AjaxProgressListener> progressListener = new ThreadLocal<AjaxProgressListener>();
	
	private AjaxProgressListener getListener() {
        
        AjaxProgressListener listener = progressListener.get();
        if(listener == null)
        {
            listener = new AjaxProgressListener();
            progressListener.set(listener);
        }
        return listener;
    }
	
	@Override
    protected FileUpload prepareFileUpload(String encoding) {
        FileUpload fileUpload = getFileUpload();
        FileUpload actualFileUpload = fileUpload;
 
        actualFileUpload = newFileUpload(getFileItemFactory());
        actualFileUpload.setSizeMax(fileUpload.getSizeMax());
        actualFileUpload.setHeaderEncoding(encoding);
         
        actualFileUpload.setProgressListener(getListener());
        return actualFileUpload;
    }
 
    public MultipartHttpServletRequest resolveMultipart(HttpServletRequest request) throws MultipartException {
        try {           
            AjaxProgressListener listener = getListener();
            HttpSession session = request.getSession();
            listener.setHttpSession(session);
             
            return super.resolveMultipart(request);
                 
        } catch(MaxUploadSizeExceededException ex) {
             throw new MultipartException(ex.getMessage());
        } catch (Exception ex) {
            //exception is typically thrown when user hits stop or cancel
            //button halfway through upload
            throw new MultipartException(ex.getMessage());
        }
    }
}