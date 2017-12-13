import java.awt.geom.*;     // for Point2D.Double
import java.util.ArrayList; // for ArrayList
import gpdraw.*;            // for DrawingTool

public class IrregularPolygon{
    
    //declare some stuff first
    private ArrayList <Point2D.Double> polygon;
    private SketchPad paper;
    private DrawingTool pencil;
    private String name = "Qaasim Ashraf";
    
    // constructor
    public IrregularPolygon() 
    { 
        paper = new SketchPad(500, 500);
        pencil = new DrawingTool(paper);
        polygon = new ArrayList <Point2D.Double> ();
    }

    // public methods
    public void add(Point2D.Double aPoint) 
    {
        polygon.add(aPoint);
    }

    public double perimeter() 
    { 
        int total = 0;
        for (int count = 0; count < polygon.size() - 1; count ++)
        {
            Point2D point1 = polygon.get(count);
            Point2D point2 = polygon.get(count + 1);
            double distance = point1.distance(point2);
            total += distance;
        }
        int size = polygon.size();
        Point2D lastPoint = polygon.get(size - 1);
        Point2D firstPoint = polygon.get(0);
        double lastDistance = lastPoint.distance(firstPoint);
        total += lastDistance;
        return total;
    }

    public double area() 
    { 
        double multiplyMe = 0.0;
        for (int count = 0; count < polygon.size() - 1; count ++)
        {
            Point2D point1 = polygon.get(count);
            Point2D point2 = polygon.get(count + 1);
            double x1 = point1.getX();
            double y1 = point1.getY();
            double x2 = point2.getX();
            double y2 = point2.getY();
            multiplyMe += (x1 * y2 - y1 * x2);
        }
        int size = polygon.size();
        Point2D lastPoint = polygon.get(size - 1);
        Point2D firstPoint = polygon.get(0);
        double lastX = lastPoint.getX();
        double lastY = lastPoint.getY();
        double firstX = firstPoint.getX();
        double firstY = firstPoint.getY();
        multiplyMe += (lastX * firstY - lastY * firstX);
        return Math.abs (.5 * multiplyMe);
    }

    public void draw()
    {
        pencil.up();
        pencil.move(polygon.get(0).getX(), polygon.get(0).getY());
        pencil.down();
 
        for(int i = 1; i < polygon.size(); i++)
        {
            pencil.move(polygon.get(i).getX(), polygon.get(i).getY());
        }
        int size = polygon.size();
        Point2D firstPoint = polygon.get(0);
        pencil.move(firstPoint.getX(), firstPoint.getY());
    }

    public String getName ()
    {
        return this.name;
    }
}