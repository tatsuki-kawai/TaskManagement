package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PrintTaskLogic;
import model.Task;
import model.User;

/**
 * Servlet implementation class PrintTask
 */
@WebServlet("/PrintTask")
public class PrintTask extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PrintTask() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //セッションスコープからユーザーの名前とパスワードを取得する
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String name = user.getName();
		String password = user.getPass();

		//データベースからユーザーが登録した目標のリストを取得する
		ArrayList<Task> taskList = new ArrayList<Task>();

		PrintTaskLogic printTaskLogic = new PrintTaskLogic();
		taskList = printTaskLogic.execute(name, password);

		//セッションスコープに取得したリストを保存する
		session.setAttribute("taskList", taskList);

		//フォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/printTask.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
