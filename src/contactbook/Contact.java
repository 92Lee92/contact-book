package contactbook;

import java.util.Scanner;

public class Contact {
    String name;
    String phoneNumber;
    String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber= phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }

    public String[] getContent(Contact contact) {

        String name = this.name;
        String phoneNumber = this.phoneNumber;
        String email = this.email;

        String[] contents = new String[]{name, phoneNumber, email};
        return contents;
    }

    public void editName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 이름을 입력하세요");
        String name = scanner.next();
        this.name = name;
    }  public void editPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 전화번호를 입력하세요");
        String phoneNumber = scanner.next();
        this.phoneNumber = phoneNumber;
    }  public void editEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("새로운 이름을 입력하세요");
        String email = scanner.next();
        this.email = email;
    }


}






