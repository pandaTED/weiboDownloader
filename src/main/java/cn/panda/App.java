package cn.panda;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Locale;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {

       @SuppressWarnings("all")
        HttpClient httpClient = new DefaultHttpClient();

        HttpGet httpGet = new HttpGet("http://www.sogou.com");

        HttpResponse httpResponse = httpClient.execute(httpGet);

        StatusLine statusLine = httpResponse.getStatusLine();

        int statuscode = statusLine.getStatusCode();

        Locale locale = httpResponse.getLocale();

        String country = locale.getCountry();

        HttpEntity entity = httpResponse.getEntity();

        String html = EntityUtils.toString(entity,"UTF-8");

        httpGet.releaseConnection();

        System.out.println(statuscode);
    }
}
