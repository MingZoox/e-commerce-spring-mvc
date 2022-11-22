package com.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.Product;
import com.entity.Receipt;
import com.entity.ReceiptItem;
import com.model.Cart;
import com.service.CategoryService;
import com.service.ProductService;
import com.service.ReceiptItemService;
import com.service.ReceiptService;

@Controller
@RequestMapping(value = "cart")
public class ControllerCart {
	@Autowired
	private ProductService productService;

	@Autowired
	private ReceiptItemService receiptItemService;

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value = "add/{productId}", method = RequestMethod.GET)
	public String viewAdd(ModelMap mm, HttpSession session, @PathVariable("productId") long productId) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}
		Product product = productService.findById(productId);
		if (product != null) {
			if (cartItems.containsKey(productId)) {
				Cart item = cartItems.get(productId);
				item.setQuantity(item.getQuantity() + 1);
				cartItems.put(productId, item);
			} else {
				cartItems.put(productId, new Cart(product, 1));
			}
		}

		int totalPrice = 0;
		for (Cart cart : cartItems.values()) {
			totalPrice += cart.getProduct().getProductPrice() * cart.getQuantity();
		}

		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartTotal", totalPrice);
		session.setAttribute("myCartNum", cartItems.size());
		mm.put("listCategory", categoryService.getAll());
		return "pages/cart";
	}

	@RequestMapping(value = "remove/{productId}", method = RequestMethod.GET)
	public String viewRemove(ModelMap mm, HttpSession session, @PathVariable("productId") long productId) {
		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}
		if (cartItems.containsKey(productId)) {
			cartItems.remove(productId);
		}
		int totalPrice = 0;
		for (Cart cart : cartItems.values()) {
			totalPrice += cart.getProduct().getProductPrice() * cart.getQuantity();
		}
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartTotal", totalPrice);
		session.setAttribute("myCartNum", cartItems.size());

		mm.put("listCategory", categoryService.getAll());
		return "pages/cart";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.GET)
	public String checkoutView(ModelMap mm) {
		mm.addAttribute("receipt", new Receipt());
		mm.put("listCategory", categoryService.getAll());
		return "pages/checkout";
	}

	@RequestMapping(value = "checkout", method = RequestMethod.POST)
	public String viewCheckout(ModelMap mm, HttpSession session, @ModelAttribute("receipt") @Valid Receipt receipt,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			mm.addAttribute("receipt", new Receipt());
			mm.put("listCategory", categoryService.getAll());
			return "pages/checkout";
		}

		HashMap<Long, Cart> cartItems = (HashMap<Long, Cart>) session.getAttribute("myCartItems");
		if (cartItems == null) {
			cartItems = new HashMap<Long, Cart>();
		}

		receipt.setReceiptDate(new Timestamp(new Date().getTime()));
		receipt.setReceiptStatus(true);
		receiptService.create(receipt);

		for (Cart cart : cartItems.values()) {
			ReceiptItem receiptItem = new ReceiptItem();
			receiptItem.setReceipt(receipt);
			receiptItem.setProduct(cart.getProduct());
			receiptItem.setReceiptItemPrice(cart.getProduct().getProductPrice());
			receiptItem.setReceiptItemSale(cart.getProduct().getProductSale());
			receiptItem.setReceiptItemQuantity(cart.getQuantity());
			receiptItem.setReceiptItemStatus(true);
			receiptItemService.create(receiptItem);
		}

		cartItems = new HashMap<Long, Cart>();
		session.setAttribute("myCartItems", cartItems);
		session.setAttribute("myCartTotal", 0);
		session.setAttribute("myCartNum", 0);

		mm.put("listCategory", categoryService.getAll());
		return "pages/success";
	}
}
