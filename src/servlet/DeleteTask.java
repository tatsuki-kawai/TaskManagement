package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DeleteTaskLogic;
import model.GetTaskLogic;
import model.Task;
import model.User;

/**
 * Servlet implementation class DeleteTask
 */
@WebServlet("/DeleteTask")
public class DeleteTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteTask() {
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

		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String timeLimit = request.getParameter("timeLimit");

		//セッションスコープからユーザーの情報を取得する
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		//データベースから選択された目標の情報を取得する
		GetTaskLogic getTaskLogic = new GetTaskLogic();
        Task task = getTaskLogic.execute(user, name, timeLimit);

	    //取得したタスクを削除する
        DeleteTaskLogic deleteTaskLogic = new DeleteTaskLogic();
        deleteTaskLogic.execute(task);

		//編集画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/.jsp");
		dispatcher.forward(request, response);

	}

}
