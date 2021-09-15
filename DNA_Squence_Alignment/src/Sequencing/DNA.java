package Sequencing;
import javax.swing.JTextField;

public class DNA{
	protected String dna;
	
	
	public DNA() {
		dna="";
		
	}
	
	
	public boolean ValidCheck(JTextField check ) {
		String str = check.getText().toString().toUpperCase();
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)=='G') {
			}else if(str.charAt(i)=='A') {
			}else if (str.charAt(i)=='T'){
			}else if (str.charAt(i)=='C') {
			}else 
				return false;
		}
		return true;
	}

	
		 

}
