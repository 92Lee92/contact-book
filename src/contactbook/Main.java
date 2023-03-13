package contactbook;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ContactBook contactBook = new ContactBook();
        contactBook.loadContactBook();
        int menu = 0;
        RUN: while(true){
            System.out.println("===========주소록 프로그램===========");
            System.out.println(contactBook.getContacts().size()+"개의 자료가 있습니다.");
            System.out.println("----------------------------------");
            Scanner scanner = new Scanner(System.in);
            System.out.println("원하시는 메뉴를 선택해주세요 ");
            System.out.println("1.연락처 입력\t2.연락처 조회\t3.연락처 수정\n4.연락처 검색\t5.연락처 삭제" );
            System.out.print(">");
            menu = scanner.nextInt();
            switch (menu){
                case 1:
                    contactBook.addContact();
                    break;
                case 2:
                    contactBook.printContactBook();
                    break;
                case 3:
                    contactBook.editMenu();
                    break;
                case 4:
                    System.out.println("검색할 이름을 입력하세요.");
                    String name = scanner.next();
                    ArrayList<Contact> nameSearchResult = contactBook.findByName(name);
                    contactBook.printContactList(nameSearchResult);
                    break;
                case 5:
                    contactBook.deleteMenu();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break RUN;
            }
        }


        contactBook.printContactBook();
    }

}
