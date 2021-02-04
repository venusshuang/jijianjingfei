/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jijianjingfei.util;

/**
 * 
 * @author Administrator
 */
public class StringHandle {



	final static String paNon = "^\\d+$";
	final static String paEmail = "^[a-z A-Z 0-9 _]+@[a-z A-Z 0-9 _]+(\\.[a-z A-Z 0-9 _]+)+(\\,[a-z A-Z 0-9 _]+@[a-z A-Z 0-9 _]+(\\.[a-z A-Z 0-9 _]+)+)*$";
	final static String paLoginname = "^[a-zA-Z0-9][a-zA-Z0-9_]{1,19}$";
	final static String paIdcardNo = "^\\d{17}[\\dX]$";
	final static String paMobilePhone = "^1\\d{10}$";

	// public static String ConvertToShort(String ppSource) {
	// return ConvertToShort(ppSource,18);
	// }
	// 截取过长字符串（原字符串，想要的长度）
	public static String ConvertToShort(String ppSource, int ppLength) {
		return ConvertToShort(ppSource, ppLength, true);
	}

	public static int getStringByteLength(String ppStr) {
		return ppStr.getBytes().length;
	}

	public static String ConvertToShort(String ppSource, int ppByteLength,
			boolean ppShowDot) {
		String ppTarget = "";
		int mmCurrentLength = 0;

		try {
			for (int i = 0; i < ppSource.length(); i++) {
				String mmStr = ppSource.substring(i, i + 1);
				byte[] tempbyte = mmStr.getBytes();

				if ((mmCurrentLength + tempbyte.length) <= ppByteLength) {
					ppTarget += mmStr;
					mmCurrentLength += tempbyte.length;
				} else {
					ppTarget += "...";
					break;
				}
			}
			return ppTarget;
		} catch (Exception e) {
		}
		return ppTarget;
	}




	// 非负整数
	public static boolean isNon(String s){
		return s.matches(paNon);
	}

	// 电子邮箱
	// 只能是字母、数字、下划线；必须有@和.同时格式要规范
	public static boolean isEmail(String s){
		return s.matches(paEmail);
	}

	// 登录用户名
	// 匹配帐号是否合法(字母开头，允许2-20字节，允许字母数字下划线)
	public static boolean isLoginName(String s){
		return s.matches(paLoginname);
	}

	// 身份证号码
	public static boolean isIdcardNo(String s){
		return s.matches(paIdcardNo);
	}

	// 手机号码
	public static boolean isMobilePhone(String s){
		return s.matches(paMobilePhone);
	}

//	public static void main(String[] args) {
//		System.out.println(isIdcardNo("320926197803212345"));
////		System.out.println(isMobilePhone("13584098002"));
//	}

}
