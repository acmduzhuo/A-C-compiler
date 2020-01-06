package test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class Compiler {

	static int row=1;//字符行变量
	static int []line=new int[10000];//字符行
	static int []wordLine=new int[300];//单词所在行
	static int wordCount;//单词数
	static char []buffer=new char [10000];//字符缓冲区

	Stack markPush(Stack ip,char name,int num){//入栈
		Stack s=new Stack();
		s.name=name;
		s.num=num;
		s.next=ip;
		ip=s;
		return ip;
	}

	void MarkPop(Stack ip){//出栈
		Stack s;
		char name;
		name=ip.name;
		s=ip.next;
		if(ip.next!=null){
			ip.name=ip.next.name;
			ip.num=ip.next.num;
			ip.next=ip.next.next;
		}
		
	}

	int judge(char ch){//词法分析枚举标识符号
		int flag;
		if(ch=='!'||ch=='$'||ch=='&'||ch=='*'||ch=='('||ch==')'||ch=='-'||ch=='_'||
				   ch=='+'||ch=='='||ch=='|'||ch=='{'||ch=='}'||ch=='['||ch==']'||ch==';'||
				   ch==':'||ch=='"'||ch=='<'||ch==','||ch=='>'||ch=='.'||ch=='/'||ch=='\'')     
																	{flag=1;}///特殊字符
				else if('0'<=ch&&ch<='9')                          {flag=2;}//数字
				else if(('a'<=ch&&ch<='z')||('A'<=ch&&ch<='Z'))    {flag=3;}//字母
				else if(ch==' ')                                   {flag=4;}//空格
				else if(ch=='\n')                                  {flag=5;}//换行
				else if(ch=='?')                                   {flag=6;} 
				else                                               {flag=0;}      //非法字符
		return flag;
	}
	
	void scan(String fileName) throws IOException{
		FileInputStream fis=new FileInputStream(fileName);//数据传递: 形参fileName接收文件路径；
		BufferedInputStream bis=new BufferedInputStream(fis);
		InputStreamReader isr=new InputStreamReader(bis,"utf-8");
		BufferedReader inbr=new BufferedReader(isr);	
		char ch;
		int flag,j=0,i=-1;
		while((ch=(char) inbr.read())!=-1){
			flag=judge(ch);
			System.out.print(ch);
			if(flag==1||flag==2||flag==3){
				i++;
				buffer[i]=ch;
				line[i]=row;
			}else if (flag==4){
				i++;
				buffer[i]='?';
				line[i]=row;
			}else if(flag==5){
				i++;
				buffer[i]='~';
				row++;
			}else{
				System.out.println("\n请注意，第"+row+"行的"+ch+"是非法字符");
			}
		}
		wordCount=i;

		int one,two,k=0;
		for(i=0;i<wordCount;i++){
			one=judge(buffer[i]);
			two=judge(buffer[i+1]);
			if((one!=two&&buffer[i]!='?'&&buffer[i]!='~')||one==1){//确定单词所在的行
				wordLine[k]=line[i];
				k++;
			}
		}
	}
	
	public static void main(String[] args) {

	}

}
