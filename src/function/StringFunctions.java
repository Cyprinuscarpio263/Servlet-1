package function;

/**
 * EL����
 * ��Ҫ��tld�ļ������ú����ʹ��
 * ʹ�ø�ʽ��
 * ${prefix:functionName(paramList)}
 * @author Peter Liu
 *
 */
public class StringFunctions {
	public static String reverseString(String s) {
		return new StringBuilder(s).reverse().toString();
	}
}
