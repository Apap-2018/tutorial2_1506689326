package com.example.demo.controller;

import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PageController {
	
	@RequestMapping("/viral")
	public String index(){
		return "viral";
	}
	
	@RequestMapping("/challenge") 
    public String challenge(@RequestParam(value = "name") String name, Model model) { 
     model.addAttribute("name", name); 
     return "challenge"; 
    }
	
	
	@RequestMapping(value= {"/challenge","challenge/{name}"})
	public String challengePath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()){
			model.addAttribute("name", name.get());
		}else{
			model.addAttribute("name", "KB");
		}
		return "challenge";
	}

	

	@RequestMapping("/generator")
	public String viralGenerator (@RequestParam(value="a", defaultValue="0" ) int a, @RequestParam(value="b", defaultValue="0" ) int b, Model model) {
		
		model.addAttribute("A", a);
		model.addAttribute("B", b);
			
			String Outputdefault = "h";	
			String OutputBanyak = "";
			
			
			//untuk nilai input a = 0
			if(a == 0) {
				Outputdefault= "hm";			
			}
			
			//untuk nilai input b = 0
			if(b == 0) {
				OutputBanyak = Outputdefault;			
			}
			
			//untuk nilai input a  > 0
			for (int i = 0; i < a; i++) {
				Outputdefault += "m";
			}
			
			//untuk nilai input b >0
			for(int j = 0; j < b; j++) {
				OutputBanyak += Outputdefault + " "; 
			};
			
				
		model.addAttribute("OutputHm", OutputBanyak);
		
		return "generator";
	}
	
	


}
