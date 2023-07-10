/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repositories;

import Ultilities.DBConnection;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author 84374
 */
public class AccountDAO {

    final String INSERT_SQL = "INSERT INTO dbo.ACCOUNT(NameAcc,DOB,GENDER,IMG)VALUES(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE dbo.ACCOUNT SET NameAcc=?,DOB=?,GENDER=?,IMG=? WHERE ID=?;";
    final String DELETE_SQL = "DELETE FROM [dbo].[ACCOUNT] WHERE [ID] = ?";
    final String SELECT_BY_SQL = "SELECT * FROM [dbo].[ACCOUNT] WHERE [ID] = ?";
    final String SELECT_ALL_SQL = "SELECT * FROM [dbo].[ACCOUNT]";

    public AccountDAO() {
    }

    public void save(Account acc) {
        DBConnection dbConn = new DBConnection();
        dbConn.ExcuteDungna(INSERT_SQL, acc.getName(), acc.getDOB(), acc.getGender(), acc.getImg());
    }

    public ArrayList<Account> loadAll() {
        ArrayList<Account> lstAcc = new ArrayList<>();
        DBConnection dbConn = new DBConnection();
        try {
            ResultSet rs = dbConn.getDataFromQuery(SELECT_ALL_SQL);
            while (rs.next()) {
                lstAcc.add(new Account(rs.getString("ID"), rs.getString("NameAcc"), rs.getDate("DOB"), rs.getString("GENDER"), rs.getBytes("IMG")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return lstAcc;
    }

    public Account loadByID(String id) {
        DBConnection dbConn = new DBConnection();
        Account acc = null;
        try {
            ResultSet rs = dbConn.getDataFromQuery(SELECT_BY_SQL, id);
            acc = new Account(rs.getString("ID"), rs.getString("NameAcc"), rs.getDate("DOB"), rs.getString("GENDER"), rs.getBytes("IMG"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return acc;
    }

    public void deleteByID(String id) {
        DBConnection dbConn = new DBConnection();
        dbConn.ExcuteDungna(DELETE_SQL, id);

    }

    public void update(Account acc) {
        DBConnection dbConn = new DBConnection();
        dbConn.ExcuteDungna(UPDATE_SQL, acc.getName(), acc.getDOB(), acc.getGender(), acc.getImg(),acc.getId());
    }
}
