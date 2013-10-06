import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

@SuppressWarnings("serial")
public class Pictureview extends JFrame{

	static Pictureview okno;
	String filename;
	Image picture;
	Picturerun ppanel;
	int xpos, ypos;
	int x1, y1, x2, y2;
	int height, width;
	
	class MainAction implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		  String Label;
		  Label = e.getActionCommand();
		  if(Label.equals("Закрыть"))
			  System.exit(0);
		  if(Label.equals("Загрузить изображение"))
			  loadImage();
		}
		
	}
	
	Pictureview(String titel){
		super(titel);
		xpos=ypos=0;
		x1=y1=x2=y2=0;
		filename = null;
		picture = null;
		setLayout(new FlowLayout());
		ppanel = new Picturerun();
		add(ppanel);
		JMenuBar menulist = new JMenuBar();
		setJMenuBar(menulist);
		
		JMenu menu1 = new JMenu("Файл");
		JMenuItem item1 = new JMenuItem("Загрузить изображение");
		item1.addActionListener(new MainAction());
		JMenuItem item2 = new JMenuItem("Закрыть");
		item2.addActionListener(new MainAction());
		menu1.add(item1);
		menu1.add(item2);
		menulist.add(menu1);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	
	void loadImage(){
		FileDialog d = new FileDialog(this, "Загрузить изображение", FileDialog.LOAD);
		d.setVisible(true);
		filename = d.getFile();
		if(filename==null)
			return;
		ImageIcon tmp = new ImageIcon(filename);
		picture = tmp.getImage();
		width = picture.getWidth(ppanel);
		height = picture.getHeight(ppanel);
		x1 = xpos;
		y1 = ypos;
		x2=x1+width;
		y2 = y2 + height;
		ppanel.repaint();
	}
	
	public static void main(String[] args) {
		okno = new Pictureview("Просмотр изображений");
		okno.setSize(800, 800);
		okno.pack();
		okno.setVisible(true);

	}

	class Picturerun extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(picture != null)
				g.drawImage(picture, xpos,ypos,this);	
			}
			public Dimension getMinimumSize(){
				return okno.getSize();
				}
			 public Dimension getPreferredSize() {
			      return getMinimumSize();
				
			}
		}
	}
