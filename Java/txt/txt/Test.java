package txt;

import java.util.*;

public class Test {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Txt txt = new Txt(new LinkedList<Object>());
		Scanner scanner0 = new Scanner(System.in);
		for(;;)
		{
			System.out.print("1.���Ӽ�¼\n2.��ü�¼����\n3.չʾ��¼\n4.ɾ����¼\n5.�˳�\n");
			int i = scanner0.nextInt();
			if(i == 1){
				System.out.println("�����ַ�����");
				Scanner scanner1 = new Scanner(System.in);
				String newLine = scanner1.nextLine();
				txt.addALine(newLine);
			}else if(i == 2){
				System.out.println("����Ϊ:" + txt.getAmount());
			}else if(i == 3){
				System.out.println("1.չʾ���м�¼\n2.չʾĳһ����¼");
				Scanner scanner3 = new Scanner(System.in);
				int Mode = scanner3.nextInt();
				if(Mode!=1&&Mode!=2){
					System.out.println("error!");
					continue;
				}
				if(Mode == 1){
					txt.printAll();
				}
				if(Mode == 2){
					System.out.println("�����¼���(1~" + txt.getAmount()+")");
					int No = scanner3.nextInt();
					if(No < 1|| No > txt.getAmount()){
						System.out.println("error!");
						continue;
					}
					txt.printALine(No);
				}
			}else if(i == 4){
				System.out.println("1.ɾ�����м�¼\n2.ɾ��ĳһ����¼");
				Scanner scanner4 = new Scanner(System.in);
				int Mode = scanner4.nextInt();
				if(Mode != 1 && Mode != 2){
					System.out.println("error!");
					continue;
				}
				if(Mode == 1){
					if(txt.deleteAll()) System.out.println("Successed!");
					else System.out.println("Failed to delete.");
				}
				if(Mode == 2){
					System.out.println("�����¼���(1~"+txt.getAmount()+")");
					int No = scanner4.nextInt();
					if(No < 1|| No > txt.getAmount()){
						System.out.println("error!");
						continue;
					}
					int curAmount = txt.getAmount();
					txt.deleteALine(No);
					if(txt.getAmount() == curAmount - 1) System.out.println("Successed!");
					else System.out.println("Failed to delete.");
				}
			}
			else break;
		}
		scanner0.close();
	}
}
