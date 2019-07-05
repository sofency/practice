import javax.swing.JOptionPane;
public class weightChange{
	public static void main(String[] args){
		while(true)
		{
			String showInDialog=JOptionPane.showInputDialog("please enter the style of change\n1:Ç§¿Ë\n2:°õ\n");
			double style=Double.parseDouble(showInDialog);
			if(style==1)
			{
				String numberOne=JOptionPane.showInputDialog("please enter the number of kilogram");
				double kilogram=Double.parseDouble(numberOne);
				double pound=kilogram*2.20;
				JOptionPane.showMessageDialog(null,"the pound is "+(int)(pound*100)/100.00);
				break;
			}
			else if(style==2)
			{
				String numberTwo=JOptionPane.showInputDialog("please enter the number of kilogram");
				double pound=Double.parseDouble(numberTwo);
				double kilogram=pound/2.20;
				JOptionPane.showMessageDialog(null,"the kilogram is "+(int)(kilogram*100)/100.00);
				break;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"error input please type again");
			}
		}
	}
}