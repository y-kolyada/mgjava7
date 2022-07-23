import java.io.FileNotFoundException;

final class ThrowsException {

	public void readFile(String file) throws FileNotFoundException {
		boolean found = findFile(file);

		if (!found)
			throw new FileNotFoundException("File not found");
		else
			System.out.println("File reading...");
	}

	private boolean findFile(String file) {
		System.out.println("Find File...");

		return false;
	}

}

public class ThrowsExceptionGui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThrowsException thex = new ThrowsException();
		try {
			thex.readFile("nofile");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException Exception");
		}

	}

}
