package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Member;
import com.service.CategoryService;
import com.service.MemberService;
import com.service.ProductService;

@Controller
@RequestMapping(value = "")
public class ControllerManages {
	@Autowired
	MemberService memberService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String viewLogin(ModelMap mm, @RequestParam(value = "msg", required = false) String msg) {
		if (msg != null)
			mm.put("msg", "The username or password is incorrect!");
		mm.put("member", new Member());
		return "manages/login";
	}

	@RequestMapping(value = "cart/loginsuccess", method = RequestMethod.GET)
	public String loginSuccess(ModelMap mm, HttpSession session) {
		Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = ((UserDetails) userDetails).getUsername();
		Member mb = memberService.login(username, "");
		session.setAttribute("myLogin", mb);

		mm.put("listCategory", categoryService.getAll());
		mm.put("listProductFeatured", productService.getListFeatured(8));
		mm.put("listProductSale", productService.getListSale(8));
		return "pages/index";
	}

	@RequestMapping(value = "manages/home", method = RequestMethod.GET)
	public String viewLogin() {
		return "manages/index";
	}

	@RequestMapping(value = "error", method = RequestMethod.GET)
	public String viewError() {
		return "error/error404";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(ModelMap mm, HttpSession session) {
		session.removeAttribute("myLogin");

		mm.put("listCategory", categoryService.getAll());
		mm.put("listProductFeatured", productService.getListFeatured(8));
		mm.put("listProductSale", productService.getListSale(8));
		return "pages/index";
	}
}
