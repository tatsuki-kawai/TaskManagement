package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.EditTaskLogic;
import model.Task;
import model.User;

/**
 * Servlet implementation class EditTask
 */
@WebServlet("/EditTask")
public class EditTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditTask() {
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
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String timeLimit = request.getParameter("timeLimit");

		//セッションスコープからユーザーの情報を取得する
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");

		//データベースから選択された目標の情報を取得する
		EditTaskLogic editTaskLogic = new EditTaskLogic();
        Task task = editTaskLogic.execute(user, name, timeLimit);

        //取得した目標をセッションスコープに保存する
        session.setAttribute("task", task);

        //編集画面にフォワードする
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/editTask.jsp");
        dispatcher.forward(request, response);

	}

}
