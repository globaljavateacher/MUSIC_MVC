package com.music.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import com.music.bean.Music;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MusicService {
	
	@SuppressWarnings("unchecked")
	public static void regist(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("MusicService.regist");
		Music music = new Music();
		music.setKey(UUID.randomUUID().toString());
		music.setTitle(req.getParameter("title"));
		music.setVocal(req.getParameter("vocal"));
		music.setReleaseComp(req.getParameter("releaseComp"));
		music.setReleaseDate(req.getParameter("releaseDate"));
		music.setCreateDate(new Date());
		ArrayList<Music> musicList = (ArrayList<Music>) req.getServletContext().getAttribute("musicList");
		musicList.add(music);
	}

}
