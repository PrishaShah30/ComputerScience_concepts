/**************************

 * Execution: java RandomWalker 10
 *
 * @author:
 *
 *          The program RandomWalker that takes an int command-line argument n
 *          and simulates the motion of a random walk for n steps. Print the
 *          location at each step (including the starting point), treating the
 *          starting point as the origin (0, 0). Also, print the square of the
 *          final Euclidean distance from the origin.
 *
 *          % java RandomWalker 10
 *          (0,0)
 *          (-1,0)
 *          (-1,-1)
 *          (-1,-2)
 *          (-1,-3)
 *          (-1,-4)
 *          (-1,-5)
 *          (0,-5)
 *          (-1,-5)
 *          (-2,-5)
 *          (-2,-4)
 *          Squared distance = 20.0
 *
 *************************************************************************/

public class RandomWalker {

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int x = 0, y =0;
        System.out.println("("+ x + "," +y + ")");
        for(int i=0; i<n;i++){
            double a = Math.random();
            if(a<0.25)
            x++;
            else if (a<0.5)y++;
            else if(a<0.75)x--;
            else y--;
            System.out.println("("+ x + "," +y + ")");
        }
        System.out.println("squared distance ="+(double)(x*x +y*y));
        }
    }