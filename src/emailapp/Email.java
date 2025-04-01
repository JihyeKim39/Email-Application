package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;  //기본 메일 용량
	private String alternateEmail;
	private String email;
	private String companySuffix = "jpdocomo.com";
	
	// constructor to receive the first / last name 
	public Email (String firstName, String lastName) {
		this.firstName =  firstName;
		this.lastName = lastName;
		//System.out.println("Email Created: " + this.firstName + " " + this.lastName);
	
	// Call a method asking for the department = return the department
		this.department = setDepartment();
		System.out.println("Department: " + this.department);
		
	// Call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength); // 비밀번호 길이 값 전달 
		System.out.println("Your password is: " + this.password);
		
	// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
		System.out.println("Your email is: " + email);
	}
	
	// Ask for the department *비공개로 하고 싶은 경우
	private String setDepartment() {
		System.out.print("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner in = new Scanner(System.in);
		int depChoice = in.nextInt(); // 1) int 를 가져오고 싶다.
		// 2) int depChoice = 부서 선택하는 것 (숫자 입력) 사람들은 0 or 1 을 입력할 것이다
		if (depChoice == 1) {return "sales";}
		else if (depChoice == 2) { return "dev";}
		else if (depChoice == 3) { return "acct"; }
		else { return ""; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@$";
		char[] password = new char[length];
		for (int i=0; i<length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		} //생성한 다음 비밀번호 반환하기 
		return new String(password);
	}
	
	// set the mailbox capacity 
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// set the alternate email
	public void setAlternateEmail(String alteEmail) {
		this.alternateEmail = alteEmail;
	}
	
	// change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return mailboxCapacity;} //메일사서함 용량 반환
	public String getAlternateEmail() { return alternateEmail; } //메일변경할 수 있게 해주는거 get 으로 가져오기
	public String getPassword() { return password;} //비밀번호 변경할 수 있게 해주기 
	
	public String showInfo() {  //이름, 이메일, 사서함 용량 출력되게 하기
		return "\n" +"< All the info >" + "\n" + "Display Name: " + firstName + " " + lastName + "\n" +
				"Company Email: " + email + "\n" +
				"Mailbox Capacity: " + mailboxCapacity + "mb";
	}
}
