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
		 //1.��ȡservletpath:/edit.do��add.do
		 String servletpath=request.getServletPath();
		 
		 //2.ȥ��/��.do���õ�������edit��add�������ַ���
		 String methodname=servletpath.substring(1,servletpath.length()-3);
		 try {
			 //3.���÷����ȡmethodName��Ӧ�󷽷�
			Method method=getClass().getDeclaredMethod(methodname, HttpServletRequest.class,HttpServletResponse.class);
			//4.���÷�����ö�Ӧ�ķ���
			method.invoke(this, request,response);
		 } catch (Exception e) {
			// TODO Auto-generated catch block
			 response.sendRedirect("error.jsp");
			e.printStackTrace();
		} 
	 }
	 private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. ��ȡ������
		 String id=request.getParameter("id");
		String name=request.getParameter("name");
		String oldName=request.getParameter("oldName");
		 System.out.println("oldname:"+oldName+"   newname:"+name);
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		 System.out.println("customersevlet 69");
		/*2.����name�Ƿ��Ѿ���ռ��
		 * 2.1 �Ƚ�name��oldname�Ƿ���ͬ����ͬ˵������
		 * 2.2 ������ͬ������csteromerdao��getcountwithname(string name)��ȡ���������ݿ����Ƿ����
		 * 2.3 ����ͬ��������
		 * */
		if(!oldName.equalsIgnoreCase(name)) {
			long count=customerdao.getCountWithName(name);
			if(count>0) {
				request.setAttribute("message", "�û���"+name+"�Ѿ���ռ�ã�������ѡ��");
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
		 //1.��ȡ�������id
		 String idstr=request.getParameter("id");
		 int id=-1;
		 //2.����customerdao��customerdao��getid(id)��ȡ��id��Ӧ��customer����
		 try {
			 Customer customer=customerdao.get(Integer.parseInt(idstr));
			 System.out.println("------99:"+customer.getName());
			 if(customer!=null) {
				 forwardPath="/updatecustomer.jsp";
				 request.setAttribute("customer",customer);
			 }
		} catch (Exception e) { System.out.println("customersevlet 103");}
		 //4.��Ӧupdate customer.jsp
		 request.getRequestDispatcher(forwardPath).forward(request, response);
		 System.out.println("customersevlet 106");
		} 
	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			String idStr=request.getParameter("id");
			int id=0;
			/*
			 * try...cath�����ã���ֹidstr����תΪint��
			 * �����ܣ���id=0���޷�����ɾ������
			 * */
			try {
				id=Integer.parseInt(idStr);
		        customerdao.delete(id);
			} catch (Exception e) {
				
			}
			response.sendRedirect("query.do");
	}

	private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//��ȡģ����ѯ���������
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String address=request.getParameter("address");
		System.out.println("----------������");
		//�����������װΪһ��criteriacustomer����
		CriteriaCustomer cc=new CriteriaCustomer(name,address,phone);
		
		System.out.println("----------134");
		//1.����customerDAO��getForListWithCriteriaCustomer�����õ�customer����
		List<Customer>customers=customerdao.getForListWithCriteriaCustomer(cc);
		//2.��customer�ļ��Ϸ���request��
		request.setAttribute("customers", customers);
		//3.ת��ҳ�浽index.jsp������ʹ���ض���
		System.out.println("----------140");
		request.getRequestDispatcher("/operate.jsp").forward(request, response);
		System.out.println("query");
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//1. ��ȡ������
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		/*2.����name�Ƿ��Ѿ���ռ��
		 * 	2.1����customerDAO��getcountwithname(string name)��ȡname�����ݿ����Ƿ����
		 * 	2.2 ������ֵ����0������Ӧnewcustomer.jspҳ�棺(ͨ��ת������Ӧ)
		 * 		2.2.1Ҫ����newcustomer.jspҳ����ʾһ��������Ϣ���û����Ѿ���ռ�ã�������ѡ��
		 * 			��request�з���Ҳ������message:�û���name�Ѿ���ռ�ã�������ѡ��
		 * 			��ҳ��ͨ��request.getAttribute("message")�ķ�ʽ����ʾ
		 * 		2.2.2 newcustomer.jsp�ı����Ի���
		 * 			���Է�ʽ��alue="<%=request.getParameter("name")==null? "":request.getParameter("name") %>"
		 * 		2.2.3 ������ʽreturn
		 * */
		long count=customerdao.getCountWithName(name);
		System.out.println("------׼���ж�");
		if(count>0) {
			System.out.println("-----��if");
			request.setAttribute("message","name "+name+" already be used��please try another one~~");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
			return;
		}else if(name=="" || address=="" || phone=="") {
			System.out.println("-----�� else if");
			request.setAttribute("message","it cannot be null here~~");
			request.getRequestDispatcher("/newcustomer.jsp").forward(request, response);
		}else {
		//2.�ѱ�������װΪҲ��customer����
		Customer customer=new Customer(name,address,phone);
		//3.����customerDAO��save(customer customer),ִ�б������
		customerdao.save(customer);
		//4.�ض���ת��ҳ�浽index.jsp,���ʹ��ת���Ļ��ᷢ�������ظ��ύ
		response.sendRedirect("operate.jsp");
		}
	}

}
