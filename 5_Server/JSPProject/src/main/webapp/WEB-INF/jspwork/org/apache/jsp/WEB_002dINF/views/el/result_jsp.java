/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.76
 * Generated at: 2023-07-03 00:36:09 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.el;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import edu.kh.jsp.model.vo.Person;

public final class result_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("edu.kh.jsp.model.vo.Person");
    _jspx_imports_classes.add("java.util.ArrayList");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!-- person 클래스 import -->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>EL 확인하기</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("	<!-- \r\n");
      out.write("		EL의 특징 \r\n");
      out.write("		\r\n");
      out.write("		1.get이라는 단어를 사용하지 않음\r\n");
      out.write("		왜? 표현언어 == 출력용 언어 == 출력은 얻어와서 밖에 못함\r\n");
      out.write("		\r\n");
      out.write("		2. EL은 null을 빈칸으로 출력함\r\n");
      out.write("			(null과 관련된 것은 모두 빈칸)\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	 -->\r\n");
      out.write("\r\n");
      out.write("	<h3>request에서 Parameter 얻어오기</h3>\r\n");
      out.write("\r\n");
      out.write("	<pre>\r\n");
      out.write("		EL로 Parameter 얻어와서 출력하는 방법\r\n");
      out.write("		${ param.name속성값 }\r\n");
      out.write("	</pre>\r\n");
      out.write("\r\n");
      out.write("	1) JSP 표현식 :\r\n");
      out.write("	");
      out.print( request.getParameter("inputName") );
      out.write("\r\n");
      out.write("	/\r\n");
      out.write("	");
      out.print( request.getParameter("inputAge") );
      out.write("\r\n");
      out.write("	/\r\n");
      out.write("	");
      out.print( request.getParameter("inputAddress") );
      out.write("\r\n");
      out.write("\r\n");
      out.write("	");
      out.print( request.getParameter("inputAddress2") );
      out.write("\r\n");
      out.write("	<!-- null 출력 -->\r\n");
      out.write("\r\n");
      out.write("	<br>\r\n");
      out.write("	<br> 2) EL(표현언어) : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.inputName }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.inputAge }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write(' ');
      out.write('/');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.inputAddress }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\r\n");
      out.write("	");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ param.inputAddress2 }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	<!-- 빈칸 출력 -->\r\n");
      out.write("\r\n");
      out.write("	<h3>request에서 속성(Attribute)얻어오기</h3>\r\n");
      out.write("\r\n");
      out.write("	<pre>\r\n");
      out.write("	 	Servlet에서 추가된 속성을 표현(출력)하려는 경우 \r\n");
      out.write("	 	request에 세팅된 속성(Attribute)의 key값만 작성하여 출력할 수 있다!\r\n");
      out.write("	 	(import,getAtribute(),다운캐스팅, 변수 저장 모두 생략)	\r\n");
      out.write("	 \r\n");
      out.write("	 	${ 속성key }\r\n");
      out.write("	 	${ 속성key.필드명 }\r\n");
      out.write("	 	(단,getter가 작성되어 있어야지만 가능)\r\n");
      out.write("	 </pre>\r\n");
      out.write("\r\n");
      out.write("	");

	 	String menu = (String)request.getAttribute("menu");
	 
		Person person = (Person)request.getAttribute("person");
	 	
	 
      out.write("\r\n");
      out.write("	1) JSP 표현식 :");
      out.print(menu );
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Person 클래스의 toString() 출력 -->\r\n");
      out.write("	<br>");
      out.print(person );
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<!-- Person클래스의 getter를 이용해 얻어와서 출력 -->\r\n");
      out.write("	<br>");
      out.print(person.getName() );
      out.write("\r\n");
      out.write("	<br>");
      out.print(person.getAge() );
      out.write("\r\n");
      out.write("	<br>");
      out.print(person.getAddress() );
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<br>\r\n");
      out.write("	<br> 2) EL(표현 언어) : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ menu }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ person }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ person.name }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ person.age }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ person.address }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<hr>\r\n");
      out.write("\r\n");
      out.write("	<h3>null 처리 방법</h3>\r\n");
      out.write("\r\n");
      out.write("	<pre>\r\n");
      out.write("	 	EL에서 null을 출력해야 되는 경우 \"\"(빈 문자열을 출력한다.)\r\n");
      out.write("	 	+ NullPointerException이 발생하는 코드에서도 \"\" (빈 문자열)을 출력한다. \r\n");
      out.write("	 	+ EL은 null은 경우를 확인할 때 empty를 통해서 확인 할 수 있다. \r\n");
      out.write("	 	EL == NULL \"\"빈문자열 /empty \"\" 빈문자열을 검사하기위해 사용\r\n");
      out.write("	 </pre>\r\n");
      out.write("\r\n");
      out.write("	");
 
	 List<String> list = null;
	 
      out.write("\r\n");
      out.write("\r\n");
      out.write("	1) JSP 표현식 : ");
      out.print(list );
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<br> ");
      out.print(list == null );
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<br><br> \r\n");
      out.write("	\r\n");
      out.write("	2) EL(표현 언어) : ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ list }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	<br> ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${empty list}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("	<h3 style =\"color:red;\"> EL의 empty는 null과 비어있는 컬렉션을 비어있는 것으로 취급함</h3>\r\n");
      out.write("	\r\n");
      out.write("	");

		/* list에 주소값을 담고 있으며 비어있는 list이다. <> : 제네릭 / 자바에서는 null값은 참조하지 않는다.*/
		list = new ArrayList<String>();
		
		//list가 ArrayList 객체를 참조 == null 아님
		//참조하고 있는 ArrayList에 내용은 없음 == 비어있음
	
	
      out.write("\r\n");
      out.write("	\r\n");
      out.write("	");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ empty list }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write('\r');
      out.write('\n');
      out.write('	');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${list==null }", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
