package uploadtest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet
 */
@MultipartConfig
@WebServlet("/UploadServlet2")
public class UploadServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.processRequest(request, response);
	}
	
	//通过getPart()、getParts()取得上传文件。支持多文件
	/**
     * Processes requests for both HTTP
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	Collection<Part> parts = request.getParts();  
        System.out.println(parts);  
        for(Part part:parts){  
            String fileName = getFileName(part);
            if(fileName.length()>0){
                writeTo(fileName, part);
            }
        }  
    }

    //取得上传文件名
    private String getFileName(Part part) {
    	try{
	        String header = part.getHeader("Content-Disposition");
	        String fileName = header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
	        // 取扩展名加随机数进行重命名
	        fileName = new SimpleDateFormat("yyyyMMddHHmmsssss").format(new Date())+java.util.UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."),fileName.length());
	        return fileName;
    	} catch (Exception e){
    		return "";
    	}
    }

    //存储文件
    private void writeTo(String fileName, Part part) throws IOException, FileNotFoundException {
        InputStream in = part.getInputStream();
        String filePath = this.getServletContext().getRealPath("")+"/Uploads/"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"/";//初始化保存的位置
        Tools.isExistDir(filePath);//看目录是否已经创建        
        OutputStream out = new FileOutputStream(filePath + fileName);
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            out.write(buffer, 0, length);
        }

        in.close();
        out.close();
    }


}
