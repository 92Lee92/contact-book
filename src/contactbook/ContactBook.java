package contactbook;

import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {
    private ArrayList<Contact> contacts;

    public ContactBook() {
        contacts = new ArrayList<>();
    }

    public void addContact() throws FileNotFoundException {

        System.out.println("연락처 입력");
        Scanner scanner = new Scanner(System.in);

        System.out.print("이름 > ");
        String name = scanner.nextLine();
        System.out.print("전화번호 > ");
        String phoneNumber = scanner.nextLine();
        System.out.print("이메일 > ");
        String email = scanner.nextLine();

        Contact contact = new Contact(name, phoneNumber, email);
        contacts.add(contact);

        save();
    }

    public void print() {
        System.out.println("----------------------------------");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            String name = contact.getName();
            String phoneNumber = contact.getPhoneNumber();
            String email = contact.getEmail();
            System.out.printf("번호: %d\n이름: %s\n전화번호: %s\n이메일: %s\n", i + 1, name, phoneNumber, email);
            if (i != contacts.size() - 1)
                System.out.println("----------------------------------");
        }
    }

    public void print(@NotNull ArrayList<Contact> contacts) {
        System.out.println("----------------------------------");
        if(contacts.size()==0)
            System.out.println("검색 결과가 없습니다.");
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            String name = contact.getName();
            String phoneNumber = contact.getPhoneNumber();
            String email = contact.getEmail();
            System.out.printf("번호: %d\n이름: %s\n전화번호: %s\n이메일: %s\n", i + 1, name, phoneNumber, email);
            if (i != contacts.size() - 1)
                System.out.println("----------------------------------");
        }
    }

    public void save() throws FileNotFoundException {
        String fileName = "res/contactbook.csv";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        PrintStream printStream = new PrintStream(fileOutputStream);

        for (Contact contact : contacts) {
            String[] contents = contact.getContent(contact);
            String name = contents[0];
            String phoneNumber = contents[1];
            String email = contents[2];
            printStream.printf("%s,%s,%s\n", name, phoneNumber, email);
        }
    }

    public void load() throws FileNotFoundException {
        String fileName = "res/contactbook.csv";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fileInputStream);

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            String name = tokens[0];
            String phoneNumber = tokens[1];
            String email = tokens[2];
            Contact contact = new Contact(name, phoneNumber, email);
            contacts.add(contact);
        }
    }
    public ArrayList<Contact> findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 이름을 입력하세요.");
        String name = scanner.next();
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getName().contains(name)) {
                result.add(contact);
            }
        }
        print(result);
        return result;
    }

    public ArrayList<Contact> findByphoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 전화번호를 입력하세요.");
        String phoneNumber = scanner.next();
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getPhoneNumber().contains(phoneNumber)) {
                result.add(contact);
            }
        }
        print(result);
        return result;
    }

    public ArrayList<Contact> findByEmail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 이메일을 입력하세요.");
        String email = scanner.next();
        ArrayList<Contact> result = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getEmail().contains(email)) {
                result.add(contact);
            }
        }
        print(result);
        return result;
    }

    public void editMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연락처 수정");
        MENU:while(true){
            System.out.println("1.이름으로 검색\t2.전화번호로 검색\t3.이메일로검색\t4.전체 목록 조회\t5.종료");
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    ArrayList<Contact> res = findByName();
                    if(res.size()!=0)
                        editSubMenu(res);
                    break;
                case 2:
                    res =findByphoneNumber();
                    if(res.size()!=0)
                        editSubMenu(res);
                    break;
                case 3:
                    res =findByEmail();
                    if(res.size()!=0)
                        editSubMenu(res);
                    break;
                case 4:
                    print();
                    editSubMenu();
                case 5:
                    break MENU;
            }
        }
        save();
    }
    public void deleteMenu() throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("연락처 수정");
        MENU:while(true){
            System.out.println("1.이름으로 검색\t2.전화번호로 검색\t3.이메일로검색\t4.전체 목록 조회\t5.종료");
            int menu = scanner.nextInt();
            switch (menu){
                case 1:
                    ArrayList<Contact> res = findByName();
                    if(res.size()!=0)
                        deleteSubMenu(res);
                    break;
                case 2:
                    res =findByphoneNumber();
                    if(res.size()!=0)
                        deleteSubMenu(res);
                    break;
                case 3:
                    res =findByEmail();
                    if(res.size()!=0)
                        deleteSubMenu(res);
                    break;
                case 4:
                    print();
                    deleteSubMenu();
                    break;
                case 5:
                    break MENU;
            }
        }

        save();
    }

    private void deleteContact(Contact toDeleteContact) {
        contacts.remove(toDeleteContact);
    }

    public void deleteSubMenu() throws FileNotFoundException {
        System.out.println("연락처 삭제");
        Scanner scanner = new Scanner(System.in);

        System.out.println("삭제할 연락처의 번호를 입력하세요");
        int idx = scanner.nextInt()-1;

        Contact toEditContact = contacts.get(idx);
        System.out.println("1.삭제 2.취소");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                deleteContact(toEditContact);
                break;
            case 2:
                break;
        }
        save();
    }
    public void deleteSubMenu(@NotNull ArrayList<Contact> contacts) throws FileNotFoundException {
        System.out.println("연락처 삭제");
        Scanner scanner = new Scanner(System.in);

        System.out.println("삭제할 연락처의 번호를 입력하세요");
        int idx = scanner.nextInt()-1;

        Contact toEditContact = contacts.get(idx);
        System.out.println("1.삭제 2.취소");
        int editMenu = scanner.nextInt();
        switch (editMenu) {
            case 1:
                deleteContact(toEditContact);
                break;
            case 2:
                break;
        }
        save();
    }

    public void editSubMenu(){
        System.out.println("수정할 연락처의 번호를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int idx = scanner.nextInt() - 1;

        Contact toEditContact = contacts.get(idx);
        System.out.println("1.이름 수정  2.전화번호 수정 3.이메일 수정 4. 취소");
        int editMenu = scanner.nextInt();
        switch (editMenu) {
            case 1:
                toEditContact.editName();
                break;
            case 2:
                toEditContact.editPhoneNumber();
                break;
            case 3:
                toEditContact.editEmail();
                break;
            case 4:
                break;
        }
    }
    public void editSubMenu(@NotNull ArrayList<Contact> contacts){
        System.out.println("수정할 연락처의 번호를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int idx = scanner.nextInt() - 1;

        Contact toEditContact = contacts.get(idx);
        System.out.println("1.이름 수정  2.전화번호 수정 3.이메일 수정 4. 취소");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                toEditContact.editName();
                break;
            case 2:
                toEditContact.editPhoneNumber();
                break;
            case 3:
                toEditContact.editEmail();
                break;
            case 4:
                break;
        }
    }
}





