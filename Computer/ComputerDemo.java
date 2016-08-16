package Computer;

public class ComputerDemo {

	public static void main(String[] args) {
		Computer computerFirst = new Computer();

		computerFirst.changeOperationSystem("ios");
		computerFirst.freeMemmory = 200;
		computerFirst.hardDiskMemmory = 300;
		computerFirst.isNotebook = true;
		computerFirst.yearOfProduction = 1995;
		computerFirst.price = 323.30f;

		
		System.out.println("Before Effect First Computer");
		computerFirst.showMeInfo();

		System.out.println("After Effect First Computer");
		computerFirst.useMemory(110);
		computerFirst.showMeInfo();

		Computer computerSecond = new Computer();
		computerSecond.changeOperationSystem("ios");
		computerSecond.freeMemmory = 200;
		computerSecond.hardDiskMemmory = 300;
		computerSecond.isNotebook = false;
		computerSecond.yearOfProduction = 1995;
		computerSecond.price = 323.30f;
		System.out.println("Before Effect Second Computer");
		computerSecond.showMeInfo();

		System.out.println("After Effect Second Computer");
		computerSecond.changeOperationSystem("windows");
		computerSecond.showMeInfo();

	}

}
