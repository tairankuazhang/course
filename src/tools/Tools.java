package tools;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.IOUtils;

public class Tools {
	/**
	 * 提示
	 * @param response HttpServletResponse
	 * @param content 提示内容
	 * @param url 提示完成后显示页面
	 * @throws IOException
	 */
	public static void prompt(HttpServletResponse response,String content,String url) throws IOException{
		response.setContentType("text/html; charset=UTF-8"); 
		//获取打印流对象 
		PrintWriter out = response.getWriter();
		out.flush(); 
		out.println("<script>"); 
		out.println("alert('"+content+"！');"); 
		out.println("location.href='"+url+"'");
		out.println("</script>");
		out.close();
	}
	
	/**
	 * 删除文件
	 * @param type 
	 * 1：删除照片
	 * 2：删除视频
	 * @param fileName 文件名称
	 * @return 	1:成功
	 * 			0:失败
	 */
	public static int DeleteFile(int type,String fileName){
		String url="";
		if(type==1){//1为删除图片
			url="D:/devEnv8/workspace/course/WebContent/image/";
		}else {		//其他为删除视频
			url="D:/devEnv8/workspace/course/WebContent/videos/";
		}
		File file = new File(url+fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
//                System.out.println("删除单个文件" + fileName + "成功！");
                return 1;
                
            } else {
//                System.out.println("删除单个文件" + fileName + "失败！");
                return 0;
            }
        } else {
//            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return 1;
        }
	}
	
	/**
	 * 移动文件，文件名：当前时间+三位随机数
	 * @param request HttpServletRequest
	 * @param n 数组个数->from表单行数
	 * @param folder 目标文件夹
	 * @return
	 */
	public static String[] MoveFiles(HttpServletRequest request,int n,String folder){
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String  SdfDate="yyyyMMddHHmmssSSS";
		SimpleDateFormat  sdf=new SimpleDateFormat(SdfDate);
		String strDate=sdf.format(new Date());
		Random random=new Random();
		int intrandom=(int)(random.nextDouble()*(999-100 + 1))+ 100;
		String fileName=strDate+intrandom;
		String fileSuffix="";
		String[] information = new String[n];
		int i=0;
		try {
			List<FileItem> items=upload.parseRequest(request);
			for(FileItem item:items){
				if(item.isFormField()){
					try {
						information[i]=item.getString("utf-8");
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					fileSuffix=item.getName();
					if(fileSuffix!=null && !("".equals(fileSuffix))){
						fileSuffix=fileSuffix.substring(fileSuffix.lastIndexOf(".")+1);
						try {
							FileOutputStream fos=new FileOutputStream("D:/devEnv8/workspace/course/WebContent/"+folder+"/"+fileName+"."+fileSuffix);
							information[i]=fileName+"."+fileSuffix;
							try {
								IOUtils.copy(item.getInputStream(), fos);
							} catch (IOException e) {
								e.printStackTrace();
							}
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						}
					}else{
						information[i]="";
					}
				}
				i++;
			}
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return information;
	}
}
