package com.test.security.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.security.service.EmployeeServiceI;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeServiceI employeeService;
	
	private static StringBuffer welcomeMessage = new StringBuffer("Welcome, You are now logged in : ");
	

	@RequestMapping(value="/welcomeData", method = RequestMethod.GET, produces="application/json")
	@ResponseBody
    public Map<String, Object> loginSuccess(HttpSession httpSession, Principal principal,Map<String, Object> model) {
		HashMap<String, Object> map = new HashMap<String, Object>();
	    map.put("message", welcomeMessage.append(principal.getName()));
	    return map;        
    }
	
    @RequestMapping(value="/storeInTime", method = RequestMethod.POST, produces="application/json")
    @ResponseBody
    public Map<String, Object> punchInTime(HttpSession httpSession, Principal principal) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	String time ="";
    	if((time=employeeService.storeTime("1", "inTime"))!=null){
    		map.put("message","Time stored successfully at : "+time);
    	}else{
    		map.put("message","Time not stored successfully");
    	}
    	return map;
        
    }
    @RequestMapping(value="/storeOutTime", method = RequestMethod.POST, produces="application/json")
    public Map<String, Object> punchOutTime(HttpSession httpSession, Principal principal) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
    	String time ="";
    	if( (time = employeeService.storeTime("1", "outTime"))!=null){
    		map.put("message","Time stored successfully at : "+time);
    	}else{
    		map.put("message","Time not stored successfully");
    	}
    	return map;
    }
    @RequestMapping(value="/breakStartTime", method = RequestMethod.GET)
    public String breakStartTime(HttpSession httpSession, Principal principal) {
    	employeeService.breakStartTime(httpSession);
		return "break time started";
        
    }
    @RequestMapping(value="/breakStopTime", method = RequestMethod.GET)
    public String breakStopTime(HttpSession httpSession, Principal principal) {
    	employeeService.breakStopTime(httpSession);
		return "break time stoped";
        
    }
    @RequestMapping(value="/getTotalPauseTime", method = RequestMethod.GET)
    public String showPauseTime(HttpSession httpSession, Principal principal) {
    	employeeService.getTotalPauseTime(httpSession);
		return "break time stoped";
        
    }
}
@Controller
class EmployeeMvcContoller{
	@RequestMapping(value="/welcome", method = RequestMethod.GET)
    public String loginSuccess() {
			return "home";
        
    }
}