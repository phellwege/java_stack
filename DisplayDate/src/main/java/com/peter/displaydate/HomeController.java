package com.peter.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}

	@RequestMapping("/date")
	public String date(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, yyyy");
		String date = format.format(new Date());
		model.addAttribute("date", date);
		return "date.jsp";
	}
	
	@RequestMapping("/time")
	public String time(Model model) {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm a");
		String date = format.format(new Date());
		model.addAttribute("time", date);
		return "Time.jsp";
	}
}
