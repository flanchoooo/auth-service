package com.hotelMS.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;


@Entity
public class User extends AbstractAuditingEntity {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private String passwordConfirm;
    private String passwordHistory;
    private String token;
    private Integer loginTries;
    private Boolean active;
    private Access accessByAccessId;
    private Integer referenceId;
    private Integer accessId;
    private Integer companyId;
    public String dateOfBirth;
    public String gender;
    public String nationality;
    public String phoneNumber;
    public String reference;
    private String userType;
    private String role;
    private String uploadImage;
    private String archiveUser;
    private String city;
    private String state;
    private String zipCode;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstname", nullable = false, length = 64)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "lastname", nullable = false, length = 64)
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 64, unique = true)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 64, unique = true)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "password_confirm", nullable = true, length = 255)
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @Basic
    @Column(name = "password_history", nullable = true, length = 1096)
    public String getPasswordHistory() {
        return passwordHistory;
    }

    public void setPasswordHistory(String passwordHistory) {
        this.passwordHistory = passwordHistory;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 128)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "nationality", nullable = true, length = 128)
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Basic
    @Column(name = "phoneNumber", nullable = true, length = 128, unique = true)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Basic
    @Column(name = "reference", nullable = true, length = 128)
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }



    @Basic
    @Column(name = "dateOfBirth", nullable = true, length = 128)
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "token", nullable = true, length = 128)
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "login_tries", nullable = false)
    public Integer getLoginTries() {
        return loginTries;
    }

    public void setLoginTries(Integer loginTries) {
        this.loginTries = loginTries;
    }

    @Basic
    @Column(name = "active", nullable = false)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Basic
    @Column(name = "reference_id", nullable = true, unique = true)
    public Integer getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Integer referenceId) {
        this.referenceId = referenceId;
    }

    @ManyToOne
    @JsonBackReference(value = "access-user")
    @JoinColumn(name = "access_id", referencedColumnName = "id", insertable = false, updatable = false)
    public Access getAccessByAccessId() {
        return accessByAccessId;
    }

    public void setAccessByAccessId(Access accessByAccessId) {
        this.accessByAccessId = accessByAccessId;
    }

    @Basic
    @Column(name = "access_id", nullable = true)
    public Integer getAccessId() {
        return accessId;
    }

    public void setAccessId(Integer accessId) {
        this.accessId = accessId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(accessId, user.accessId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessId);
    }

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "user_type", nullable = true, length = 128)
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 128)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Basic
    @Column(name = "upload_image", nullable = true, length = 128)
    public String getUploadImage() {
        return uploadImage;
    }

    public void setUploadImage(String uploadImage) {
        this.uploadImage = uploadImage;
    }

    @Basic
    @Column(name = "city", nullable = true, length = 128)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "state", nullable = true, length = 128)
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Basic
    @Column(name = "zip_code", nullable = true, length = 128)
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Basic
    @Column(name = "archive_user", nullable = true, length = 128)
    public String getArchiveUser() {
        return archiveUser;
    }

    public void setArchiveUser(String archiveUser) {
        this.archiveUser = archiveUser;
    }





}
