import java.sql.SQLException;
import java.util.*;
public class Main {
	public static void main(String[] args){
		User temp = null;
		while(temp == null){
			System.out.println("��ѡ��˵���");
			System.out.println("1.��½\n2.�˳�");
			Scanner s = new Scanner(System.in);
			int choice = Integer.parseInt(s.nextLine());
			if(choice==1){
				System.out.print("�������û�����");
				String name = s.nextLine();
				System.out.print("���������룺");
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
				System.out.println("ϵͳ�˳���ллʹ�ã�");
				System.exit(0);
			}
		}

	}
}
