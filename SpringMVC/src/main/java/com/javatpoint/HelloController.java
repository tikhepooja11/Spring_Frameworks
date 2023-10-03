package com.javatpoint;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
@Controller  
public class HelloController {  
@RequestMapping("/hello")  
    public String redirect()  
    {  
		System.out.println("hello pooja you are here");
        return "viewpage";  
    }     
@RequestMapping("/helloagain")  
public String display()  
{  
    return "final";  
}  
}  
