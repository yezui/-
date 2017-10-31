import java.sql.SQLException;
import java.util.*;
public class Main {
	public static void main(String[] args){
		User temp = null;
		while(temp == null){
			System.out.println("请选择菜单：");
			System.out.println("1.登陆\n2.退出");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			if(choice==1){
				System.out.print("请输入用户名：");
				String name = s.nextLine();
				System.out.print("请输入密码：");
				String password = s.nextLine();
				try {
					temp = DataProcessing.search(name, password);
				} catch (SQLException e) {
					System.out.println(e);
				}
				if(temp != null)
					temp.showMenu();
			}
			else{
				System.out.println("系统退出，谢谢使用！");
				System.exit(0);
			}
		}

	}
}
