package com.example.ruslanmanca.myhealthvolkov.models.database;

/**
 * Created by RuslanManca on 17/11/2017.
 */

public class Person {
    long idPerson;
    String nomPerson;
    String prenomPerson;
    long agePerson;
    Float poidsPerson;
    String dateMajPerson;
    String loginPerson;

    public Person(){}

    public Person(long idPerson, String nomPerson, String prenomPerson, long agePerson, Float poidsPerson, String dateMajPerson, String loginPerson) {
        this.idPerson = idPerson;
        this.nomPerson = nomPerson;
        this.prenomPerson = prenomPerson;
        this.agePerson = agePerson;
        this.poidsPerson = poidsPerson;
        this.dateMajPerson = dateMajPerson;
        this.loginPerson = loginPerson;
    }

    public long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(long idPerson) {
        this.idPerson = idPerson;
    }

    public String getNomPerson() {
        return nomPerson;
    }

    public void setNomPerson(String nomPerson) {
        this.nomPerson = nomPerson;
    }

    public String getPrenomPerson() {
        return prenomPerson;
    }

    public void setPrenomPerson(String prenomPerson) {
        this.prenomPerson = prenomPerson;
    }

    public long getAgePerson() {
        return agePerson;
    }

    public void setAgePerson(long agePerson) {
        this.agePerson = agePerson;
    }

    public Float getPoidsPerson() {
        return poidsPerson;
    }

    public void setPoidsPerson(Float poidsPerson) {
        this.poidsPerson = poidsPerson;
    }

    public String getDateMajPerson() {
        return dateMajPerson;
    }

    public void setDateMajPerson(String dateMajPerson) {
        this.dateMajPerson = dateMajPerson;
    }

    public String getLoginPerson() {
        return loginPerson;
    }

    public void setLoginPerson(String loginPerson) {
        this.loginPerson = loginPerson;
    }
}
