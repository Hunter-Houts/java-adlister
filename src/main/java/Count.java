import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name="Count", urlPatterns = "/count")
public class Count extends HttpServlet {
    public static int count = 0;
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException{
        ++count;
        PrintWriter out = res.getWriter();
        out.println(count);

    }

}
