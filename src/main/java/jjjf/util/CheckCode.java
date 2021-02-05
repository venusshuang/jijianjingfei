package jjjf.util;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CheckCode {
	
	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 80;//宽
	public static final int HEIGHT = 20;//高

	@RequestMapping("CheckCode")
	public void getCheckCode(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获得内存图形对象(宽，高，图像类型)
		BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
		//获取画笔
		Graphics g = image.getGraphics();
		//设置背景色
		getBackgroundColor(g);
		//设置边框
		getBorder(g);
		//画干扰线
		drawLine(g);
		//写入随机数
		drawNum(g,request);
		//写给浏览器 ,并且让浏览器以图形方式打开
		response.setContentType("image/jpeg");
		//禁止浏览器缓存
		response.setDateHeader("expires", -1);
		response.setHeader("Pragma", "no-cache");
		ImageIO.write(image, "jpg", response.getOutputStream());
		/*
		 * 如果需要浏览器缓存，在expires后添加long类型参数，单位是毫秒
		 * 但是要记住要用当前时间+long值，才能表示从当前时间后的long毫秒 一直有缓存
		 * */
	}

//
	private void drawNum(Graphics g,HttpServletRequest request) {
		g.setColor(Color.RED);
		g.setFont(new Font("SimSun",Font.BOLD,15));
		String chs = "123456789";
		int y = 10;
		String sb = "";

		
		for(int x=0;x<4;x++){
			String ch =chs.charAt(new Random().nextInt(chs.length()))+"";
			g.drawString(ch,y,15);
			y+=20;
			sb+=ch.toString();
		}
		HttpSession session = request.getSession();
		session.setAttribute("checkcode", sb);

	}

	private void drawLine(Graphics g) {
		g.setColor(Color.BLUE);
		for(int i=0;i<4;i++){
			int x1 = new Random().nextInt(WIDTH);
			int y1 = new Random().nextInt(HEIGHT);
			int x2 = new Random().nextInt(WIDTH);
			int y2 = new Random().nextInt(HEIGHT);
			g.drawLine(x1, y1, x2, y2);
		}
	}

	private void getBorder(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(1, 1, WIDTH-2, HEIGHT-2);
	}
	
	private void getBackgroundColor(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, WIDTH, HEIGHT); 
	}


}
