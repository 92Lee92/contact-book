package contactbook;

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

    public void addContact(Contact contact) {
        contacts.add(contact);
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

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
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

    public void print(ArrayList<Contact> contacts) {
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

    public void save() throws FileNotFoundException {
        String fileName = "res/contactbook.csv";
        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        PrintStream printStream = new PrintStream(fileOutputStream);

        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);

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

    public void findByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 이름을 입력하세요.");
        String name = scanner.next();
        ArrayList<Contact> nameSearchResult = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(name)) {
                nameSearchResult.add(contact);
            }
        }
        print(nameSearchResult);
    }

    public void findByphoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("검색할 전화번호를 입력하세요.");
        String phoneNumber = scanner.next();
        ArrayList<Contact> numberSearchResult = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            Contact contact = contacts.get(i);
            if (contact.getName().equals(phoneNumber)) {
                numberSearchResult.add(contact);
            }
        }
        print(numberSearchResult);
    }

    public void editMenu() throws FileNotFoundException {
        System.out.println("연락처 수정");
        String name = "0";
        print();

        System.out.println("수정할 연락처의 번호를 입력하세요");
        Scanner scanner = new Scanner(System.in);
        int toEdit = scanner.nextInt();

        Contact toEditContact = contacts.get(toEdit - 1);
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
        save();
    }

    private void deleteContact(Contact toDeleteContact) {
        contacts.remove(toDeleteContact);
    }

    public void deleteMenu() throws FileNotFoundException {
        System.out.println("연락처 삭제");
        Scanner scanner = new Scanner(System.in);
        String name = "0";
        print();

        System.out.println("삭제할 연락처의 번호를 입력하세요");
        int toDelete = scanner.nextInt();

        Contact toEditContact = contacts.get(toDelete - 1);
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

}





