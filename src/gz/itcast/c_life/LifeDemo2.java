package gz.itcast.c_life;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LifeDemo2 extends HttpServlet {

    public LifeDemo2(){
        System.out.println("LifeDemo2对象被创建了");
    }
}
