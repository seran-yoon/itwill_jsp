package test.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextFileServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		ServletContext context = getServletContext();
		
		InputStream is = context.getResourceAsStream("/WEB-INF/file.txt");
		BufferedReader buffer = new BufferedReader(new InputStreamReader(is));
		String s = null;
		String driver = null;
		String url = null;
		String user = null;
		String pass = null;
		
		while((s = buffer.readLine()) != null){
			StringTokenizer tokens = new StringTokenizer(s, "&");
			
			driver = tokens.nextToken();
			url = tokens.nextToken();
			user = tokens.nextToken();
			pass = tokens.nextToken();
		}
		
		out.print("<html><body>");
		out.print(driver + "<br>");
		out.print(url + "<br>");
		out.print(user + "<br>");
		out.print(pass + "<br>");
		out.print("</body></html>");
		out.close();
	
	}
	
}
