package com.eval.coronakit.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eval.coronakit.dao.ProductMasterDao;
import com.eval.coronakit.entity.Item;
import com.eval.coronakit.entity.User;
import com.eval.coronakit.service.ItemService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ItemService itemService;

	@Autowired
	ProductMasterDao productMasterDao;

	@GetMapping("/list")
	public String home(HttpServletRequest servletRequest, @RequestParam("uName") String uName,
			@RequestParam("pwd") String pwd) {
		try {
			init();
			System.out.println(uName);
			System.out.println(pwd);
			if (!(uName.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("admin"))) {
				return "errorPage";
			}
			List<com.eval.coronakit.entity.Item> items = itemService.getAllItems();
			servletRequest.setAttribute("items", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listproducts";
	}

	public void init() {
		String jdbcURL = "jdbc:mysql://localhost/sayalidb";
		String jdbcUsername = "root";
		String jdbcPassword = "root";

		productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
		productMasterDao.getConnection();
	}

	@RequestMapping("/add-product")
	public String addProduct() {
		return "newproduct";
	}

	@RequestMapping("/newItem")
	public String newItem(HttpServletRequest request) {
		Item item = new Item();
		request.setAttribute("item", item);
		return "itemFormPage";
	}

	@RequestMapping("/new-user")
	public String newUser(HttpServletRequest request) {
		return "newuser";
	}

	@RequestMapping("/showProductsToAdd")
	public String showProductsToAdd(HttpServletRequest request) {
		return "showproductstoadd";
	}

	@RequestMapping("/ordersummary")
	public String showKit(HttpServletRequest request) {
		return "ordersummary";
	}

	@RequestMapping("/editItem")
	public String editItem(HttpServletRequest request) {
		int icode = Integer.parseInt(request.getParameter("icode"));
		String view = "";

		try {
			Item item = itemService.getItemById(icode);
			request.setAttribute("item", item);
			view = "editProduct";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/saveItem")
	public String saveItem(HttpServletRequest request) {

		Item item = new Item();

		item.setId(Integer.parseInt(request.getParameter("icode")));
		item.setTitle(request.getParameter("title"));
		item.setUnit(request.getParameter("unit"));
		item.setPrice(Integer.parseInt(request.getParameter("price")));

		String view = "";

		try {
			itemService.validateAndSave(item);
			request.setAttribute("msg", "Item Got Saved!");
			view = "list";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage";
		}
		return view;

	}

	@RequestMapping("/addUser")
	private String addUser(HttpServletRequest request) {
		User user = new User();

		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setAddress(request.getParameter("address"));
		user.setPhone(Integer.parseInt(request.getParameter("phone")));

		String view = "";

		try {
			itemService.insertUserDetail(user);
			request.setAttribute("msg", "Item Got Added!");
			view = "showList";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage";
		}
		return view;
	}

	@RequestMapping("/showList")
	private String showListToUser(HttpServletRequest request, HttpServletResponse response) {

		List<Item> items;
		try {
			addUser(request);
			items = itemService.getAllItems();
			request.setAttribute("items", items);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "showproductstoadd";

	}

	@GetMapping("/deleteItem")
	public String productEntry(HttpServletRequest request, @RequestParam("icode") String iCode) {

		int icode = Integer.parseInt(iCode);
		String view = "";

		try {
			itemService.deleteItem(icode);
			request.setAttribute("msg", "Item Got Deleted!");
			List<com.eval.coronakit.entity.Item> items = itemService.getAllItems();
			request.setAttribute("items", items);
			view = "listproducts";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/showUserDetails")
	public String showUserDetailsOnKitPage(HttpServletRequest request) {
		String view = "";
		try {
			User user = itemService.getUserDetails();
			request.setAttribute("user", user);
			view = "showkit";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage";
		}
		return view;
	}

	@RequestMapping("/placeorder")
	private String placeUserOrder(HttpServletRequest request) {
		try {
			String[] selections = request.getParameterValues("selection");
			Set<String> set = new HashSet<String>(Arrays.asList(selections));
			List<Item> selItemList = itemService.getAllItems();
			List<Item> items = new ArrayList<Item>();
			for (Item item : selItemList) {
				Integer id = item.getId();
				if (id != null && set.contains(id.toString())) {
					items.add(item);
				}

			}
			User user = itemService.getUserDetails();
			request.setAttribute("user", user);
			request.setAttribute("items", items);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "showkit";
	}

	@PostMapping("/addItem")
	public String productSave(HttpServletRequest request, @RequestParam("icode") String iCode) {
		Item item = new Item();

		item.setId(Integer.parseInt(iCode));
		item.setTitle(request.getParameter("title"));
		item.setUnit(request.getParameter("unit"));
		item.setPrice(Integer.parseInt(request.getParameter("price")));

		String view = "";

		try {
			itemService.validateAndAdd(item);
			request.setAttribute("msg", "Item Got Added!");
			List<com.eval.coronakit.entity.Item> items = itemService.getAllItems();
			request.setAttribute("items", items);
			view = "listproducts";
		} catch (Exception e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errPage.jsp";
		}
		return view;
	}

	@GetMapping("/product-list")
	public String productList(Model model) {
		return null;
	}

	@GetMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId) {
		return null;
	}

}
