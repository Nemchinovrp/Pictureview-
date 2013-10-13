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
