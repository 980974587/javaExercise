package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class CheckSymbol{
	public static void main(String[] args) {
	
		String testLine="{ int[] list=new list([])([]); }";
		Check symbol test=new Check symbol();
		if (test.isRight(testLine)) {
			System.out.println("语法正确");
		}else {
			System.out.println("语法错误");
		}
		
		
	}
	
	//判断是否是前置符号
	public boolean isBefore(char aChar)
	{
		if(aChar=='('||aChar=='{'||aChar=='[')
		{
			return true;
		}
		return false;
	}
	
	//判断是否是后置符号
	public boolean isBehind(char aChar)
	{
		if(aChar==')'||aChar=='}'||aChar==']')
		{
			return true;
		}
		return false;
	}
	
	//符号成对,根据后置符号得到前置符号
	public char diary(char aChar)
	{
		HashMap<Character, Character> dic=new HashMap<Character, Character>();
		dic.put('}', '{');
		dic.put(']', '[');
		dic.put(')', '(');
		return dic.get(aChar);
	}
	
	//判断语法是否正确
	public boolean isRight(String arr)
	{
		char[] charList=arr.toCharArray();
		ArrayList<Character> signList=new ArrayList<Character>();
		for(int i=0;i<charList.length;i++)
		{
			//前置符号压栈
			if(isBefore(charList[i]))
			{
				signList.add(charList[i]);
			}
			
			//后置符号出栈或者报错
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