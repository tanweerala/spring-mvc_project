import java.util.Random;

public class App 
{
	public static void main(String[] args) 
	{
		Random ra=new Random();
		int num;
		num=ra.nextInt(6)+1;
		if(num!=6)
		{
			int x=ra.nextInt(3);
			if(x==0)
				num=6;
		}
		System.out.println(num);
	}
}
