package com.spring.demo;

import com.spring.component.MyClass1;
import com.spring.component.MyClass2;
import com.spring.component.MyClass3;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) throws InterruptedException, IOException {
       ApplicationContext applicationContext = new ClassPathXmlApplicationContext("transactional-spring-config.xml");
// Question 2 Spring Transaction
//        AccountService accountService=applicationContext.getBean(AccountService.class);
//        accountService.insertUserAccount();
//        accountService.readUserAccount();
//        accountService.updateUserAccount();
//        accountService.deleteUserAccount();

        UserAccountService userAccountService= applicationContext.getBean(UserAccountService.class);
        int balanceToTransfer=5000;

        UserAccount userAccount = new UserAccount();
        userAccount.setName("TANUJ");
        userAccount.setBalance(10000);
      //  userAccountService.insertUser(userAccount);

        UserAccount userAccount2= new UserAccount();
        userAccount2.setName("ANKUR");
        userAccount2.setBalance(20000);
    //    userAccountService.insertUser(userAccount2);

        UserAccount userAccount3 = new UserAccount();
        userAccount3.setName("Meeral");
        userAccount3.setBalance(45000);
  //      userAccountService.insertUser(userAccount3);

        UserAccount userAccount4 = new UserAccount();
        userAccount4.setName("Shubham");
       userAccount4.setBalance(50000);
//        userAccountService.insertUser(userAccount4);

//        Question 3
//        userAccountService.updateUserUsingProgrammaticTransaction(userAccount,userAccount2,balanceToTransfer);
//
        //Question 4
    /*    userAccountService.readAllUser();
        userAccountService.updateUser(userAccount,userAccount2,balanceToTransfer);
        userAccountService.readTransactions();
        userAccountService.updateUser(userAccount2,userAccount3,balanceToTransfer);
        userAccountService.readTransactions();
        userAccountService.updateUser(userAccount3,userAccount4,balanceToTransfer);
        userAccountService.readTransactions();
        userAccountService.readAllUser();
*/

        userAccountService.updateUser(userAccount,userAccount4,balanceToTransfer);

        userAccountService.readAllUser();

        userAccountService.updateUser(userAccount2,userAccount3,balanceToTransfer);
        userAccountService.readAllUser();
        userAccountService.updateUser(userAccount4,userAccount,balanceToTransfer);
        userAccountService.readAllUser();
        userAccountService.readTransactions();


        System.out.println("Done");
    /*  ApplicationContext applicationContext2 = new ClassPathXmlApplicationContext("transactional-spring-config.xml");
      MyClass1 myClass1 =(MyClass1)applicationContext2.getBean("myclass1");
      myClass1.display();*/
//      myClass1.display4(2);
/*    /*    MyClass2 myClass2 =(MyClass2)applicationContext2.getBean("myclass2");
        myClass1.display();
        MyClass3 myClass3 =(MyClass3)applicationContext2.getBean("myclass3");
        myClass1.display();*/

    }
}
