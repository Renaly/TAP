package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Atv1 {
	public static final String TELEFONE_REGEX = "(\\(\\d{2}\\))?(9?\\d{4})-?(\\d{4})";
	public static final String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String CNPJ_REGEX = "(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)";
	public static final String CPF_REGEX = "(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)";
	
	public static void main(String[] args) {
		
		String informe = "";
		Scanner ler = new Scanner(System.in);
		
		System.out.printf("\nInforme o que deseja:\n");
		informe = ler.nextLine();
		
		Pattern emailPattern = Pattern.compile(EMAIL_REGEX);
		System.out.println(emailPattern.matcher(informe).matches());
		
		Pattern telefonePattern = Pattern.compile(TELEFONE_REGEX);
		System.out.println(telefonePattern.matcher(informe).matches());
		
		Pattern cpfPattern = Pattern.compile(CPF_REGEX);
		System.out.println(cpfPattern.matcher(informe).matches());
		
		Pattern cnpjPattern = Pattern.compile(CNPJ_REGEX);
		System.out.println(cnpjPattern.matcher(informe).matches());
		
	}
}
