package stuff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by voldem on 03.11.2015.
 */
public class Name {

    private HttpServletResponse response;
    private List<String> names;
    private HttpServletRequest request;

    public Name(List<String> names) {
        this.names = names;
    }

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
        String name = "name";
        if (lineWithOutSlash.equals(name)){
            getResponse().getWriter().println("<h3>List of names: </h3>");
            for (String n : names){
                getResponse().getWriter().println("<h3>" + n + "</h3>");
            }
        }
        else {
            names.add(lineWithOutSlash.replace("name/",""));
            getResponse().getWriter().println("<h2>Hello</h2>");
            getResponse().getWriter().println("<h1>" + lineWithOutSlash.replace("name/","") + "</h1>");
        }
    }

}
