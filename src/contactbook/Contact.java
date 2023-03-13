package contactbook;

public class Contact {
    Name name;
    PhoneNumber phoneNumber;
    Email email;

    public Contact(Name name) {
        this.name = name;
    }

    public Contact(PhoneNumber phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public Contact(Email email){
        this.email = email;
    }

    public Contact (Name name, PhoneNumber phoneNumber){
        this.name=name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(Name name, Email email) {
        this.name = name;
        this.email = email;
    }

    public Contact(PhoneNumber phoneNumber, Email email) {
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(Name name, PhoneNumber phoneNumber, Email email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Contact(String name, String phoneNumber,String email) {
        this.name = new Name(name);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.email = new Email(email);
    }

    public String getName() {
        return name.getName();
    }

    public void setName(String name) {
        this.name.setName(name);
    }

    public String getPhoneNumber() {
        return phoneNumber.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber.setPhoneNumber(phoneNumber);
    }

    public String getEmail() {
        return email.getEmail();
    }

    public void setEmail(String email) {
        this.email.setEmail(email);
    }
    public String[] getContactContent(Contact contact) {

        String name = contact.getName();
        String phoneNumber = contact.getPhoneNumber();
        String email = contact.getEmail();

        String[] contents = new String[] {name, phoneNumber,email};
        return contents;
        }
    }





