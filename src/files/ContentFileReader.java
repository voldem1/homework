package files;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by voldem on 02.11.2015.
 */
public class ContentFileReader {
    private String path;
    private String result;

    public String getPath() {
        return path;
    }

    public String getResult() {
        if (result == null) {
            result = "";
        }
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ContentFileReader(String path) throws java.io.IOException {
        this.path = path;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(getPath())));
        String s = "";
        while ((s = bufferedReader.readLine()) != null) {
            setResult(getResult() + s);
//            System.out.println(s);
        }
    }
    public String addToContent(String content, String flag, String part){
        StringBuilder contentBuilder = new StringBuilder(content.subSequence(0, content.length()));
        StringBuilder partBuilder = new StringBuilder();
        if(content.contains(flag)){
            int index = content.indexOf(flag) + flag.length();
            if(flag.contains("<style type=\"text/css\">")){

                partBuilder.append(part);

            }
            else if(flag.contains("<h1>")){
                partBuilder.append(part);
                partBuilder.append("</h1>");
            }
            else if(flag.contains("<random>")){
                partBuilder.append(part);
            }
            contentBuilder.insert(index, partBuilder);
        }
        return contentBuilder.toString();
    }
}
