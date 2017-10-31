import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Operator extends User{

	public Operator(String name, String password, String role) {
		super(name, password, role);
	}

	//����¼����Ա
	public void showMenu() {
		while(true){
			String infos = "****��ӭ���뵵��¼��Ա�˵�****"+"\n\t"+"1.�ϴ��ļ�\n\t2.�����ļ�\n\t3.�ļ��б�\n\t4.�޸�����\n\t5.�˳�\n"+"******************";
			System.out.print(infos);
			System.out.print("��ѡ��˵���");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			String temp = null;
			switch(choice){
			case 1:System.out.print("�������ļ�����");
			temp = s.nextLine();
				try {
					if(uploadFile(temp))
						System.out.println("�ϴ��ɹ���");
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 2:System.out.print("�������ļ�����");
			temp = s.nextLine();
				try {
					if(downloadFile(temp))
						System.out.println("���سɹ���");
				} catch (IOException e) {
					System.out.println(e);
				}
			break;
			case 3:try {
					showFileList();
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 4:System.out.print("�����������룺");
			temp = s.nextLine();
				try {
					if(!changeUserInfo(temp))
						System.out.println("�޸�ʧ�ܣ�");
				} catch (SQLException e) {
					System.out.println(e);
				}
			break;
			case 5:exitSystem();
			break;
			default:System.out.println("�밴�ղ˵��������룡");
			break;
			}
		}
	}
}
