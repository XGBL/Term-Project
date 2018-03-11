package test;

import java.util.Scanner;
import drawshapes.*;

public class Test{
	
	//��ʼ�����ڴ�Ÿ�����״�����õ�����
	private static Shape[] shapes = new Shape[20];
	
	public static void main(String[] args) {
		
		int no = 0;				//���ڼ�¼shapes����Ŀ����ʼΪ0
		Scanner sc = new Scanner(System.in);			//��ʼ��scanner��������û�����
		Test test = new Test();				//��ʼ������������ڵ��ø�����
		
		//����ѭ����ֱ���û����롰quit��ʱ����ѭ��
		while(true) {
			
			//�û���ʾ���֣����롰create��ͼ�δ�������search��ͼ�μ�������draw��ͼ�λ��ƣ���quit���˳�
			System.out.println("please choose operations:(ops:\"creat\" \"search\" \"draw\" \"quit\")");
			String command = sc.next();				//�����û����������
			//ͼ�δ���
			if(command.equals("creat")) {
				if(no<20) {							//����û������Ƿ�Ϸ��������ɴ���20��ͼ�Σ�
					System.out.println("please choose shapes:(ops:\"rectangle\" \"circle\" \"triangle\")");		//��ʾѡ��Ҫ��������״����
					String shape = sc.next();
					System.out.println("please input name");		//��ʾ������״������
					String name = sc.next();
					if(test.creatShape(no,shape,name))		//���ô���ͼ�εķ������������ɹ������������1
						no++;				
				}
				else {
					System.out.println("the maximum count of shapes is 20!");
				}
			}
			//ͼ�μ���
			else if(command.equals("search")) {
				System.out.println("please input name");		//��ʾ����Ҫ��������״������
				String sname = sc.next();
				searchShape(sname,no);		//���ü���ͼ�εķ���
			}
			//ͼ�λ���
			else if(command.equals("draw")) {
				System.out.println("please input number(range from 0 to " + (no-1) + ",both ends are included)");		//��ʾ������Ų�������ѡ��ŷ�Χ
				int sno = sc.nextInt();
				if(sno<no) {			//����û������Ƿ�Ϸ�
					drawShape(sno);			//���û���ͼ�η���	
				}
				else {
					System.out.println("please input number range from 0 to " + (no-1) + "!");
				}
			}
			//�˳�
			else if(command.equals("quit")) {
				sc.close();			//�ر�����
				break;				//�˳�ѭ��
			}
			//���û�����Ƿ��򲵻�
			else {			
				System.out.println("please choose operations from \"creat\" \"search\" \"draw\" \"quit\"!");
			}
		}
	}
	//����ͼ�η���
	public boolean creatShape(int no,String shape,String name) {
		
		//�����û�����ѡ�񴴽���ͬ����״���󲢸�ֵ��shapes�ĳ�Ա
		if(shape.equals("rectangle")) {
			shapes[no] = new Rectangle(name);
			System.out.println("creat successful!");	//��ʾ�����ɹ�
		}
		
		else if(shape.equals("circle")) {
			shapes[no] = new Circle(name);
			System.out.println("creat successful!");
		}
		
		else if(shape.equals("triangle")) {
			shapes[no] = new Triangle(name);
			System.out.println("creat successful!");
		}
		//���û�����Ƿ��򲵻ز����ش���ʧ�ܵı�־
		else {
			System.out.println("please choose shapes from \"rectangle\" \"circle\" \"triangle\"!");
			return false;
		}
		return true;
	}
	//����ͼ�η���
	public static void searchShape(String sname,int no) {
		
		//���Ҳ���ӡ��sname��ƥ��ĵ�һ��ͼ�ε����ͺ����
		for(int i = 0; i < no; i++) {
			if(sname.equals(shapes[i].getName())) {
				System.out.println("type:"+shapes[i].getType()+" number:"+i);
				return;
			}
		}
		//��δ�ҵ�����ʾnot found
		System.out.println("not found!");
		return;
	}
	//����ͼ�η���
	public static void drawShape(int sno) {
		//�����˳��ѭ������son��֮ǰ������ͼ��
		for(int i = 0; i <= sno; i++) {
			shapes[i].drawShape();
		}
	}
}
