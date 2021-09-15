package Sequencing;
import javax.swing.*;

public class GUI {
	 static JTextField Sequence1 = new JTextField();
	 static JTextField Sequence2 = new JTextField();

	 public static void main(String[] args) {
		 Start();
	   } 
	 
	 public static void Start() {
		 Sequence1.setEditable(true);
		 Sequence2.setEditable(true);
	
		 Object[] message = {
		     "DNA Sequence 1:", Sequence1,
		     "DNA Sequence 2:", Sequence2
		 };
		 DNA seq = new DNA();
		
		 int option = JOptionPane.showConfirmDialog(null, message, "DNA Sequencing", JOptionPane.OK_CANCEL_OPTION);
	
		 if(option == JOptionPane.CANCEL_OPTION || option == JOptionPane.CLOSED_OPTION) {
			 System.exit(0);
		 }
		 
		 if((Sequence1.getText().length() <=0 & Sequence2.getText().length()<=0) ||(!seq.ValidCheck(Sequence1)&!seq.ValidCheck(Sequence2))){
			 JOptionPane.showMessageDialog(null, "Invalid Sequence 1 and 2 Input","Failure",JOptionPane.ERROR_MESSAGE );
			 Start(); 
			 
		 }else if(Sequence1.getText().length() <=0 || !seq.ValidCheck(Sequence1)) {
			 JOptionPane.showMessageDialog(null, "Invalid Sequence 1 Input","Failure",JOptionPane.ERROR_MESSAGE );
			 Start();
			 
		 }else if(Sequence2.getText().length()<=0 || !seq.ValidCheck(Sequence2)){
			 JOptionPane.showMessageDialog(null, "Invalid Sequence 2 Input","Failure",JOptionPane.ERROR_MESSAGE );
			 Start();
			 
		 }else if(option ==JOptionPane.OK_OPTION) {
			 Info();
		 }  
		 
	 }
	 
	 public static void Info() {
		 JTextField MatchScore = new JTextField();
		 JTextField MisMatchScore = new JTextField();
		 JTextField GapPenality = new JTextField();
		 Object[] message = {
		     "MatchScore:", MatchScore,
		     "MisMatchScore:", MisMatchScore,
		     "GapPenality: ", GapPenality
		     };
		 int option = JOptionPane.showConfirmDialog(null, message, "DNA Sequencing", JOptionPane.OK_CANCEL_OPTION);
	
		 if(option == JOptionPane.CANCEL_OPTION) {
			 Start();
		 }
		 if(option == JOptionPane.CLOSED_OPTION) {
			 System.exit(0);
		 }
		 if(MatchScore.getText().length() <= 0||MisMatchScore.getText().length() <= 0|| GapPenality.getText().length() <= 0) {
			 JOptionPane.showMessageDialog(null, "Invalid Inputs","Failure",JOptionPane.ERROR_MESSAGE );
			 Info();
		 }else if(!MatchScore.getText().matches("^[0-9]*$")||!MisMatchScore.getText().matches("^[0-9]*$")||!GapPenality.getText().matches("^[0-9]*$")) {
			 JOptionPane.showMessageDialog(null, "Only Positive intergers Allowed","Failure",JOptionPane.ERROR_MESSAGE );
			 Info();
		 }else if(option == JOptionPane.OK_OPTION) {
			 OptionMenu men = new OptionMenu(Sequence1, Sequence2);
			 men.Options();
		 }
	 }
	 
}
