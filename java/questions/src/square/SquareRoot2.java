package square;

/**
 * Java Puzzle: Square Root
 * http://corner.squareup.com/2013/03/puzzle-square-root.html
 * 
 * @author hideki
 */
public class SquareRoot2 {
  private static double f(double x, double n){
	  return Math.pow(x, 2) - n;
  }
  private static double f_derivative(double x){
	  return 2 * x;
  }
  private static double newton_method(double x0, double n){
	  double f = f(x0, n);
	  double f_derivative = f_derivative(x0);
	  return x0 - f / f_derivative;
  }
  private static boolean close(double root, double n){
	  return Math.abs(n - Math.pow(root, 2)) > 0.1;
  }
  public static double squareRoot(double n){
	  double x0 = 1f;
	  while(close(x0, n)){
		  x0 = newton_method(x0, n);
	  }
	  return x0;
  }
  public static int squareRoot(int n){
	  return (int)squareRoot((double)n);
  }
}