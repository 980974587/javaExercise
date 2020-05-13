package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class CheckSymbol{
	public static void main(String[] args) {
	
		String testLine="{ int[] list=new list([])([]); }";
		Check symbol test=new Check symbol();
		if (test.isRight(testLine)) {
			System.out.println("�﷨��ȷ");
		}else {
			System.out.println("�﷨����");
		}
		
		
	}
	
	//�ж��Ƿ���ǰ�÷���
	public boolean isBefore(char aChar)
	{
		if(aChar=='('||aChar=='{'||aChar=='[')
		{
			return true;
		}
		return false;
	}
	
	//�ж��Ƿ��Ǻ��÷���
	public boolean isBehind(char aChar)
	{
		if(aChar==')'||aChar=='}'||aChar==']')
		{
			return true;
		}
		return false;
	}
	
	//���ųɶ�,���ݺ��÷��ŵõ�ǰ�÷���
	public char diary(char aChar)
	{
		HashMap<Character, Character> dic=new HashMap<Character, Character>();
		dic.put('}', '{');
		dic.put(']', '[');
		dic.put(')', '(');
		return dic.get(aChar);
	}
	
	//�ж��﷨�Ƿ���ȷ
	public boolean isRight(String arr)
	{
		char[] charList=arr.toCharArray();
		ArrayList<Character> signList=new ArrayList<Character>();
		for(int i=0;i<charList.length;i++)
		{
			//ǰ�÷���ѹջ
			if(isBefore(charList[i]))
			{
				signList.add(charList[i]);
			}
			
			//���÷��ų�ջ���߱���
			if(isBehind(charList[i])&&diary(charList[i])==signList.get(signList.size()-1))
			{
				signList.remove(signList.size()-1);
			}else if(isBehind(charList[i])){
				return false;
			}
		}
		return true;
	}


}