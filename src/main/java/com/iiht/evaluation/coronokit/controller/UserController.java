package com.iiht.evaluation.coronokit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iiht.evaluation.coronokit.dao.KitDao;
import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.CoronaKit;
import com.iiht.evaluation.coronokit.service.GlobalService;

@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private KitDao kitDAO;
	private ProductMasterDao productMasterDao;
	private GlobalService globalService = new GlobalService();

	public void setKitDAO(KitDao kitDAO) {
		this.kitDAO = kitDAO;
	}

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");

		this.kitDAO = new KitDao(jdbcURL, jdbcUsername, jdbcPassword);
		this.productMasterDao = new ProductMasterDao(jdbcURL, jdbcUsername, jdbcPassword);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");

		String viewName = "";
		try {
			switch (action) {
			case "newuser":
				viewName = showNewUserForm(request, response);
				break;
			case "insertuser":
				viewName = insertNewUser(request, response);
				break;
			case "showproducts":
				viewName = showAllProducts(request, response);
				break;
			case "addnewitem":
				viewName = addNewItemToKit(request, response);
				break;
			case "deleteitem":
				viewName = deleteItemFromKit(request, response);
				break;
			case "showkit":
				viewName = showKitDetails(request, response);
				break;
			case "placeorder":
				viewName = showPlaceOrderForm(request, response);
				break;
			case "saveorder":
				viewName = saveOrderForDelivery(request, response);
				break;
			case "ordersummary":
				viewName = showOrderSummary(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			default:
				viewName = "notfound.jsp";
				break;
			}
		} catch (Exception ex) {

			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);

	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		globalService.updateKart(pid);
		request.setAttribute("kits", globalService.viewCart());
	
		return "showkit.jsp";
	}

	private String showOrderSummary(HttpServletRequest request, HttpServletResponse response) {
		String add = request.getParameter("add");
		request.setAttribute("ordersummary", (int)(Math.random() * 100) + 10);
		return "ordersummary.jsp";
	}

	private String saveOrderForDelivery(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showPlaceOrderForm(HttpServletRequest request, HttpServletResponse response) {
		return "placeorder.jsp";
	}

	private String showKitDetails(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("kits", globalService.viewCart());
		return "showkit.jsp";
	}

	private String deleteItemFromKit(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("kits", globalService.viewCart());
		return "updateorder.jsp";
	}

	private String addNewItemToKit(HttpServletRequest request, HttpServletResponse response) {
		String pid = request.getParameter("pid");
		String quantity = request.getParameter("quantity");
		globalService.addProductToCart(pid, quantity);
		
		request.setAttribute("products", globalService.getAllProducts());
		return "showproductstoadd.jsp";
	}

	private String showAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String insertNewUser(HttpServletRequest request, HttpServletResponse response) {
		String pname = request.getParameter("pname");
		String pemail = request.getParameter("pemail");
		String pcontact = request.getParameter("pcontact");
		globalService.addUsers(pname, pemail, pcontact);
		request.setAttribute("products", globalService.getAllProducts());
		return "showproductstoadd.jsp";
	}

	private String showNewUserForm(HttpServletRequest request, HttpServletResponse response) {
		return "newuser.jsp";
	}
}