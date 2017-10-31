import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
	}

//系统管理人员
	public void showMenu() {
		while(true){
			String infos = "****欢迎进入档案录入员菜单****"+"\n\t"+"1.修改用户\n\t2.删除用户\n\t3.新增用户\n\t4.列出用户\n\t5.下载文件\n\t6.文件列表\n\t7.修改本人密码\n\t8.退出\n"+"******************";
			System.out.print(infos);
			System.out.print("请选择菜单：");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			String temp1=null;
			String temp2=null;
			String temp3=null;
			switch(choice){
			case 1:System.out.println("请输入用户名：");
			temp1 = s.nextLine();
			System.out.println("请输入新密码：");
			temp2 = s.nextLine();
			System.out.println("请输入新用户类型：");
			temp3 = s.nextLine();
				try {
					if(DataProcessing.update(temp1, temp2, temp3))
						System.out.println("修改成功！");
					else
						System.out.println("修改失败！");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 2:System.out.print("请输入需要删除的用户名：");
			temp1 = s.nextLine();
				try {
					if(DataProcessing.delete(temp1))
						System.out.println("删除成功！");
					else
						System.out.print("删除失败！");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 3:System.out.println("请输入新用户名：");
			temp1 = s.nextLine();
			System.out.println("请输入新密码：");
			temp2 = s.nextLine();
			System.out.println("请输入新用户类型：");
			temp3 = s.nextLine();
				try {
					if(DataProcessing.insert(temp1, temp2, temp3))
						System.out.println("增加成功！");
					else
						System.out.println("增加失败！请输入一个未使用过的用户名");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 4:Enumeration<User> e;
				try {
					e = DataProcessing.getAllUser();
					while(e.hasMoreElements()){
						User A = e.nextElement();
						System.out.println(A.getRole()+" "+A.getName());
					}
				} catch (SQLException e1) {
					System.out.println(e1);
				} 
			break;
			case 5:System.out.print("请输入文件名：");
			temp1 = s.nextLine();
				try {
					if(downloadFile(temp1))
						System.out.println("下载成功！");
				} catch (IOException e1) {
					System.out.println(e1);
				}
			break;
			case 6:try {
					showFileList();
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 7:System.out.print("请输入新密码：");
			temp1 = s.nextLine();
				try {
					if(!changeUserInfo(temp1))
						System.out.println("修改失败！");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 8:exitSystem();
			break;
			default:System.out.println("请按照菜单重新输入！");
			break;
			}
		}
	}
}
