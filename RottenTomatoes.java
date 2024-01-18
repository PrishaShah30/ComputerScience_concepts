/*************************************************************************
 * Compilation: javac RURottenTomatoes.java
 * Execution: java RURottenTomatoes
 *
 * @author:
 *
 *          RURottenTomatoes creates a 2 dimensional array of movie ratings
 *          from the command line arguments and displays the index of the movie
 *          that has the highest sum of ratings.
 *
 *          java RURottenTomatoes 3 2 5 2 3 3 4 1
 *          0
 *************************************************************************/

public class RURottenTomatoes {

	public static void main(String[] args) {
		int r = Integer.parseInt(args[0]);
		int m = Integer.parseInt(args[1]);
		int arr[][] = new int[r][m];
		int max = 0, total = 0, c = 2, loc = 0;
		int ta[] = new int[m];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < m; j++) {
				if (Integer.parseInt(args[c]) >= 0 && Integer.parseInt(args[c]) <= 5)
					arr[i][j] = Integer.parseInt(args[c]);
				c++;
			}
		}
		for (int i = 0; i < m; i++) {
			total = 0;
			for (int j = 0; j < r; j++) {
				total += arr[j][i];
			}
			ta[i] = total;
		}
		for (int i = ta.length - 1; i >= 0; i--) {
			if (ta[i] >= max) {
				max = ta[i];
				loc = i;
			}
		}
		System.out.println(loc);
	}
}