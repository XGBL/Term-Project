package calendar;
import javax.swing.JOptionPane;
import java.util.Scanner;
public class calendar {

	public static void main(String[] args) {
		//ѡ���ܣ���������������������1 ��������������ڼ�������2
		System.out.println("Options:\nInput year and then output calendar please input 1\nInput date and then output weekday please input 2");
		Scanner sc = new Scanner(System.in);
		try {
			int op = sc.nextInt();
			if(op == 1) {
				//��������ݣ���2017��
				System.out.println("Please input year(eg:2017):");
				int year1 = sc.nextInt();
				sc.close();
				System.out.println(year1+"calendar");
				System.out.println();
				calendar c = new calendar();
				c.printCalendar(year1);
				
			}
			else if(op == 2) {
				//���������ڣ���20170924��
				System.out.println("Please input date(eg:20170924):");
				int date = sc.nextInt();
				sc.close();
				int year2 = date/10000;//��ȡ���
				int month2 = (date%10000)/100;//��ȡ�·�
				int day2 = date - year2*10000-month2*100;//��ȡ��
				calendar c = new calendar();
				c.printWeekday(year2,month2,day2);
			}
			else {
				
			}
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getStackTrace());
		}

	}
	
	//��ӡ����
	public void printCalendar(int year) {
		int weekday = getWeekday(year);//��ȡ��һ��ĵ�һ���ǰһ�������ڼ�
		if(weekday>6)
			weekday=0;
		int i,j,k;
		for(i = 1; i <= 12; i++) {
			System.out.println(year + "/" + i);//�����ǰ�·�
	        System.out.println("Mon" + "  " + "Tue" + "  " + "Wed" + "  " + "Thu" + "  " + "Fri" + "  " + "Sat" + "  "+"Sun");//������ڼ���ע
	        //���weekday��ǰ���ո�ʹ���ں������ܹ���Ӧ����
            for (j = 0; j < weekday; j++) {
                System.out.print("     ");
            }
            
            int day = getDay(year,i);//��ȡ��i���µ�����
            //��������գ�ÿ7�����У�������weekday��ֵ
            for(k = 1; k <= day; k++) {
                if (k < 10) {
                    System.out.print(" " + k + "   ");
                } else {
                    System.out.print(k + "   ");
                }
                weekday++;
                if (weekday > 6) {
                    System.out.println();
                    weekday = 0;
                }            	
            }
            
            System.out.println();
            System.out.println();
		}
	}
	
	//��ӡ�������������ڼ�
	public void printWeekday(int year,int month,int day) {
		int weekday = getWeekday(year);//��ȡ��һ��ĵ�һ���ǰһ�������ڼ�
		int i,sum=0;
		//����������һ�쵽��ǰ���ھ����˶�����
		for(i = 1; i < month; i++) {
			sum+=getDay(year,i);
		}
		sum+=day;
		//���㵱ǰ���������ڼ��������
		switch((weekday+sum)%7) {
			case 1:
				System.out.println("Monday");
				return;
			case 2:
				System.out.println("Tuesday");
				return;
			case 3:
				System.out.println("Wednesday");
				return;
			case 4:
				System.out.println("Thursday");
				return;
			case 5:
				System.out.println("Friday");
				return;
			case 6:
				System.out.println("Saturday");
				return;
			case 0:
				System.out.println("Sunday");
				return;
			default:
				System.out.println("error");
				return;
		}
	}
	
	//�õ�������ݵĵ�һ���ǰһ�������ڼ�����2000.1.1Ϊ��׼
	int getWeekday(int year) {
		if(year > 2000) {
			return (5+366+((year-2001)/4)*(365*3+366)+((year-2001)%4)*365)%7;
		}
		else if(year == 2000) {
			return 5;
		} 
		else {
			return 7-(((2000-year)/4)*(365*3+366)+((2000-year)%4)*365-5)%7;
		}
	}
	
	//�õ�ĳ��ĳ�µ�����
	int getDay(int year,int month) {
        switch (month) {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            if (isLeapyear(year)) {
                return 29;
            } else {
                return 28;
            }
        default:
            return 0;
        }		
	}
	
	//�ж�ĳ���ǲ�������
	boolean isLeapyear(int year) {
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
            return true;
        } else {
            return false;
        }		
	}
}