package gz.itcast.f_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * 得到web应用参数
 *
 */
public class ContextDemo2  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //得到servletContext对象
        ServletContext context = this.getServletContext();

        System.out.println("参数"+context.getInitParameter("AAA"));//可以获取web.xml中context-param参数，所以获取不到servlet参数
        Enumeration<String> enums = context.getInitParameterNames();
        while(enums.hasMoreElements()){
            String paramName = enums.nextElement();
            String paramValue  =context.getInitParameter(paramName);
            System.out.println(paramName+"="+paramValue);
        }

        //尝试得到ConfigDemo中的servlet参数
        String path = this.getServletConfig().getInitParameter("path");
        System.out.println("path="+path);
    }
}
