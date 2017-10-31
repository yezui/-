import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Browser extends User{

	Browser(String name, String password, String role) {
		super(name, password, role);
	}

	//档案浏览人员
	public void showMenu() {
		while(true){
			String infos = "****欢迎进入档案浏览员菜单****"+"\n\t"+"1.下载文件\n\t2.文件列表\n\t3.修改密码\n\t4.退出\n"+"******************";
			System.out.print(infos);
			System.out.print("请选择菜单：");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			String temp = null;
			switch(choice){
			case 1:System.out.print("请输入文件名：");
			temp = s.nextLine();
				try {
					if(downloadFile(temp))
						System.out.println("下载成功！");
				} catch (IOException e) {
					System.out.println(e);
				}
			break;
			case 2:try {
					showFileList();
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 3:System.out.print("请输入新密码：");
			temp = s.nextLine();
				try {
					if(!changeUserInfo(temp))
						System.out.println("修改失败！");
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 4:exitSystem();
			break;
			default:System.out.println("请按照菜单重新输入！");
			break;
			}
		}
	}
}
