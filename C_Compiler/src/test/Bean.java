package test;

class Stack{
	int num;//序号
	char name;//内容
	Stack next;//
	public Stack(){
		this.next=null;
	}
}

class Guiyue{//语法分析规则集
	int num;//序号
	int count;//长度
	char name;//符号名称
	Guiyue next;//连接下一对象
	public Guiyue(){
		this.next=null;
	}
}

class Sign{
char [] name=new char[20];//变量名
char kind;//标识符号
Sign next;//连接下一对象
public Sign(){
	this.next=null;
}
}

class Word{
	char []name=new char[20];//单词名字
	char mark_name;//标识类型
	int state;//状态
	int num;//序号
	int line;//行号
	Word link;//连接符号表
	Word next;//连接下一对象
	public Word(){
		this.link=null;
		this.next=null;
	}
}

public class Bean {

}
