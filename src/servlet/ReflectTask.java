package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ReflectTaskLogic;
import model.Task;

/**
 * Servlet implementation class ReflectTask
 */
@WebServlet("/ReflectTask")
public class ReflectTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReflectTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
	    String name = request.getParameter("name");
	    String timeLimit = request.getParameter("timeLimit");

	    //セッションスコープに保存された目標に変更内容を反映させる
	    HttpSession session = request.getSession();
	    Task task = (Task) session.getAttribute("task");
	    task.setName(name);
	    task.setTimeLimit(timeLimit);
	    session.setAttribute("task", task);

	    //変更内容をデータベースに反映させる
	    ReflectTaskLogic reflectTaskLogic = new ReflectTaskLogic();
        reflectTaskLogic.execute(task);

	    //目標一覧画面にフォワードする
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/PrintTask");
	    dispatcher.forward(request, response);
	}

}
