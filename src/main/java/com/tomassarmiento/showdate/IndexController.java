package com.tomassarmiento.showdate;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class IndexController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		LocalDateTime locaDate = LocalDateTime.now();
		int hours  = locaDate.getHour();
		int minutes = locaDate.getMinute();	
		String a = "";
		if(hours<12) {
			a = "AM";
		}
		else {
			a = "PM";
		}
		model.addAttribute("time", ""+hours+":"+minutes+" "+a);
		return "time.jsp";
	}
	
	@RequestMapping("/date")
	public String date(Model model) {
		Date objDate = new Date();
		SimpleDateFormat format1 = new SimpleDateFormat("EEEEE dd");
		SimpleDateFormat format3 = new SimpleDateFormat("MMMM, yyyy");
		String date = ""+format1.format(objDate)+" de "+format3.format(objDate)+"";
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	
}
