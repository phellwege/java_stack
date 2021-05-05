package com.peter.code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class CodeController {
    @RequestMapping("/")
    public String index() {
        return "index.jsp";
    }
    
    @RequestMapping("/code")
    public String code() {
        return "code.jsp";
    }

    @RequestMapping(value="/codeword", method=RequestMethod.POST)
    public String codeword(@RequestParam(value="codeattempt") String codeattempt, 
    			RedirectAttributes redirectAttributes) {
		if (codeattempt.equals("bushido")) {
            return "redirect:/code";
        }
		else {
            redirectAttributes.addFlashAttribute("error", "You must train harder!");
            return "redirect:/";
		}
    }
}