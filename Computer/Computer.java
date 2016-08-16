package Computer;

public class Computer {
	private String[] acceptableOperationSystem = { "windows", "linux", "ios" };
	int yearOfProduction;
	float price;
	boolean isNotebook;
	int hardDiskMemmory;
	int freeMemmory;
	String operationSystem;

	void showMeInfo() {
		System.out.println("Computer info:\n\t OS " + operationSystem + "\n\t HardDisk " + hardDiskMemmory
				+ "\n\t Is Laptop " + isNotebook + "\n\t Year of production " + yearOfProduction + "\n\t Memmory "
				+ freeMemmory + "\n\t Price " + price);
	}

	void changeOperationSystem(String newOperationSystem) {

		if ((newOperationSystem == null) || (newOperationSystem.equals(""))) {
			System.out.println("Enter non-empty OS, please!");
			return;
		} else {
			boolean isValidOs = false;
			newOperationSystem = newOperationSystem.toLowerCase();
			for (int index = 0; index < acceptableOperationSystem.length; index++) {
				if (acceptableOperationSystem[index].equals(newOperationSystem)) {
					isValidOs = true;
				}
			}
			if (isValidOs) {
				operationSystem = newOperationSystem;
			} else {
				System.out.println("Not valid OS! Valid OS are [windows, linux, ios]");
				return;
			}
		}
	}

	void useMemory(int memmoryToTake) {
		if (memmoryToTake <= 0) {
			System.out.println("Must be positive number");
			return;
		}

		if ((freeMemmory - memmoryToTake) < 0) {
			System.out.println("Not enough free memory! No changes made.");
			return;
		} else {
			freeMemmory -= memmoryToTake;
		}
	}

}