package application;

import java.util.List;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("TESTE 1 = FindById");
		Department dept = depDao.findById(3);
		System.out.println(dept);

		System.out.println("TESTE 2 = FindAll");
		List<Department> list = depDao.findAll();
		list.forEach(System.out::println);

		System.out.println("TESTE 3 = INSERT");
		Department newDep = new Department(12, "Clothes");
		depDao.insert(newDep);
		System.out.println("Inserido! Id: " + newDep.getId());

		System.out.println("TESTE 4 = UPDATE");
		dept = depDao.findById(6);
		dept.setName("Foods");
		depDao.update(dept);
		System.out.println("Atualizado! Id: " + dept.getId());

		System.out.println("TESTE 5 = DELETE");
		int id = sc.nextInt();
		depDao.deleteById(id);
		System.out.println("Deleted! Id: " + id);
		sc.close();

	}

}
