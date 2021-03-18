package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OmikujiServlet
 */
@WebServlet("/OmikujiServlet")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OmikujiServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //リクエストパラメータンを取得する
        String username = request.getParameter("username");
        String[] results = {"大吉", "中吉", "小吉", "吉", "末吉", "凶"};

        // 入力項目チェック(バリデーション)
        List<String> errors = new ArrayList<String>();

        if(username == null || username.equals("")){
            errors.add("氏名を入力してください");
        }

        // 入力内容にエラーがあったかどうか
        if(errors.size() > 0){
            // JSPにエラー内容を送る
            request.setAttribute("errors", errors);
        } else {
            //JSPに入力データを送る
            request.setAttribute("result", results[(int)(Math.random() * 6)]);
            request.setAttribute("username", username);
        }

        // ビューとなるJSPを指定して表示する
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
        rd.forward(request, response);
    }

}
