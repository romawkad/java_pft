package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.rft.sandbox.Point;

/**
 * Created by RomanovaD on 15.05.2017.
 */
public class PointTests {
    //Нулевые координаты
    @Test
    public void testDistanceZeroCoordinates(){
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,0);
        Assert.assertEquals(p1.distance(p2), 0.0);

    }
    //Положительные координаты
    @Test
    public void testDistancePositiveCoordinates(){
        Point p1 = new Point(1,1);
        Point p2 = new Point(3,5);
        Assert.assertEquals(p1.distance(p2), 4.47213595499958);
    }

    //Отрицательные координаты
    @Test
    public void testDistanceNegativeCoordinates(){
        Point p1 = new Point(-2,-1);
        Point p2 = new Point(-6,-5);
        Assert.assertEquals(p1.distance(p2), 5.656854249492381);
    }


}
