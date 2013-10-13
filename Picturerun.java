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
