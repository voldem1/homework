package stuff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by voldem on 03.11.2015.
 */
public class MathPow {
    private HttpServletResponse response;
    private HttpServletRequest request;

    public HttpServletRequest getRequest() {
        return request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void run(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.request = request;
        this.response = response;
        getResponse().setContentType("text/html");
        getResponse().setStatus(HttpServletResponse.SC_OK);
        String line = getRequest().getRequestURI();
        String lineWithOutSlash = line.substring(1);
        getResponse().getWriter().println("<h1>Servlet</h1>");
        getResponse().getWriter().println("<h3>Your number : "
                + Math.pow(Integer.valueOf(lineWithOutSlash.replace("math/", "")), 2) + "</h3>");

    }
}
