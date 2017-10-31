import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Browser extends User{

	Browser(String name, String password, String role) {
		super(name, password, role);
	}

	//���������Ա
	public void showMenu() {
		while(true){
			String infos = "****��ӭ���뵵�����Ա�˵�****"+"\n\t"+"1.�����ļ�\n\t2.�ļ��б�\n\t3.�޸�����\n\t4.�˳�\n"+"******************";
			System.out.print(infos);
			System.out.print("��ѡ��˵���");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			String temp = null;
			switch(choice){
			case 1:System.out.print("�������ļ�����");
			temp = s.nextLine();
				try {
					if(downloadFile(temp))
						System.out.println("���سɹ���");
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
			case 3:System.out.print("�����������룺");
			temp = s.nextLine();
				try {
					if(!changeUserInfo(temp))
						System.out.println("�޸�ʧ�ܣ�");
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 4:exitSystem();
			break;
			default:System.out.println("�밴�ղ˵��������룡");
			break;
			}
		}
	}
}
