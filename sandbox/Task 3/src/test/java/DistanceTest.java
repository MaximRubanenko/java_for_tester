import org.testng.Assert;
import org.testng.annotations.Test;

public class DistanceTest {
  Point p1 = new Point(1,2);
  Point p2 = new Point(1,4);

  @Test
  public void distTestMethod(){
    Assert.assertEquals(p1.distance(p2),2);
    Assert.assertEquals(p1.distance(p1),0);
  }
  @Test
  public void distTestFunc(){
    Assert.assertEquals(Start.distance(p1,p2),2);
    Assert.assertEquals(Start.distance(p1,p1),0);
  }
}
