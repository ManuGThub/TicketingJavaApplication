

package GUI;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JTextField;


public class CampoTexto extends JTextField{
    
    Image img;
    String img_name="background.jpg";

    public CampoTexto() {
        this.img=new ImageIcon(System.getProperty("user.dir")+"\\"+img_name).getImage();
        
    }
    
    
 

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        this.setOpaque(true);
        //g.drawImage(img, 0,0,this.getWidth(),this.getHeight(), null);
    }
    
    
}
