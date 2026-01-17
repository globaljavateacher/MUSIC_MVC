package com.music.servlet;

import java.io.IOException;

import com.music.common.Constants;
import com.music.controller.MusicController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MusicServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath();
		System.out.println("MusicServlet:" + uri);
		String view = null;
		if ( "/MUSIC_MVC/music/form.ms".equals(uri) ) {
			view = MusicController.form(req, resp);
		}
		if ( "/MUSIC_MVC/music/regist.ms".equals(uri) ) {
			view = MusicController.regist(req, resp);
		}
		if ( "/MUSIC_MVC/music/list.ms".equals(uri) ) {
			view = MusicController.list(req, resp);
		}
		if ( null == view ) {
			req.getRequestDispatcher(Constants.VIEW_PRE_FIX + "/error/no_page" + Constants.VIEW_POST_FIX).forward(req, resp);
		} else {
			if ( view.startsWith("redirect:") ) {
				resp.sendRedirect(contextPath + view.replace("redirect:", ""));
			} else {
				req.getRequestDispatcher(Constants.VIEW_PRE_FIX + view + Constants.VIEW_POST_FIX).forward(req, resp);
			}
		}
	}
}
