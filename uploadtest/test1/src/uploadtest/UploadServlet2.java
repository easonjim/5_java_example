package uploadtest;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UploadServlet
 */
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
	
	//通过getInputStream()取得上传文件。单文件
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
        response.setContentType("text/html;charset=UTF-8");
        //读取请求Body
        byte[] body = readBody(request);
        //取得所有Body内容的字符串表示
        String textBody = new String(body, "ISO-8859-1");
		//取得上传的文件名称
		String fileName = getFileName(textBody);
		//取得文件开始与结束位置
		Position p = getFilePosition(request, textBody);
		//输出至文件
		writeTo(fileName, body, p);
        	
    }

    /**
     * 文件起始位置类
     *
     */
    class Position {

        int begin;
        int end;

        public Position(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    /**
     * 获取request的getInputStream，返回byte
     * 
     * @param request 
     * @return
     * @throws IOException
     */
    private byte[] readBody(HttpServletRequest request) throws IOException {
        //获取请求文本字节长度
        int formDataLength = request.getContentLength();
        //取得ServletInputStream输入流对象
        DataInputStream dataStream = new DataInputStream(request.getInputStream());
        byte body[] = new byte[formDataLength];
        int totalBytes = 0;
        while (totalBytes < formDataLength) {
            int bytes = dataStream.read(body, totalBytes, formDataLength);
            totalBytes += bytes;
        }
        return body;
    }

    /**
     * 获取文件起始位置
     * 
     * @param request
     * @param textBody
     * @return
     * @throws IOException
     */
    private Position getFilePosition(HttpServletRequest request, String textBody) throws IOException {
        //取得文件区段边界信息
        String contentType = request.getContentType();
        String boundaryText = contentType.substring(contentType.lastIndexOf("=") + 1, contentType.length());
        //取得实际上传文件的起始与结束位置
        int pos = textBody.indexOf("filename=\"");
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        pos = textBody.indexOf("\n", pos) + 1;
        int boundaryLoc = textBody.indexOf(boundaryText, pos) - 4;
        int begin = ((textBody.substring(0, pos)).getBytes("ISO-8859-1")).length;
        int end = ((textBody.substring(0, boundaryLoc)).getBytes("ISO-8859-1")).length;

        return new Position(begin, end);
    }

    /**
     * 获取文件名
     * 
     * @param requestBody
     * @return
     */
	private String getFileName(String requestBody) {
		try {
			String fileName = requestBody.substring(requestBody.indexOf("filename=\"") + 10);
			fileName = fileName.substring(0, fileName.indexOf("\n"));
			fileName = fileName.substring(fileName.indexOf("\n") + 1,fileName.indexOf("\""));
			// 取扩展名加随机数进行重命名
			fileName = new SimpleDateFormat("yyyyMMddHHmmsssss").format(new Date()) + java.util.UUID.randomUUID() + fileName.substring(fileName.lastIndexOf("."),fileName.length());
			return fileName;
		} catch (Exception e) {
			return "";
		}
	}

    /**
     * 写文件
     * 
     * @param fileName
     * @param body
     * @param p
     * @throws IOException
     */
    private void writeTo(String fileName, byte[] body, Position p) throws IOException {
    	String filePath = this.getServletContext().getRealPath("")+"/Uploads/"+new SimpleDateFormat("yyyyMMdd").format(new Date())+"/";//初始化保存的位置
    	Tools.isExistDir(filePath);//看目录是否已经创建    	
        FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName);
        fileOutputStream.write(body, p.begin, (p.end - p.begin));
        fileOutputStream.flush();
        fileOutputStream.close();
    }

}
