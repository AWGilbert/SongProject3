package webpackage;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/DataServlet")
public class DataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Collection myMusic;
    private String genreSelectionList;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        myMusic = new Collection ("./webpackage/finalTracks.csv");
		
		String[] tokens = myMusic.getGenres();
		
		genreSelectionList = "<select name=\"genres\">";   
		for (int i = 0; i < tokens.length; i++) {
			genreSelectionList += "<option value=\""+tokens[i]+"\">"+tokens[i]+"</option>";	
		}

		genreSelectionList += "</select>"; 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (request.getParameter("startUsing") != null) {

			
			request.setAttribute("genresParameter",genreSelectionList); 
			request.setAttribute("songCt",""+myMusic.size());
			RequestDispatcher rd=request.getRequestDispatcher("/pickGenre.jsp");   
			rd.forward(request,response);  			
			
		} else if (request.getParameter("processGenre") != null) {
			String g = request.getParameter("genres");
			String[] songs = myMusic.findSongByGenre2(g);

			String label2="songsParameter"; 
			String label2Value = "<select name=\\\"songs\\\">";
			for (int i = 0; i < songs.length; i++) {
				label2Value += "<option value=\""+songs[i]+"\">"+songs[i]+"</option>";	
			}
			label2Value += "</select>"; 
			
			request.setAttribute(label2,label2Value); 		 	
			request.setAttribute("genresParameter",genreSelectionList); 
			RequestDispatcher rd=request.getRequestDispatcher("/displaySongs.jsp");   
			rd.forward(request,response);  
		} else {
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");   
			rd.forward(request,response); 		
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
