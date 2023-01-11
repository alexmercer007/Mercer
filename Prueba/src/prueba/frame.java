/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package prueba;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author AlexMercer007
 */
public class frame extends Canvas implements Runnable{
   
    public int x;
    public int y;
    
   public Canvas c = new Canvas(); 
   public JFrame F = new JFrame();
   public Thread t0;
   public boolean running;
  
   
   
 public frame(){
     

   
    F.setSize(1280,720);
    F.setDefaultCloseOperation(F.EXIT_ON_CLOSE);
    F.setResizable(false);
    F.setLocationRelativeTo(null);
    F.add(c);

    
MouseMotionListener mml = new MouseMotionListener() {
        
public void mouseMoved(MouseEvent e) {

           x=e.getX();
           y=e.getY();


    System.out.println( x + "y" +y );   
                
                }

public void mouseDragged(MouseEvent e) {

          
                
  }
    
    
 };
            
c.addMouseMotionListener(mml);
 F.setVisible(true);
 
 }
    

 public synchronized void star() {
     
     running = true;

     this.t0= new Thread( this, "Display" );
     this.t0.start( );
     
     
 }
 
 public synchronized void stop() {
     
     running = false;
		
     try {  this.t0.join( );   }

     catch ( InterruptedException e ) { e.printStackTrace( );  }
     
 }
 
    @Override
    public void run() {

        running = true;
        
while ( running ) {
			
update( );
				
render( );
			
}

stop( );

    }

   
public void render() {
    
 BufferStrategy bs = c.getBufferStrategy( );
		
 if ( bs == null ) {

     c.createBufferStrategy( 2 );
    
     return;
}

Graphics g = c.getGraphics( );

g.setColor( Color.red );
g.fillRect( x, y, 100,100 );

		

g.dispose( );
bs.show( );   
    
    
    
    
}   
    
public void update ( ) {
    

    
}


 




}