package gz.itcast.f_config;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;

public class ConfigDemo extends HttpServlet {

    /**
     * 1)tomcat服务器把这些参数会在加载web应用的时候，封装到ServletConfig对象中
     * 2）tomcat服务器调用init方法传入ServletConfig对象
     */

    /**
     * 以下两段代码GenericServlet已经写了，我们无需编写！！
     */
    /*private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
    }*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 读取servlet的初始参数
         */
        String path = this.getServletConfig().getInitParameter("path");//从web.xml中对应的servlet获取初始参数init-param

        File file = new File(path);
        //读取内容
        BufferedReader br = new BufferedReader(new FileReader(file));
        String str = null;
        while((str = br.readLine())!=null){
            System.out.println(str);
        }

        //查询当前servlet的所有---->初始化参数
        Enumeration<String> enums = this.getServletConfig().getInitParameterNames();
        while (enums.hasMoreElements()){
            String paramName = enums.nextElement();
            String paramValue = this.getServletConfig().getInitParameter(paramName);
            System.out.println(paramName + "=" +paramValue);
        }

        //得到servlet的名称
        String servletName = this.getServletConfig().getServletName();
        System.out.println(servletName);
    }
}
