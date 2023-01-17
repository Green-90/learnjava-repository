

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // login.jspに画面遷移する
    	request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 文字コードの設定
    request.setCharacterEncoding("UTF-8");
    
    // ユーザーから送信されたユーザーIDとパスワードを取得する。
  String id1 = request.getParameter("id");
  String pass = request.getParameter("password");	
  
  //ログイン認証後に遷移する先を格納する
  String path = "";

  try {
  	//MySQLに接続するためのURL
  	String url = "jdbc:mysql://localhost:3306/login_db?serverTimezone=JST";
  	String user = "root";
  	String password = "sqlroot4321";

  // 実行するSQL
  	String sql = "SELECT login_id FROM login WHERE loginId=? AND password=?";

  	Class.forName("com.mysql.cj.jdbc.Driver");
  	try(Connection con = DriverManager.getConnection(url, user, password);
  			PreparedStatement pstmt = con.prepareStatement(sql)){

  				// 入力されたユーザーIDとパスワードをSQLの条件にする
  				pstmt.setString(1, id1);
  				pstmt.setString(2, pass);

  				// SQLの実行
  				ResultSet res = pstmt.executeQuery();

  				// ユーザーIDとパスワードが一致するユーザーが存在した時
  				if (res.next()) {
  					// idをリクエスト	スコープに設定する
  					request.setAttribute("id1", res.getString("id"));

  					// ログイン成功画面に遷移する
  					path = "/mypage.jsp";

  					request.getRequestDispatcher(path).forward(request, response);

  				} else {
  					// ログイン失敗の文言を追加する
  					request.setAttribute("loginFailure", "ログインに失敗しました");
  					request.setAttribute("message", "IDまたはパスワードが違います");

  					// ログインに失敗したときはもう一度ログイン画面を表示する

  					path = "/login.jsp";
  					request.getRequestDispatcher(path).forward(request, response);

  				}
  			}
  		}catch (ClassNotFoundException | SQLException e) {
  			e.printStackTrace();
  		}

  		RequestDispatcher rd = request.getRequestDispatcher(path);
  		rd.forward(request, response);
  }   
}