public class Start {
  public static void main(String[] args) {
    Point p1 = new Point(1,2);
    Point p2 = new Point(1,4);

    System.out.println("Расстояние между точками, вычесленное с помощью функции равно:      " + distance(p1,p2));
    System.out.println("Расстояние между точками, вычесленное с помощью метода класса равно:" + p1.distance(p2));

  }
  public static double distance(Point p1, Point p2) {
    //    double result = 0.0;
    return   Math.sqrt  (
            Math.pow( (p2.getX() - p1.getX()),2 ) + Math.pow( (p2.getY() - p1.getY()),2)
    );
  }
  }

