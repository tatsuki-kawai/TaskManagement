package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.CreateTaskLogic;
import model.User;

/**
 * Servlet implementation class CreateTask
 */
@WebServlet("/CreateTask")
public class CreateTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//目標登録画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/createTask.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String task_name = request.getParameter("task_name");
		String task_limit = request.getParameter("task_limit");

		//ユーザーの情報を取得する
		HttpSession  session = request.getSession();
        User user = (User) session.getAttribute("user");

		//目標の登録をおこなう
		CreateTaskLogic createTaskLogic = new CreateTaskLogic();
		createTaskLogic.execute(user, task_name, task_limit);

        //メイン画面にフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
