import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/circle-result")
public class CircleResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String radiusValue = request.getParameter("radius");
        if (radiusValue == null || radiusValue.isEmpty()) {
            radiusValue = (String) request.getAttribute("radius");
        }
        double radius = Double.parseDouble(radiusValue);
        double area = Math.PI * radius * radius;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h2>Circle Area</h2>");
        out.println("Radius: " + radius + "<br>");
        out.println("Area: " + area);
        out.println("</body></html>");
    }
}
