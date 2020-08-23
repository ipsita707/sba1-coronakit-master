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

import com.iiht.evaluation.coronokit.dao.ProductMasterDao;
import com.iiht.evaluation.coronokit.model.ProductMaster;
import com.iiht.evaluation.coronokit.service.GlobalService;

@WebServlet("/admin")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;
	private GlobalService globalService = new GlobalService();

	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");

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
			case "login":
				viewName = adminLogin(request, response);
				break;
			case "newproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "list":
				viewName = listAllProducts(request, response);
				break;
			case "logout":
				viewName = adminLogout(request, response);
				break;
			case "adminSuccess":
				viewName = adminSuccess(request, response);
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

	private String adminSuccess(HttpServletRequest request, HttpServletResponse response) {
		return "adminSuccess.jsp";
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", globalService.getAllProducts());
		return "listproducts.jsp";
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) {
	
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");
		String pcost = request.getParameter("pcost");
		String pdesc = request.getParameter("pdesc");
		globalService.updateProduct(pid, pname, pcost, pdesc);
		request.setAttribute("products", globalService.getAllProducts());
		return "listproducts.jsp";
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", globalService.getAllProducts());
		return "editproduct.jsp";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) {
		String pname = request.getParameter("pname");
		String pcost = request.getParameter("pcost");
		String pdesc = request.getParameter("pdesc");
		globalService.addProducts(pname,pcost, pdesc);
		return "adminSuccess.jsp";
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		return "newproduct.jsp";
	}

	private String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("loginid");
		String userPassword = request.getParameter("password");

		if ("admin".equalsIgnoreCase(userName) && "admin".equalsIgnoreCase(userPassword)) {
			return "adminSuccess.jsp";
		} else {
			return "errorPage.jsp";
		}
	}

}