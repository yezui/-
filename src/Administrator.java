import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Scanner;

public class Administrator extends User{

	Administrator(String name, String password, String role) {
		super(name, password, role);
	}

//ϵͳ������Ա
	public void showMenu() {
		while(true){
			String infos = "****��ӭ���뵵��¼��Ա�˵�****"+"\n\t"+"1.�޸��û�\n\t2.ɾ���û�\n\t3.�����û�\n\t4.�г��û�\n\t5.�����ļ�\n\t6.�ļ��б�\n\t7.�޸ı�������\n\t8.�˳�\n"+"******************";
			System.out.print(infos);
			System.out.print("��ѡ��˵���");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			String temp1=null;
			String temp2=null;
			String temp3=null;
			switch(choice){
			case 1:System.out.println("�������û�����");
			temp1 = s.nextLine();
			System.out.println("�����������룺");
			temp2 = s.nextLine();
			System.out.println("���������û����ͣ�");
			temp3 = s.nextLine();
				try {
					if(DataProcessing.update(temp1, temp2, temp3))
						System.out.println("�޸ĳɹ���");
					else
						System.out.println("�޸�ʧ�ܣ�");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 2:System.out.print("��������Ҫɾ�����û�����");
			temp1 = s.nextLine();
				try {
					if(DataProcessing.delete(temp1))
						System.out.println("ɾ���ɹ���");
					else
						System.out.print("ɾ��ʧ�ܣ�");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 3:System.out.println("���������û�����");
			temp1 = s.nextLine();
			System.out.println("�����������룺");
			temp2 = s.nextLine();
			System.out.println("���������û����ͣ�");
			temp3 = s.nextLine();
				try {
					if(DataProcessing.insert(temp1, temp2, temp3))
						System.out.println("���ӳɹ���");
					else
						System.out.println("����ʧ�ܣ�������һ��δʹ�ù����û���");
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
			case 5:System.out.print("�������ļ�����");
			temp1 = s.nextLine();
				try {
					if(downloadFile(temp1))
						System.out.println("���سɹ���");
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
			case 7:System.out.print("�����������룺");
			temp1 = s.nextLine();
				try {
					if(!changeUserInfo(temp1))
						System.out.println("�޸�ʧ�ܣ�");
				} catch (SQLException e1) {
					System.out.println(e1);
				}
			break;
			case 8:exitSystem();
			break;
			default:System.out.println("�밴�ղ˵��������룡");
			break;
			}
		}
	}
}
