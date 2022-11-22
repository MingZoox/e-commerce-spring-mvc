package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.service.CategoryService;
import com.service.ProductService;

@Controller
@RequestMapping(value = "manages/product")
public class ControllerProductManage {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;

	@RequestMapping(value = "list/{page}", method = RequestMethod.GET)
	public String viewProductListByPage(ModelMap mm, HttpSession session,
			@PathVariable(name = "page", required = false) Integer page) {
		if (page == null) {
			page = 1;
		}
		mm.put("listProduct", productService.getListNav((page - 1) * 8, 8));
		mm.put("totalItem", productService.totalItem() / 8);
		mm.put("curIndex", page);
		return "manages/product_list";
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String viewProductNew(ModelMap mm) {
		mm.put("product", new Product());
		mm.put("listCategory", categoryService.getAll());
		return "manages/product_form";
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String viewProductSave(ModelMap mm, @ModelAttribute("product") Product product) {
//			@RequestParam(name = "attachment",required = false) MultipartFile file) throws IOException {

//		File newFile = new File(
//				"C:\\Users\\Administrator\\eclipse-workspace\\java\\src\\main\\webapp\\resources\\pages\\images\\"
//						+ file.getOriginalFilename());
//		FileOutputStream fileOutputStream = new FileOutputStream(newFile);
//		fileOutputStream.write(file.getBytes());
//		fileOutputStream.close();
//
//		product.setProductImage(file.getOriginalFilename());
		
		if (product.getProductId() == 0) {
			productService.create(product);
		} else {
			productService.update(product);
		}
		mm.put("product", product);
		mm.put("listCategory", categoryService.getAll());
		return "manages/product_form";
	}

	@RequestMapping(value = "edit/{productId}", method = RequestMethod.GET)
	public String viewProductSave(ModelMap mm, @PathVariable("productId") int productId) {
		mm.put("product", productService.findById(productId));
		mm.put("listCategory", categoryService.getAll());
		return "manages/product_form";
	}

	@RequestMapping(value = "remove/{productId}", method = RequestMethod.GET)
	public String viewProductRemove(ModelMap mm, @PathVariable("productId") int productId) {
		Product p = productService.findById(productId);
		if (p != null) {
			productService.delete(p);
		}
		mm.put("listProduct", productService.getListNav(0, 10));
		mm.put("totalItem", productService.totalItem() / 10);
		return "manages/product_list";
	}
}
