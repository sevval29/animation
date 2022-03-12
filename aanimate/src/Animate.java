import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Animate extends JFrame implements ActionListener, Runnable{
    private int x,y,r;
    private JButton btnStart, btnStop;
    public static Thread th1;
    boolean check = true;
    public Animate() {
        x=50;
        y=75;
        r=50;

        btnStart = new JButton("Start");
        setLayout(new FlowLayout());
        add(btnStart);
        btnStart.addActionListener(this);

        btnStop = new JButton("Stop");
        add(btnStop);
        btnStop.addActionListener(this);

        setSize(500,500);
        setVisible(true);
        setTitle("Animate");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        super.paint(g);
        g.setColor(Color.red);
        g.fillRect(100, 125, 300, 300);
        g.setColor(Color.blue);
        g.fillOval(x, y, r, r);
    }



    public static void main(String[] args) {
        Animate an = new Animate();
        th1 = new Thread(an);
        th1.start();
		/*try {
			th1.start();
			//th1.wait();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(btnStart)) {
            check=true;
        }
        else if(e.getSource().equals(btnStop)) {
            check=false;

        }


    }

    @Override
    public void run() {
        boolean move1=true,move2=false,move3=false;
        try {
		/*x=50;//400 25  25
		y=75;//425 425 75
		r=50;*/


            while(true) {
                while(move1) {
                    for(;x<=400&&y<=425;)
                    {
                        if(check) {
                            x++;
                            y++;
                        }

                        if(x==400&&y==425) {
                            move1=false;
                            move2=true;
                        }


                        repaint();
                        Thread.currentThread().sleep(10);


                    }
                }
                while(move2) {
                    for(;x>=50;)
                    {
                        if(check) {

                            x--;


                        }
                        if(x==50) {
                            move2=false;
                            move3=true;
                        }
                        repaint();
                        Thread.currentThread().sleep(5);
                    }
                }

                while(move3) {
                    for(;y>=75;)
                    {
                        if(check) {

                            y--;

                        }
                        if(y==75) {
                            move3=false;
                            move1=true;
                        }
                        repaint();
                        Thread.currentThread().sleep(5);
                    }
                }


            }


        }catch (Exception e) {
            // TODO: handle exception
        }

    }
}