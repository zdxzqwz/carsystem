package com.it.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it.bean.Files;
import com.it.global.IFiles;
import com.it.services.FilesImpl;
import com.it.utils.Base64Util;
import com.it.utils.StringUtil;

/**
 * Servlet implementation class DownLoadServlet
 */
@WebServlet({ "/DownLoadServlet", "/down.do" })
public class DownLoadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownLoadServlet() {
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

		// 2.获取页面信息
		String opt = request.getParameter("opt");

		// 3.生成对象
		// PrintWriter out = response.getWriter();
		Files file = new Files();
		IFiles ifile = new FilesImpl();

		// 4.执行
		if ("download".equals(opt)) {
			// response.reset();
			// 获取下载rows的f_id集合
			String delIds = request.getParameter("delIds");
			System.out.println("delIds--->" + delIds);
			if (StringUtil.isNotEmpty(delIds)) {
				file.setF_id(delIds);
			}
			Files file1 = null;
			file1 = ifile.findByIdFiles(file);
			if (file1 != null) {
				System.out.println("-----download----servlet" + file1);
				String fileName = file1.getF_name();
				String filePath = file1.getF_path();
				System.out.println("----下载路径为------>" + filePath);
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
				// PrintWriter out = new PrintWriter(out1);

				byte b[] = new byte[1024 * 5];

				while ((in.read(b)) != -1) {

					out1.write(b);

				}

				out1.flush();
				out1.close();
				in.close();
			} else {
				System.out.println("------download---下载失败----->");

			}
			return;
		}
	}

}
