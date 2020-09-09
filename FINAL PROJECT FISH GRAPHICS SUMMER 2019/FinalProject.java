import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;
/**
 * Write a description of class AnimationTemplate here.

 * @author (your name)
 * @version (a version number or a date)
 */
public class FinalProject extends Applet implements ActionListener,MouseListener
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
    private int p,y;       //shape starting point
    private int pInc,yInc; //controls how much to move shape
    private Timer timer;   //used to force redraw 
    private int ctr;       //other needed variables
    private int Level;     //this is for switching screens\
    private int nemoX;
    private int nemoY;
    private int nemoWidth;
    private int nemoLength;
    /**
     * This is always called before the first time that the start 
     * method is called. Here we set up the timer and initiailize 
     * the starting point for our moving shape
     */
    public void init()
    { 
        //added these variables for mousepressed boundaries used later when user clicks
        addMouseListener(this);
        nemoX=190;
        nemoY=160;
        nemoWidth=80;
        nemoLength=100;

        //level is for switching the screens
        Level=0;  
        // This is where the moving shape STARTS
        p=100;
        y=200;
        // How much to move in each direction when we redraw
        pInc=1;
        yInc=1;
        //initialize other needed variables
        ctr=1;
        // define the timer and start it
        timer = new Timer(50,this); // 10 ms. Larger numbers = slower
        timer.start();
        //setup background color
        //I made this light blue as the ocean background 
        Color lightb=new Color(65, 232, 244);

        setBackground(lightb);
    }

    public void paint(Graphics g)
    {   
        //title
        if(Level%2==0){
            Color maincol=new Color(209, 136, 20);
            g.setColor(maincol);
            g.setFont(new Font("Arial",Font.PLAIN,40));
            g.drawString("FIND NEMO!",160,40);
            g.drawString("By:Itay G",160,90);
            g.setColor(Color.GREEN);
            //This is the seaweed
            for(int i=20;i<480;i+=40){
                g.setColor(Color.GREEN);         //stem color
                g.fillRect(i,440,20,60);
                g.setColor(Color.BLUE);          //outline requirement
                g.drawRect(i,440,20,60);
                Color darkg=new Color(10, 91, 57); //leaf color
                g.setColor(darkg);
                g.fillArc(i,420,20,60,0,180);
            }

            //background fish,Blue/Red ones used a for loop
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

            //other background fish,black and gray ones used a for loop
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
            //this is Dory
            g.setColor(Color.BLUE);
            g.fillOval(150,100,80,60);
            g.setColor(Color.YELLOW);
            Polygon fin=new Polygon();
            fin.addPoint(150,130);
            fin.addPoint(110,110);
            fin.addPoint(110,150);
            g.fillPolygon(fin);
            g.setColor(Color.BLACK);
            g.fillArc(152,100,75,50,180,-120);
            g.setColor(Color.WHITE);
            g.fillOval(208,110,15,15);
            g.setColor(Color.MAGENTA);
            g.fillOval(211,113,10,10);
            g.setColor(Color.BLACK);
            g.fillOval(213,115,6,6);
            g.setColor(Color.GREEN);
            Polygon fin2=new Polygon();
            fin2.addPoint(210,140);
            fin2.addPoint(190,135);
            fin2.addPoint(190,145);
            g.fillPolygon(fin2);
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
        else{
            //This is the title of the second screen
            Color maincol=new Color(209, 136, 20);
            g.setColor(maincol);
            g.setFont(new Font("Arial",Font.PLAIN,40));
            g.drawString("NEMO FOUND !",100,50);
            // this is nemo moving by himself in the second screen

            Color nemo= new Color(255,102,0);
            g.setColor(nemo);
            g.fillOval(p+220,180,80,60);
            g.fillArc(p+190,160,100,100,150,60);
            g.setColor(Color.WHITE);
            Polygon four1=new Polygon();
            four1.addPoint(p+265,180);
            four1.addPoint(p+270,182);
            four1.addPoint(p+270,238);
            four1.addPoint(p+265,240);
            g.fillPolygon(four1);
            Polygon four2=new Polygon();
            four2.addPoint(p+257,179);
            four2.addPoint(p+252,181);
            four2.addPoint(p+252,239);
            four2.addPoint(p+257,241);
            g.fillPolygon(four2);
            Polygon four3=new Polygon();
            four3.addPoint(p+245,181);
            four3.addPoint(p+240,183);
            four3.addPoint(p+240,237);
            four3.addPoint(p+245,239);
            g.fillPolygon(four3);
            g.fillOval(p+272,185,14,14);
            g.setColor(Color.RED);
            g.fillOval(p+275,187,10,10);
            g.setColor(Color.BLACK);
            g.fillOval(p+278,189,7,7);
            g.setColor(Color.WHITE);
            g.fillOval(p+275,187,2,2);
            g.setColor(Color.YELLOW);
            g.fillOval(200,390,100,100);
            g.setColor(Color.BLACK);
            g.fillOval(230,410,10,10);
            g.fillOval(260,410,10,10);
            g.fillOval(245,430,8,8);
            g.drawArc(235,438,30,30,180,180);
            g.drawLine(230,453,240,453);
            g.drawLine(260,453,270,453);
            // this is to make nemo appear back after going off screen
            p+=pInc;
            if(p>=500){
                p=-278;  
            }

        }
    }

    public void mousePressed(MouseEvent me)
    {
        int mouseX=me.getX();  //this is to get nemo's position
        int mouseY=me.getY();
        // this if statement creates rectangular boundaries for the mouse press
        if(mouseX>=nemoX && mouseX<=nemoX+nemoLength&& mouseY>=nemoY && mouseY<=
        nemoY+nemoWidth){
            Level+=1;   //this will change to the next screen
        }
    }

    public void mouseClicked(MouseEvent me)
    {
    }

    public void mouseEntered(MouseEvent me)
    {}

    public void mouseExited(MouseEvent me)
    {}

    public void mouseReleased(MouseEvent me)
    {}
}

