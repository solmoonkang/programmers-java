package chapter1;

import chapter1.phonenumber.Person;
import chapter1.phonenumber.PhoneBook;
import chapter1.phonenumber.PhoneNumber;

public class PhoneApplication {

    public static void main(String[] args) {
        // 구현한 내용을 테스트한다.

        Person firstPerson = new Person("홍길동");
        firstPerson.addPhoneNumber(new PhoneNumber("010-1234-5678"));
        firstPerson.addPhoneNumber(new PhoneNumber("010-2345-6789"));

        Person secondPerson = new Person("홍적임");
        secondPerson.addPhoneNumber(new PhoneNumber("010-2046-5885"));

        Person thirdPerson = new Person("홍지금");
        thirdPerson.addPhoneNumber(new PhoneNumber("010-4065-2915"));

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.addPerson(firstPerson);
        phoneBook.addPerson(secondPerson);
        phoneBook.addPerson(thirdPerson);

        System.out.println(phoneBook.search(new PhoneNumber("010-2345-6789")));
        System.out.println(phoneBook.search(new PhoneNumber("010-2046-5885")));
        System.out.println(phoneBook.search(new PhoneNumber("010-4065-2915")));
        System.out.println(phoneBook.search(new PhoneNumber("010-0000-0000")));
    }
}
