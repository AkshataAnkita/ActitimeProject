package com.Actitime.testscripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Actitime.genericlibrary.Baseclass;
import com.Actitime.pom.HomePage;
import com.Actitime.pom.TaskPage;

@Listeners(com.Actitime.genericlibrary.ListnerImplementation.class)
public class CreateCustomer extends Baseclass {
	
	@Test
	public void createcustomer() throws InterruptedException, EncryptedDocumentException, IOException {
		HomePage hp=new HomePage(driver);
		hp.task();
		TaskPage tp = new TaskPage(driver);
		tp.addnew();
		
	}
	

}
