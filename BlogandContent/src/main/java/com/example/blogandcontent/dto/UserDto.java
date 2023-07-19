package com.example.blogandcontent.dto;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class UserDto implements Validator {

    private String firstName;

    private String lastName;
    private String phoneNumber;

    private int age;
    private String email;

    public UserDto(String firstname, String lastname, String phoneNumber, int age, String email) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {

    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getFirstName().isEmpty()) {
            errors.rejectValue("firstName", null, "fistName khong duoc de trong");
        }else if (userDto.getLastName().isEmpty()) {
            errors.rejectValue("lastName", null, "lastName khong duoc de trong");
        }else if (userDto.getEmail().isEmpty()) {
                errors.rejectValue("email", null, "email khong duoc de trong");
        }else if (!userDto.getFirstName().matches("^(?=.{5,45}).*$") & userDto.getLastName().matches("^(?=.{5,45}).*$")) {
            errors.rejectValue("firstName", null, "lastname and firstname it nhat 5 ki tu va nhieu nhat 45 ki tu");
        }else if (!userDto.getPhoneNumber().matches("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")) {
            errors.rejectValue("phoneNumber", null, "Số điện thoại gồm 10 số nếu có nhập số 0 ở đầu tiên. Nếu không nhập 0 thì còn 9 số.");
        }else if (userDto.getAge() < 18) {
            errors.rejectValue("age", null, "age >= 18");
        }

    }
}