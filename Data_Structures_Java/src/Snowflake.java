import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Snowflake {

	static List<String> paths = new ArrayList<>();

	public static void main(String[] args) {

		getSafePaths(3);

	}

	public static void getSafePaths(int m) {

		StringBuilder sb = new StringBuilder();
		printAll(0, 0, sb, m, m);

		Collections.sort(paths);

		for (String str : paths) {
			System.out.println(str);
		}

	}

	public static void printAll(int currentRow, int currentColumn, StringBuilder sb, int rowCount, int colCount) {

		if (currentRow == rowCount - 1) {
			for (int i = currentColumn; i < colCount; i++) {
				sb.append("H");
			}
			paths.add(sb.toString());
			return;
		}
		if (currentColumn == colCount - 1) {
			for (int i = currentRow; i <= rowCount - 1; i++) {
				sb.append("V");
			}
			paths.add(sb.toString());
			return;
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(sb.toString());
		sb2.append(sb.toString());
		printAll(currentRow + 1, currentColumn, sb1.append("V"), rowCount, colCount);
		printAll(currentRow, currentColumn + 1, sb2.append("H"), rowCount, colCount);

	}

}
