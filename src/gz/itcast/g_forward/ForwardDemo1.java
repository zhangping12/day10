package gz.itcast.g_forward;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发（效果：跳转页面）
 *
 */
public class ForwardDemo1  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 保存数据到request域对象
         */
        req.setAttribute("name", "rose");

        //转发
        /**
         * 注意：不能转发当前web应用以外的资源。
         */
        /*RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/GetDataServlet");
        rd.forward(req,resp);*/

        this.getServletContext().getRequestDispatcher("/GetDataServlet").forward(req,resp);
    }
}
