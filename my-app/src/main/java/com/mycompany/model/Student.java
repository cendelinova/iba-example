/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.model;

import java.util.Date;
import java.util.Objects;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Petra
 */
public class Student {
    private Long id;
    
    @Pattern(regexp = "[a-zA-Z]+", message = "The field must contain only characters.")
    @Length(min = 1, max = 60, message = "This field must be between 1 and 60 characters.")
    @NotEmpty(message = "This field is required.")
    private String name;

    
    @Pattern(regexp = "[a-zA-Z]+", message = "The field must contain only characters.")
    @Length(min = 1, max = 60, message = "This field must be between 1 and 60 characters.")
    @NotEmpty(message = "This field is required.")
    private String surname;
    
    @Past(message = "Your birthday cannot be a future date.")
    @NotNull(message = "This field is required.")
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthday;
    
    private Gender gender;

    public Student() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.name);
        hash = 29 * hash + Objects.hashCode(this.surname);
        hash = 29 * hash + Objects.hashCode(this.birthday);
        hash = 29 * hash + Objects.hashCode(this.gender);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        if (this.gender != other.gender) {
            return false;
        }
        return true;
    }

}
