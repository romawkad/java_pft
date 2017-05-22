package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String homephone;
    private final String mobilephone;
    private final String workphone;
    private final String fax;
    private final String mail1;
    private final String mail2;
    private final String mail3;
    private final String homepage;
    private final String year;
    private final String notes;
    private final String address2;
    private final String phone2;

    public ContactData(String firstname, String middlename, String lastname, String nickname, String title, String company, String address, String homephone, String mobilephone, String workphone, String fax, String mail1, String mail2, String mail3, String homepage, String year, String notes, String address2, String phone2) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homephone = homephone;
        this.mobilephone = mobilephone;
        this.workphone = workphone;
        this.fax = fax;
        this.mail1 = mail1;
        this.mail2 = mail2;
        this.mail3 = mail3;
        this.homepage = homepage;
        this.year = year;
        this.notes = notes;
        this.address2 = address2;
        this.phone2 = phone2;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomephone() {
        return homephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getWorkphone() {
        return workphone;
    }

    public String getFax() {
        return fax;
    }

    public String getMail1() {
        return mail1;
    }

    public String getMail2() {
        return mail2;
    }

    public String getMail3() {
        return mail3;
    }

    public String getHomepage() {
        return homepage;
    }

    public String getYear() {
        return year;
    }

    public String getNotes() {
        return notes;
    }

    public String getAddress2() {
        return address2;
    }

    public String getPhone2() {
        return phone2;
    }
}
