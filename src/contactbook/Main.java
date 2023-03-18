package contactbook;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        ContactBook contactBook = new ContactBook();
        contactBook.load();
        int menu = 0;
        RUN: while(true){
            menu = mainMenu();
            switch (menu){
                case 1:
                    contactBook.addContact();
                    break;
                case 2:
                    contactBook.print();
                    break;
                case 3:
                    contactBook.editMenu();
                    break;
                case 4:
                    contactBook.findByName();
                    break;
                case 5:
                    contactBook.deleteMenu();
                    break;
                case 6:
                    System.out.println("프로그램을 종료합니다.");
                    break RUN;
            }
        }


        contactBook.print();
    }
    public static int mainMenu(){
        System.out.println("----------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하시는 메뉴를 선택해주세요 ");
        System.out.println("1.연락처 입력\t2.연락처 조회\t3.연락처 수정\n4.연락처 검색\t5.연락처 삭제" );
        System.out.print(">");
        int menu = scanner.nextInt();
        return menu;
    }
}
