import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {

private double fractionLength = .9f; 
private int smallestBranch = 5; 
private double branchAngle = .4f;
public void setup() 
{   
	size(640,480);
} 
public void draw() 
{   
	background(0);   
	stroke(0,255,0);   
	line(320,480,320,360);   
	drawBranches(320, 360, 100, 3*Math.PI/2); 
} 
public void keyPressed()
{
	if(keyCode == UP)
	{
		branchAngle += 0.05f;
	} else if(keyCode ==  DOWN) {
		branchAngle -= 0.05f;
	}
}
public void drawBranches(int x,int y, double branchLength, double angle) 
{   
	double angle1 = angle + branchAngle;
	double angle2 = angle - branchAngle;  
	branchLength *= fractionLength;
	int endX1 = (int)(branchLength*Math.cos(angle1) + x);
	int endY1 = (int)(branchLength*Math.sin(angle1) + y);
	int endX2 = (int)(branchLength*Math.cos(angle2) + x);
	int endY2 = (int)(branchLength*Math.sin(angle2) + y);
	line(x, y, endX1, endY1);
	line(x, y, endX2, endY2);
	if(branchLength > smallestBranch)
	{
		drawBranches(endX1, endY1, branchLength-8, angle1+branchAngle);
		drawBranches(endX2, endY2, branchLength-8, angle2-branchAngle); 
	}
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
