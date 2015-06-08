package test;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet(urlPatterns = { "/upload" })
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		System.out.println("--start!");
		InputStream in = null;
		PrintWriter w = null;
		try {
			w = response.getWriter();
			int len = request.getContentLength();
			System.out.println(len);
			in = request.getInputStream();
			
			//Thread d = new Thread(new UploadRunnable(request));
			byte []b = new byte[1024];
			int size = 0,ll = 0;
			int last = -1;
			java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00");  
			String per = "";
			while ((size = in.read(b)) != -1) {
				ll+=size;
//				System.out.println();
				//w.write("write bytes:"+(ll+=size));
				//percent =  (int) Math.round(ll*100.0/len);
				per = df.format(ll*100.0/len);
				Thread.sleep(1);
			//	synchronized (Test5Servlet.class) {
			//		if(percent != last) {
						System.out.println("main:"+per);
		//				Test5Servlet.class.notifyAll();
		//				last = percent;
		//			}
			//	}
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			in.close();
			w.close();
		}
	
	}

}
