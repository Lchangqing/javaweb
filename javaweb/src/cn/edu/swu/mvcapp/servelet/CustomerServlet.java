package cn.edu.swu.mvcapp.servelet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.swu.mvcapp.dao.CriteriaCustomer;
import cn.edu.swu.mvcapp.dao.CustomerDAO;
import cn.edu.swu.mvcapp.dao.factory.CustomerDAOFactory;
import cn.edu.swu.mvcapp.domain.Customer;

/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/customerservlet" })
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDAO customerdao=CustomerDAOFactory.getInstance().getCustomerDAO();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	/*
	 * protected void doPost(HttpServletRequest request, HttpServletResponse
	 * response) throws ServletException, IOException { // TODO Auto-generated
	 * method stub String method=request.getParameter("method"); switch (method) {
	 * case "add":add(request,response); break; case
	 * "query":query(request,response); break; case
	 * "delete":delete(request,response); break;
	 * 
	 * default: break; } }
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse
			 response) throws ServletException, IOException {
		 //1.获取servletpath:/edit.do或add.do
		 String servletpath=request.getServletPath();
		 
		 //2.去除/和.do，得到类似于edit或add这样的字符串
		 String methodname=servletpath.substring(1,servletpath.length()-3);
		 try {
			 //3.利用放射获取methodName对应大方法
			Method method=getClass().getDeclaredMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, request,response);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			 response.sendRedirect("error.jsp");
			e.printStackTrace();
		} 
	 }
	 private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. 获取表单参数
		 String id=request.getParameter("id");
		String name=request.getParameter("name");
		String oldName=request.getParameter("oldName");
		 System.out.println("oldname:"+oldName+"   newname:"+name);
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		 System.out.println("customersevlet 69");
		/*2.检验name是否已经被占用
		 * 2.1 比较name和oldname是否相同，相同说明可用
		 * 2.2 若不相同，则用csteromerdao的getcountwithname(string name)获取名字在数据库中是否存在
		 * 2.3 若相同。。。。
		 * */
		if(!oldName.equalsIgnoreCase(name)) {
			long count=customerdao.getCountWithName(name);
			if(count>0) {
				request.setAttribute("message", "用户名"+name+"已经被占用，请重新选择");
				request.getRequestDispatcher("/updatecustomer.jsp").forward(request, response);
				return;
			}
		}
		Customer customer=new Customer(name,address,phone);
		customer.setId(Integer.parseInt(id));
		customerdao.update(customer);
		response.sendRedirect("query.do");
		
	 }
	 private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		 
		 String forwardPath="/error.jsp";
		 //1.获取请求参数id
		 String idstr=request.getParameter("id");
		 int id=-1;
		 //2.调用customerdao的customerdao。getid(id)获取和id对应的customer对象
		 try {
			 Customer customer=customerdao.get(Integer.parseInt(idstr));
			 System.out.println("------99:"+customer.getName());
			 if(customer!=null) {
				 forwardPath="/updatecustomer.jsp";
				 request.setAttribute("customer",customer);
			 }
		} catch (Exception e) { System.out.println("customersevlet 103");}
		 //4.响应update customer.jsp
		 request.getRequestDispatcher(forwardPath).forward(request, response);
		 System.out.println("customersevlet 106");
		} 
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String idStr=request.getParameter("id");
			int id=0;
			/*
			 * try...cath的作用，防止idstr不能转为int型
			 * 若不能，则id=0，无法进行删除操作
			 * */
			try {
				id=Integer.parseInt(idStr);
		        customerdao.delete(id);
			} catch (Exception e) {
				
			}
			response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//获取模糊查询的请求参数
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		System.out.println("----------过来了");
		//把请求参数封装为一个criteriacustomer对象
		CriteriaCustomer cc=new CriteriaCustomer(name,address,phone);
		
		System.out.println("----------134");
		//1.调用customerDAO的getForListWithCriteriaCustomer方法得到customer集合
		List<Customer>customers=customerdao.getForListWithCriteriaCustomer(cc);
		//2.把customer的集合放入request中
		request.setAttribute("customers", customers);
		//3.转发页面到index.jsp，不能使用重定向
		System.out.println("----------140");
		request.getRequestDispatcher("/operate.jsp").forward(request, response);
		System.out.println("query");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. 获取表单参数
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		/*2.检验name是否已经被占用
		 * 	2.1调用customerDAO的getcountwithname(string name)获取name在数据库中是否存在
		 * 	2.2 若返回值大于0，则响应newcustomer.jsp页面：(通过转发来响应)
		 * 		2.2.1要求在newcustomer.jsp页面显示一个错误消息：用户名已经被占用，请重新选择
		 * 			在request中放入也给属性message:用户名name已经被占用，请重新选择
		 * 			在页面通过request.getAttribute("message")的方式来显示
		 * 		2.2.2 newcustomer.jsp的表单可以回显
		 * 			回显方式：alue="<%=request.getParameter("name")==null? "":request.getParameter("name") %>"
		 * 		2.2.3 结束方式return
		 * */
		long count=customerdao.getCountWithName(name);
		System.out.println("------准备判断");
		if(count>0) {
			System.out.println("-----进if");
			request.setAttribute("message","name "+name+" already be used，please try another one~~");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}else if(name=="" || address=="" || phone=="") {
			System.out.println("-----进 else if");
			request.setAttribute("message","it cannot be null here~~");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
		}else {
		//2.把表单参数封装为也给customer对象
		Customer customer=new Customer(name,address,phone);
		//3.调用customerDAO的save(customer customer),执行保存操作
		customerdao.save(customer);
		//4.重定向转发页面到index.jsp,如果使用转发的话会发生表单的重复提交
		response.sendRedirect("operate.jsp");
		}
	}

}
