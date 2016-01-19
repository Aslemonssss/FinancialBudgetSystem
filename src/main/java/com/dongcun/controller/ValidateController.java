package com.dongcun.controller;

import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dongcun.bean.ValidateModel;

@Controller
@RequestMapping(value = "/validate")
public class ValidateController {
	
	@RequestMapping(value="/test.do", method = {RequestMethod.GET})
	public String test(Model model){

		if(!model.containsAttribute("contentModel")){
			ValidateModel aaa=new ValidateModel();
			//aaa.setName("HHHHH");
            model.addAttribute("contentModel", aaa);
        }
		return "validatetest";
	}
	
	@RequestMapping(value="/test", method = {RequestMethod.POST})
	public String test(Model model, @Valid @ModelAttribute("contentModel") ValidateModel validateModel, BindingResult result) throws NoSuchAlgorithmException{
		
		//如果有验证错误 返回到form页面
        if(result.hasErrors())
            return test(model);
    	return "validatesuccess"; 	
	}
	
}
