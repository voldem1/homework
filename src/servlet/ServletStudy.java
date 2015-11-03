package servlet;

import files.ContentFileReader;
import stuff.MathPow;
import stuff.Name;
import stuff.Time;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by IT-Univer004 on 10/28/15.
 */
public class ServletStudy extends HttpServlet {
    private List<String> names = synchroneList();
    private Name name = new Name(names);
    private MathPow math = new MathPow();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getRequestURI().matches("\\/index.html")) {
            ContentFileReader contentFileReader = new ContentFileReader("index.html");
            ContentFileReader contentCssReader = new ContentFileReader("css.css");
            StringBuilder contentCss = new StringBuilder();
            Time currentTime = new Time();
            Random r = new Random();
            StringBuilder contentRandom = new StringBuilder();
            StringBuilder contentTime = new StringBuilder();
            contentCss.append(contentFileReader.addToContent(contentFileReader.getResult(),
                    "<style type=\"text/css\">", contentCssReader.getResult()));
            contentTime = contentTime.append(contentFileReader.addToContent(contentCss.toString(),
                    "<h1>", currentTime.getCurrentTime()));
            contentRandom = contentRandom.append(contentFileReader.addToContent(contentTime.toString(),
                    "<random>", String.valueOf(r.nextInt(100))));
            response.getWriter().println(contentRandom);
        }else if (request.getRequestURI().contains("name")) {
            name.run(request, response);
        }else if (request.getRequestURI().contains("math")) {
            math.run(request, response);
        }
    }
    protected List <String> synchroneList(){
        return Collections.synchronizedList(new ArrayList<String>());
    }

}
