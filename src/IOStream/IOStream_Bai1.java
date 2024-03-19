package IOStream;

import java.io.File;
import java.util.Scanner;

public class IOStream_Bai1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Nhập đường dẫn của file: ");
		String filePath = scanner.nextLine();

		File file = new File(filePath);

		if (!file.exists()) {
			System.out.println("File không tồn tại.");
			return;
		}

		long fileSize = file.length();

		System.out.println("Độ lớn của file là: " + fileSize + " bytes");

		scanner.close();
	}
}
