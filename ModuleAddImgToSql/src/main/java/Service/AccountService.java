/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Repositories.AccountDAO;
import java.util.ArrayList;
import model.Account;

/**
 *
 * @author 84374
 */
public class AccountService {
    
    public AccountService() {
    }
    
    public void save(Account acc){
        AccountDAO accDAO = new AccountDAO();
        accDAO.save(acc);
    }
    
    public ArrayList<Account> loadAll(){
        AccountDAO accDAO = new AccountDAO();
        return accDAO.loadAll();
    }
    
    public Account loadByID(String id){
        AccountDAO accDAO = new AccountDAO();
        return accDAO.loadByID(id);
    }
    
    public void delete(String id){
        AccountDAO accDAO = new AccountDAO();
        accDAO.deleteByID(id);
    }
}
