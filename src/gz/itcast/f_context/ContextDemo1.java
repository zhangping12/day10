package gz.itcast.f_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 得到web应用路径
 */
public class ContextDemo1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.得到ServletContext对象
//        ServletContext context = this.getServletConfig().getServletContext();
        ServletContext context = this.getServletContext();//(推荐使用)

        //2.得到web应用路径   /day10
        /**
         * web应用路径：部署到tomcat服务器上运行的web应用名称
         */
        String contextPath = context.getContextPath();
        System.out.println(contextPath);

        /**
         * 案例：应用到请求重定向
         */
//        resp.sendRedirect(contextPath+"/index.html");
        resp.sendRedirect("/index.jsp");
    }
}
