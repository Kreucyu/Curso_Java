package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import db.InputException;
import model.Dao.DaoFactory;
import model.Dao.DepartmentDao;
import model.Dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		new Program().firstChoice();
	}

	public Program() {
	}

	public void firstChoice() {
		Scanner sc = new Scanner(System.in);
		SellerDao sellerDao = DaoFactory.createSellerDao();
		DepartmentDao depDao = DaoFactory.createDepartmentDao();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Seller> list = new ArrayList<>();
		List<Department> listD = new ArrayList<>();
		boolean choiceTrue = false;
		while (!choiceTrue) {
			try {
				System.out.println("O você que deseja fazer?\n");
				System.out.println("1 - Gerenciar vendedores");
				System.out.println("2 - Gerenciar departamentos");
				System.out.println("3 - Sair do programa\n");
				Integer option = sc.nextInt();
				if (option == 1 || option == 2 || option == 3) {
					choiceTrue = true;
				}
				switch (option) {
				case 1:
					choiceTrue = false;
					sellerManager(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 2:
					choiceTrue = false;
					departmentManager(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 3:
					exit(sc);
					break;

				default:
					throw new InputException("Opção inválida, tente novamente!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir\n");
				sc.nextLine();
			} catch (InputException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir\n");
				sc.nextLine();
			}
		}
	}

	public void sellerManager(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
			try {
				clearScreen();
				System.out.println("\nO você que deseja fazer?\n");
				System.out.println("1 - Inserir novo vendedor");
				System.out.println("2 - Atualizar os dados de um funcionário");
				System.out.println("3 - Deletar um vendedor");
				System.out.println("4 - Encontrar um vendedor por id");
				System.out.println("5 - Ecnontrar um vendedor por departamento");
				System.out.println("6 - Listar todos os funcionários");
				System.out.println("7 - Retornar a tela escolhas");
				System.out.println("8 - Sair do programa\n");
				Integer option = sc.nextInt();
				if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6
						|| option == 7 || option == 8) {
					choiceTrue = true;
				}
				switch (option) {
				case 1:
					choiceTrue = false;
					insertSeller(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 2:
					choiceTrue = false;
					updateSeller(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 3:
					choiceTrue = false;
					deleteSeller(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 4:
					choiceTrue = false;
					findSellerById(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 5:
					choiceTrue = false;
					findSellerByDepartment(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 6:
					choiceTrue = false;
					listAllSellers(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 7:
					tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 8:
					exit(sc);
					break;

				default:
					throw new InputException("Opção inválida, tente novamente!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			} catch (InputException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			}
		}
	}

	public void departmentManager(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
			try {
				clearScreen();
				System.out.println("\nO você que deseja fazer?\n");
				System.out.println("1 - Inserir novo departamento");
				System.out.println("2 - Atualizar os dados de um departamento");
				System.out.println("3 - Deletar um departamento");
				System.out.println("4 - Encontrar um departamento por id");
				System.out.println("5 - Listar todos os departamentos");
				System.out.println("6 - Retornar a tela escolhas");
				System.out.println("7 - Sair do programa\n");
				Integer option = sc.nextInt();
				if (option == 1 || option == 2 || option == 3 || option == 4 || option == 5 || option == 6
						|| option == 7) {
					choiceTrue = true;
				}

				switch (option) {
				case 1:
					choiceTrue = false;
					insertDepartment(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 2:
					choiceTrue = false;
					updateDepartment(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 3:
					choiceTrue = false;
					deleteDepartment(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 4:
					choiceTrue = false;
					findDepartmentById(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 5:
					choiceTrue = false;
					findAllDepartments(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 6:
					tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;

				case 7:
					exit(sc);
					break;

				default:
					throw new InputException("Opção inválida, tente novamente!");
				}

			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			} catch (InputException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			}
		}
	}

	public void tryAgain(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list, DepartmentDao depDao,
			List<Department> listD, boolean choiceTrue) {
		choiceTrue = false;
		while (!choiceTrue) {
			try {
				clearScreen();
				System.out.println("\nO que deseja fazer?\n");
				System.out.println("1 - Gerenciar vendedores");
				System.out.println("2 - Gerenciar departamentos");
				System.out.println("3 - Sair do programa\n");
				Integer option = sc.nextInt();
				if (option == 1 || option == 2 || option == 3) {
					choiceTrue = true;
				}
				switch (option) {
				case 1:
					choiceTrue = false;
					sellerManager(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;
				case 2:
					choiceTrue = false;
					departmentManager(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
					break;
				case 3:
					exit(sc);
					break;
				default:
					System.out.println("\nOpção inválida, tente novamente!");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			} catch (InputException e) {
				System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
				sc.nextLine();
			}
		}
	}

	public void insertSeller(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nInsira o id do seu vendedor: ");
			Integer id = sc.nextInt();
			choiceTrue = true;
			System.out.print("\nInsira o nome do seu vendedor: ");
			String name = sc.next();
			String secondName = sc.next();
			String fullName = name + " " + secondName;
			sc.nextLine();
			System.out.print("\nInsira o email do seu vendedor: ");
			String email = sc.next();
			sc.nextLine();
			System.out.print("\nInsira a data de nascimento do seu funcionário (dd/MM/yyyy): ");
			String bDate = sc.nextLine();
			Date birthDate = sdf.parse(bDate);
			System.out.print("\nSalário base: ");
			Double baseSalary = sc.nextDouble();
			choiceTrue = true;
			System.out.print("\nId do departamento: ");
			Integer depId = sc.nextInt();
			choiceTrue = true;
			System.out.println("\nNome do departamento: ");
			String depName = sc.next();
			sc.nextLine();
			Department dep = new Department(depId, depName);
			Seller newSeller = new Seller(id, fullName, email, birthDate, baseSalary, dep);
			sellerDao.insert(newSeller);
			System.out.println("\nInserido! id: " + newSeller.getId());
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (ParseException e) {
			e.getMessage();
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void updateSeller(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do vendedor que você deseja atualizar? ");
			Integer updateId = sc.nextInt();
			Seller seller = sellerDao.findById(updateId);

			System.out.print("Deseja atualizar o id do seu vendedor (s/n)? ");
			String chId = sc.next();
			sc.nextLine();
			if (chId.toLowerCase().charAt(0) == 's') {
				System.out.print("\nInsira o id do seu vendedor: ");
				Integer id = sc.nextInt();
				choiceTrue = true;
				seller.setId(id);
			}
			System.out.print("Deseja atualizar o nome do seu vendedor (s/n)? ");
			String chName = sc.next();
			sc.nextLine();
			if (chName.toLowerCase().charAt(0) == 's') {
				System.out.print("\nInsira o nome do seu vendedor: ");
				String name = sc.next();
				String secondName = sc.next();
				String fullName = name + " " + secondName;
				sc.nextLine();
				seller.setName(fullName);
			}
			System.out.print("Deseja atualizar o email do seu vendedor (s/n)? ");
			String chEmail = sc.next();
			sc.nextLine();
			if (chEmail.toLowerCase().charAt(0) == 's') {
				System.out.print("\nInsira o email do seu vendedor: ");
				String email = sc.next();
				sc.nextLine();
				seller.setEmail(email);
			}
			System.out.print("Deseja atualizar a data de nascimento do seu vendedor (s/n)? ");
			String chBDate = sc.next();
			sc.nextLine();
			if (chBDate.toLowerCase().charAt(0) == 's') {
				System.out.print("\nInsira a data de nascimento do seu funcionário (dd/MM/yyyy): ");
				String bDate = sc.next();
				sc.nextLine();
				Date birthDate = sdf.parse(bDate);
				seller.setBirthDate(birthDate);
			}
			System.out.print("Deseja atualizar o salário base do seu vendedor (s/n)? ");
			String chSalary = sc.next();
			sc.nextLine();
			if (chSalary.toLowerCase().charAt(0) == 's') {
				System.out.print("\nSalário base: ");
				Double baseSalary = sc.nextDouble();
				choiceTrue = true;
				seller.setBaseSalary(baseSalary);
			}
			System.out.print("Deseja atualizar o departamento do seu vendedor (s/n)? ");
			String chDep = sc.next();
			sc.nextLine();
			if (chDep.toLowerCase().charAt(0) == 's') {
				System.out.print("\nId do departamento: ");
				Integer depId = sc.nextInt();
				System.out.println("\nNome do departamento: ");
				String depName = sc.next();
				sc.nextLine();
				Department dep = new Department(depId, depName);
				seller.setDepartment(dep);
			}
			sellerDao.update(seller);
			System.out.println("\nAtualizado! id: " + seller.getId());
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (ParseException e) {
			e.getMessage();
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void deleteSeller(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do vendedor que você deseja deletar? ");
			Integer idDelete = sc.nextInt();
			choiceTrue = true;
			sellerDao.deleteById(idDelete);
			System.out.println("Deletado! id: " + idDelete);
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void findSellerById(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while(!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id que você deseja procurar? ");
			Integer idSearch = sc.nextInt();
			choiceTrue = true;
			Seller seller = sellerDao.findById(idSearch);
			System.out.println(seller);
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}

	}

	public void findSellerByDepartment(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while(!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nDeseja procurar o departamento por id ou nome? ");
			String c = sc.next();
			sc.nextLine();
			do {
				if (c.toLowerCase().charAt(0) == 'i') {
					System.out.print("\nQual o id do departamento? ");
					Integer id = sc.nextInt();
					choiceTrue = true;
					Department dep = new Department(id, null);
					list = sellerDao.findByDepartment(dep);
					list.forEach(System.out::println);
				} else if (c.toLowerCase().charAt(0) == 'n') {
					System.out.print("\nQual o nome do departamento? ");
					String nameD = sc.next();
					Department dep = new Department(null, nameD);
					list = sellerDao.findByDepartment(dep);
					list.forEach(System.out::println);
				} else {
					System.out.println("\nOpção inválida, tente novamente!");
					c = sc.next();
				}
			} while (c.toLowerCase().charAt(0) != 'i' || c.toLowerCase().charAt(0) != 'n');
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void listAllSellers(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		clearScreen();
		list = sellerDao.findAll();
		list.forEach(System.out::println);
		tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
	}

	public void insertDepartment(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while (!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do departamento que você deseja inserir? ");
			Integer id = sc.nextInt();
			choiceTrue = true;
			System.out.print("\nQual o nome do departamento que você deseja inserir? ");
			String name = sc.next();
			sc.nextLine();
			Department dep = new Department(id, name);
			depDao.insert(dep);
			System.out.println("Inserido! Id: " + dep.getId());
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void updateDepartment(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while(!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do departamento que você deseja atualizar? ");
			Integer id = sc.nextInt();
			choiceTrue = true;
			Department dept = depDao.findById(id);
			System.out.print("Deseja atualizar o id do departamento (s/n)? ");
			String chId = sc.next();
			sc.nextLine();
			if (chId.toLowerCase().charAt(0) == 's') {
				System.out.print("\nQual o novo id do departamento? ");
				id = sc.nextInt();
				choiceTrue = true;
				dept.setId(id);
			}
			System.out.print("Deseja atualizar o id do departamento (s/n)? ");
			String chName = sc.next();
			sc.nextLine();
			if (chName.toLowerCase().charAt(0) == 's') {
				System.out.print("\nQual o novo nome do departamento? ");
				String name = sc.next();
				sc.nextLine();
				dept.setName(name);
			}
			depDao.update(dept);
			System.out.println("Atualizado! Id: " + dept.getId());
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void deleteDepartment(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while(!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do departamento que você deseja deletar? ");
			Integer idDelete = sc.nextInt();
			choiceTrue = true;
			depDao.deleteById(idDelete);
			System.out.println("Deletado! id: " + idDelete);
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void findDepartmentById(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		while(!choiceTrue) {
		try {
			clearScreen();
			System.out.print("\nQual o id do departamento que você deseja procurar? ");
			Integer id = sc.nextInt();
			choiceTrue = true;
			Department dept = depDao.findById(id);
			System.out.println(dept);
			tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
		} catch (InputMismatchException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (InputException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		} catch (NullPointerException e) {
			System.out.println("Entrada inválida!" + "\nPressione enter para prosseguir");
			sc.nextLine();
		}
		}
	}

	public void findAllDepartments(Scanner sc, SimpleDateFormat sdf, SellerDao sellerDao, List<Seller> list,
			DepartmentDao depDao, List<Department> listD, boolean choiceTrue) {
		clearScreen();
		listD = depDao.findAll();
		listD.forEach(System.out::println);
		tryAgain(sc, sdf, sellerDao, list, depDao, listD, choiceTrue);
	}

	public void exit(Scanner sc) {
		System.out.println("\nSaindo...");
		sc.close();
		System.exit(0);
	}

	public static void clearScreen() {
		for (int i = 0; i < 100; i++) {
			System.out.println("");
		}
	}
}
