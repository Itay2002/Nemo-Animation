import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
/**
 * Write a description of class AnimationTemplate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class FinalProjectold extends Applet implements ActionListener
{
    /****************************************************
     * The following code should NOT be changed for any
     * reason. Doing so will prevent the app from running
     ****************************************************/
    public boolean debugging;
    public void debug(int width, int height) {
        Applet applet = this;
        debugging = true;
        String windowTitle = applet.getClass().getName();
        JFrame frame = new JFrame(windowTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height + 20);
        frame.setBackground(Color.BLACK);
        applet.setSize(width, height+frame.getY());
        frame.add(applet);
        applet.init();      // simulate browser call(1)
        applet.start();      // simulate browser call(2)
        frame.setVisible(true);
    }  

    public boolean debugging() {
        return debugging;
    }

    public void actionPerformed(ActionEvent ae) {
        repaint(); 
    }

    /** All code changes go below this point **/
    /** Variables declared here can be used in ALL following methods.
     * Generally, only those variables needed for animation purposes
     * should go here.
     */
    private int x,y;       //shape starting point
    private int xInc,yInc; //controls how much to move shape
    private Timer timer;   //used to force redraw 
    private int ctr;       //other needed variables
    private int Level;
    /**
     * This is always called before the first time that the start 
     * method is called. Here we set up the timer and initiailize 
     * the starting point for our moving shape
     */
    public void init()
    { 
        
        Level=0;  
        // This is where the moving shape STARTS
        x=100;
        y=200;
        // How much to move in each direction when we redraw
        xInc=0;
        yInc=3;
        //initialize other needed variables
        ctr=0;
        // define the timer and start it
        timer = new Timer(10,this); // 10 ms. Larger numbers = slower
        timer.start();
        //setup background color
        //I made this light blue so Dory would be visible
        Color lightb=new Color(65, 232, 244);

        setBackground(lightb);

    }

    public void paint(Graphics g)
    {   
        //title
        if(Level==0){
            Color maincol=new Color(209, 136, 20);
            g.setColor(maincol);
            g.setFont(new Font("Arial",Font.PLAIN,40));
            g.drawString("FIND NEMO!",100,50);

            g.setColor(Color.GREEN);
            //This is the seaweed
            for(int i=20;i<480;i+=40){
                g.setColor(Color.GREEN);
                g.fillRect(i,440,20,60);
                Color darkg=new Color(10, 91, 57);
                g.setColor(darkg);
                g.fillArc(i,420,20,60,0,180);

            }
            //background fish,Blue/Red ones
            for(int j=30;j<480;j+=100){
                g.setColor(Color.WHITE);
                g.fillRect(j,380,40,30);
                g.setColor(Color.BLUE);
                Polygon tri=new Polygon();
                tri.addPoint(j,395);
                tri.addPoint(j-10,410);
                tri.addPoint(j-10,380);
                g.fillPolygon(tri);
                g.fillOval(j+25,385,5,5);
            }
            //other background fish,black and gray ones
            for (int j=50;j<480;j+=130){
                g.setColor(Color.GRAY);
                g.fillOval(j,320,40,40);
                g.setColor(Color.BLACK);
                Polygon quad=new Polygon();
                quad.addPoint(j,340);
                quad.addPoint(j-10,320);
                quad.addPoint(j-30,340);
                quad.addPoint(j-10,360);
                g.fillPolygon(quad);
                g.setColor(Color.MAGENTA);
                g.fillOval(j+25,325,10,10);

            }
            //more background fish,red/white ones

            for(int j=90;j<480;j+=170){
                g.setColor(Color.RED);
                Polygon pent=new Polygon();
                pent.addPoint(j,260);
                pent.addPoint(j,300);
                pent.addPoint(j-10,300);
                pent.addPoint(j-30,280);
                pent.addPoint(j-10,260);
                g.fillPolygon(pent);
                g.setColor(Color.WHITE);
                g.fillArc(j-40,260,10,40,270,180);
                g.fillOval(j-10,265,8,8);
                g.setColor(Color.BLUE);
                g.fillOval(j-8,267,5,5);
            }
            //This is nemo
            Color nemo= new Color(255,102,0);
            g.setColor(nemo);
            g.fillOval(220,180,80,60);
            g.fillArc(190,160,100,100,150,60);
            g.setColor(Color.WHITE);
            Polygon four1=new Polygon();
            four1.addPoint(265,180);
            four1.addPoint(270,182);
            four1.addPoint(270,238);
            four1.addPoint(265,240);
            g.fillPolygon(four1);
            Polygon four2=new Polygon();
            four2.addPoint(257,179);
            four2.addPoint(252,181);
            four2.addPoint(252,239);
            four2.addPoint(257,241);
            g.fillPolygon(four2);
            Polygon four3=new Polygon();
            four3.addPoint(245,181);
            four3.addPoint(240,183);
            four3.addPoint(240,237);
            four3.addPoint(245,239);
            g.fillPolygon(four3);
            g.fillOval(272,185,14,14);
            g.setColor(Color.RED);
            g.fillOval(275,187,10,10);
            g.setColor(Color.BLACK);
            g.fillOval(278,189,7,7);
            g.setColor(Color.WHITE);
            g.fillOval(275,187,2,2);
        }
    
        
    }
}
