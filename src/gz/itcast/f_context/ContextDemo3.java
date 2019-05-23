package gz.itcast.f_context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 保存数据
 */
public class ContextDemo3  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.得到域对象
        ServletContext context = this.getServletContext();

        //2.把数据保存到域对象中
        context.setAttribute("name","eric");
        context.setAttribute("student",new Student("jacky",20));
        System.out.println("保存成功");
    }


}

class Student{
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Student(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Student [age=" + age + ", name=" + name + "]";
    }

}
