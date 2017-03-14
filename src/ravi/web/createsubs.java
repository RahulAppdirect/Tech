package ravi.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.tech.model.Myproduct;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;
import ravi.model.Parent;
import ravi.model.Marketplace;
import ravi.model.Tech_product;

/**
 * Servlet implementation class createsubs
 */
@WebServlet("/createsubs")
public class createsubs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public createsubs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        ObjectMapper mapper = new ObjectMapper();
        String eventUrl= (String) request.getParameter("eventUrl");
        System.out.println(eventUrl);
        
        Myproduct tp= new Myproduct(true,"new-account-modifier");
        
        String json = mapper.writeValueAsString(tp);
        out.print(json);
      
        OAuthConsumer consumer = new DefaultOAuthConsumer("webstat7-153990", "0ENXQPkQoC3VCjsS");
        URL url = new URL(eventUrl);
        HttpURLConnection requestres = (HttpURLConnection)url.openConnection();
        requestres.setRequestProperty("Accept", "application/json"); 
        try
        {     	
        consumer.sign(requestres);
        requestres.connect();
        BufferedReader f = new BufferedReader(new InputStreamReader(requestres.getInputStream()));
        String last="";
        String str ="";

        while((last=f.readLine())!=null)
        {
            //System.out.println(last);
            str=str+last;
        } 
        System.out.println("str is "+str);
        ObjectMapper om = new ObjectMapper();

       Parent p = om.readValue(str,Parent.class);


       //System.out.println("*********");

       //System.out.println(p);


       Marketplace mp = p.getMarketplace();

       System.out.println(mp.getBaseUrl());
       
       
        
    }catch(Exception e)
        {
        e.printStackTrace();
        }

        
    }

}