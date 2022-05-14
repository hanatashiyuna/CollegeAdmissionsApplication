package com.example.collegeadmissionsapplication.Database;

public class ProfileModify {

    public static final String QUERY_CREATE_TABLE_PROFILE = "create table profile(\n" +
            "\tprofileId int, \n"+
            "\tidentitynumber int, \n"+
            "\tname varchar(150),\n"+
            "\tbirthday varchar(50),\n"+
            "\tgender varchar(10),\n"+
            "\tphone varchar(15),\n"+
            "\tidentityimg blob,\n"+
            "\tidentitybackimg blob \n"+
            ")";
}
