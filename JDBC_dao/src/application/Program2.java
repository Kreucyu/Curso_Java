package application;

import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("TESTE 5 = DELETE");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Deleted! Id: " + id);
		sc.close();

	}

}
