package test;

class Stack{
	int num;//���
	char name;//����
	Stack next;//
	public Stack(){
		this.next=null;
	}
}

class Guiyue{//�﷨��������
	int num;//���
	int count;//����
	char name;//��������
	Guiyue next;//������һ����
	public Guiyue(){
		this.next=null;
	}
}

class Sign{
char [] name=new char[20];//������
char kind;//��ʶ����
Sign next;//������һ����
public Sign(){
	this.next=null;
}
}

class Word{
	char []name=new char[20];//��������
	char mark_name;//��ʶ����
	int state;//״̬
	int num;//���
	int line;//�к�
	Word link;//���ӷ��ű�
	Word next;//������һ����
	public Word(){
		this.link=null;
		this.next=null;
	}
}

public class Bean {

}
