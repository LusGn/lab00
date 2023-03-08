package it.polito.tdp.Lab00;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLController {
	boolean sup=false;
	 int count=3;
    @FXML
    private Button btnAccedi;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtPass;
    
    @FXML
    private TextField risultato;
    
    @FXML
    private Button btnclear;
   
    @FXML
    void premi(ActionEvent event) { //entrambi cambi compilati e password: maiuscolo, car speciale, numero e 7
    	// 3 tentativi di inserire la pss in modo valido
    	
    	String nome= txtNome.getText();
    	String pass=txtPass.getText();
    	System.out.println("nome: "+nome);
    	System.out.println("pass: "+pass);
    	boolean num=false;
    	
    	
    	for (char c : pass.toCharArray()) {
			if (Character.isDigit(c)) {
				num = true;
			}
    	}
    	if(nome!="" & pass!="" && pass.length()>=7 && pass.toLowerCase().compareTo(pass)!=0 && num==true && pass.contains("@") || pass.contains("#") || pass.contains("!") || pass.contains("?")) {
    		System.out.println("ciclo11111");
    			
    				risultato.setDisable(false);
    				risultato.setText("successo");
    	}
    	
    	else if(count>0 && sup==false){
    		System.out.println("ciclo else");
    		count--;
    		risultato.setDisable(false);
    		risultato.setText("password non valido, hai ancora : "+count+" tentativi!!");
    	}
    	if(count==0) {
    		sup=true;
    		risultato.setDisable(true);
    	}
    
    }
    @FXML
    void btnclean(ActionEvent event) {
    	if(sup==true) {//entra se count=0 ovverò già provato 3 tentativi
    		btnclear.setDisable(false);
    		txtNome.clear();
    		txtPass.clear();
    		count=3;
    		System.out.println(count);
    		sup=false;
    	}
    }


    
}
