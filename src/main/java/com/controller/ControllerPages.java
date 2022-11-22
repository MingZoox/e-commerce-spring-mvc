package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Contact;
import com.service.CategoryService;
import com.service.ProductService;

@Controller
@RequestMapping(value = "")
public class ControllerPages {

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping(value = "home", method = RequestMethod.GET)
	public String viewHome(ModelMap mm) {
		mm.put("listCategory", categoryService.getAll());
		mm.put("listProductFeatured", productService.getListFeatured(8));
		mm.put("listProductSale", productService.getListSale(8));
		return "pages/index";
	}

	@RequestMapping(value = "category/{categoryId}", method = RequestMethod.GET)
	public String viewCategory(ModelMap mm, @PathVariable("categoryId") long categoryId) {
		mm.put("listCategory", categoryService.getAll());
		mm.put("listProduct", productService.getListByCategory(categoryId));
		return "pages/shop";
	}

	@RequestMapping(value = "product/{productId}", method = RequestMethod.GET)
	public String viewProduct(ModelMap mm, @PathVariable("productId") long productId) {
		mm.put("listCategory", categoryService.getAll());
		mm.put("product", productService.findById(productId));
		mm.put("listProductFeatured", productService.getListFeatured(3));
		mm.put("listProductSale", productService.getListSale(2));
		return "pages/single";
	}

	@RequestMapping(value = "contact", method = RequestMethod.GET)
	public String viewContact(ModelMap mm) {
		mm.put("listCategory", categoryService.getAll());
		return "pages/contact";
	}

	@RequestMapping(value = "sendcontact", method = RequestMethod.POST)
	public void sendContact(@RequestBody Contact contact) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom(contact.getEmail());
		mailMessage.setTo("nguyenvanminhvu@gmail.com");
		mailMessage.setText(contact.getName()+"\n"+contact.getEmail()+"\n"+contact.getMessage());
		mailMessage.setSubject(contact.getSubject());
		javaMailSender.send(mailMessage);
	}
	

}