package cn.itsource.ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itsource.ssm.mapper.ProductMapper;

@Controller
public class ProductController {

	@Autowired
	private ProductMapper productMapper;

	@RequestMapping("/list")
	public String list(Model model) {
		// 传到前台
		model.addAttribute("products", productMapper.getAll());
		System.out.println("5555555555555555555555555555555555555555555555555555");
		// 进行跳转
		return "list";
	}

}
