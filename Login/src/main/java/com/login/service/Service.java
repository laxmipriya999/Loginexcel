package com.login.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.login.bean.Login;

@org.springframework.stereotype.Service
public class Service {
	private static Workbook wb;
	private static Sheet sh;
	private static FileInputStream fis;
	private static FileOutputStream fos;
	private static Row row;
	private static Cell cell;

	public Boolean userLogin(String username, String password) throws Exception {
		String result = null;
		fis = new FileInputStream("./Login.xlsx");
		wb = WorkbookFactory.create(fis);
		sh = wb.getSheet("sheet1");
		int noOfRows = sh.getLastRowNum();
		System.out.println(noOfRows);
		for (int i = 1; i <= noOfRows; i++) {

			System.out.println(sh.getRow(i).getCell(0));
			System.out.println(sh.getRow(i).getCell(1));

			Cell username1 = sh.getRow(i).getCell(0);
			Cell password1 = sh.getRow(i).getCell(0);
			
			if (username.toLowerCase().contentEquals(username1.toString().toLowerCase()) && password.toLowerCase().contentEquals(password1.toString().toLowerCase())) {
				System.out.println("login successful");
				return true;
			} else {    
				System.out.println("login failed");
				result = "login failed";
			}

		}
		return false;

	}
}
