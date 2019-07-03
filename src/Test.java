import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class Test {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("账号:");
		String uid = sc.nextLine();
		System.out.println("密码:");
		String pwd = sc.nextLine();
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","admin");
		Statement state = conn.createStatement();
		//uid=uid.replace("\'", "\"");//替换单双引号
		String sql = "select * from user where username = '"+uid+"' and loginpwd = '"+pwd+"' ";
		System.out.println(sql);
		ResultSet rs = state.executeQuery(sql);
		boolean ok = rs.next();
		if(ok) {
			System.out.println("欢迎回来"+rs.getString(3));
		}else {
			System.out.println("您输入的账号密码错误");
		}
		conn.close();
	}
}
