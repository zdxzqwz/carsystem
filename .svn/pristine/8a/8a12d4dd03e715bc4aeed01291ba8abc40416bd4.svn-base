package com.it.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;

import com.it.bean.Files;
import com.it.bean.PageBean;
import com.it.global.IFiles;
import com.it.services.FilesImpl;
import com.it.utils.Base64Util;
import com.it.utils.FileUtil;
import com.it.utils.StringUtil;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class FilesServlet
 */
@WebServlet({ "/FilesServlet", "/files.do" })
public class FilesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FilesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.设置编码格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 2.获取页面信息
		String opt = request.getParameter("opt");
		String f_id = request.getParameter("f_id");
		String f_name = request.getParameter("f_name");

		// 3.生成对象
		PrintWriter out = response.getWriter();
		Files file = new Files();
		IFiles ifile = new FilesImpl();
		List<Files> list = null;
		// 4.执行功能
		// 上传功能 addFiles
		if ("upload".equals(opt)) {
			// ID赋值
			file.setF_id(System.currentTimeMillis()+"");
			// 1.生成FileItemFactory
			FileItemFactory fileItemFactory = new DiskFileItemFactory();
			// 2.生成ServletFileUpload
			ServletFileUpload fileUpload = new ServletFileUpload(fileItemFactory);

			// 3.设置编码格式
			fileUpload.setHeaderEncoding("utf-8");
			List<FileItem> listf;
			try {
				listf = fileUpload.parseRequest(request);
				// 遍历集合
				for (FileItem fileItem : listf) {
					// 获取上传字段
					if (!fileItem.isFormField()) {
						String fileName = fileItem.getName();
						// 给f_name 赋值
						System.out.println("-----fileName----->"+fileName);
						file.setF_name(fileName);
						String parent = "F:\\upload";
						// 获取处理后的名字
						String file_path = FileUtil.getRealPath(parent, fileName);
						// 给文件路径赋值
						file.setF_path(file_path);
						System.out.println(file);
						boolean flag = ifile.addFiles(file);
						if (flag) {
							System.out.println("------upload--->上传成功");
							InputStream in = fileItem.getInputStream();

							FileOutputStream out1 = new FileOutputStream(new File(file.getF_path()));

							byte b[] = new byte[1024 * 8];

							while ((in.read(b)) != -1) {
								out1.write(b);
							}
							out1.flush();
							out1.close();
							in.close();
							System.out.println("----上传out.Print----");
							out.print("{\"success\": true,\"message\": \"上传成功.\"}");
						}else {
							out.print("{\"error\": false,\"message\": \"上传失败.\"}");
						}
					}
				}

			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException("上传失败！");
			}

			return;
		}
		// 下载功能download
		if ("download".equals(opt)) {
			response.reset();
			//获取下载rows的f_id集合
			String delIds = request.getParameter("delIds");
			System.out.println("delIds--->" + delIds);
			if (StringUtil.isNotEmpty(delIds)) {
				file.setF_id(delIds);
			}
			Files file1 = null;
			file1 = ifile.findByIdFiles(file);
			if (file1 != null) {
				System.out.println("-----download----servlet"+file1);
				String fileName = file1.getF_name();
				String filePath = file1.getF_path();
				System.out.println("----下载路径为------>"+filePath);
				// 设置响应头MIME类型
				response.setContentType(this.getServletContext().getMimeType(fileName));
				// 判断浏览器的不同对文件转码,文件名URL BASE64 重编码 IE 火狐
				String agents = request.getHeader("user-agent");

				if (agents.contains("MSIE")) {
					fileName = URLEncoder.encode(fileName, "utf-8");
				} else if (agents.contains("FireFox")) {
					fileName = Base64Util.base64EncodeFileName(fileName);
				} else {
					fileName = URLEncoder.encode(fileName, "utf-8");
				}
				//// 设置响应头下载附件格式
				response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
				// 完成下载 先读取然后再写

				InputStream in = new FileInputStream(new File(filePath));

				OutputStream out1 = response.getOutputStream();
				System.out.println("***************************");

				byte b[] = new byte[1024*5];

				while ((in.read(b)) != -1) {
					System.out.println("ddddddddddddd");
					out1.write(b);
					
				}
				out1.flush();
				out1.close();
				in.close();	
				System.out.println("------download---下载成功----->");
				out.println("{\"success\": true,\"message\": \"下载成功.\"}");
			} else {
				System.out.println("------download---下载失败----->");
				out.println("{\"success\": true,\"message\": \"下载失败.\"}");
			}
			return;
		}
		// .查询所有文件 queryAll
		if ("queryAll".equals(opt)) {
			String page = request.getParameter("page");
			String rows = request.getParameter("rows");
			if (StringUtil.isNotEmpty(f_id)) {
				file.setF_id(f_id);
			}
			if (StringUtil.isNotEmpty(f_name)) {
				file.setF_name(f_name);
			}
			JSONObject result = new JSONObject();
			PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
			list = ifile.queryAllFiles(pageBean, file);
			// 查询总记录数
			int total = ifile.FileCount(file);
			// 传给前台jsonarray
			JSONArray jsonArray = JSONArray.fromObject(list);
			result.put("total", total);
			result.put("rows", jsonArray);
			System.out.println(result.toString());
			out.print(result);

			return;
		}

		// .删除 del
		if ("del".equals(opt)) {
			// 获取前端页面的id集合
			String delIds = request.getParameter("delIds");

			System.out.println("delIds--->" + delIds);
			JSONObject result = new JSONObject();
			int delNums = ifile.FileDelete(delIds);
			if (delNums > 0) {
				result.put("success", true);
				result.put("delNums", delNums);
			} else {
				result.put("errorMsg", "删除失败");
			}

			out.print(result);
			return;
		}
		// findById
		String flag = "1";// 可用
		if ("findById".equals(opt)) {
			// "" null
			if (StringUtil.isNotEmpty(f_id)) {
				file.setF_id(f_id);
			}
			Files file1 = null;
			file1 = ifile.findByIdFiles(file);
			if (file1 != null) {
				flag = "-1";
			}
			System.out.println("flag-->" + flag);
			out.print(flag);

		}
		
          return;
	}

}
