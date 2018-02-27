package function;

/**
 * EL函数
 * 需要在tld文件中配置后才能使用
 * 使用格式：
 * ${prefix:functionName(paramList)}
 * @author Peter Liu
 *
 */
public class StringFunctions {
	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
