package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.Dao.DaoFactory;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		SellerDao sellerDao = DaoFactory.createSellerDao();
		Scanner sc = new Scanner(System.in);

		System.out.println("TESTE 1 = FindById");
		Seller seller = sellerDao.findById(7);
		System.out.println(seller);

		System.out.println("TESTE 2 = FindByDepartment");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		list.forEach(System.out::println);

		System.out.println("TESTE 3 = FindAll");
		list = sellerDao.findAll();
		list.forEach(System.out::println);

		System.out.println("TESTE 4 = INSERT");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, new Department(4, null));
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Id: " + newSeller.getId());

		System.out.println("TESTE 5 = UPDATE");
		seller = sellerDao.findById(8);
		seller.setEmail("Lucas@gmail.com");
		sellerDao.update(seller);
		System.out.println("Atualizado! Id: " + seller.getId());

		System.out.println("TESTE 6 = DELETE");
		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted! Id: " + id);
		sc.close();

	}

}
