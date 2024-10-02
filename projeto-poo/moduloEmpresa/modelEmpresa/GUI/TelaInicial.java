package moduloEmpresa.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TelaInicial extends JFrame {

   
	public TelaInicial() {
	    setTitle("Sistema de Energia Solar - Tela Inicial");
	    setSize(1200, 800);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);

	 
	    PainelComFundo panel = new PainelComFundo();  
	    panel.setLayout(null); 

	    add(panel);  
	    placeComponents(panel);  
	    setVisible(true);  
	}

    

    
  
    private void placeComponents(JPanel panel) {
        panel.setLayout(null); 
        
        
        JLabel welcomeLabel = new JLabel("SEJA BEM VINDO");
        welcomeLabel.setBounds(535, 60, 300, 25); 
        
        panel.add(welcomeLabel); 
        
    
        int buttonWidth = 300;
        int buttonX = (1200 - buttonWidth) / 2;

     // Cadastrar equipamentos**********************************
        JButton cadastrarEquipamentoButton = new JButton("Cadastrar Equipamentos");
        cadastrarEquipamentoButton.setBounds(buttonX, 100, buttonWidth, 25); 

     //verificar depois
        String caminhoIcone = "moduloEmpresa/GUI/graphicImages/equipamentos.png"; 

     
        cadastrarEquipamentoButton.setHorizontalTextPosition(SwingConstants.RIGHT); 
        cadastrarEquipamentoButton.setVerticalTextPosition(SwingConstants.CENTER); 
        cadastrarEquipamentoButton.setIconTextGap(10); 

        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource(caminhoIcone));
        if (originalIcon != null) {
            
            Image img = originalIcon.getImage(); 
            Image scaledImg = img.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            
            
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            cadastrarEquipamentoButton.setIcon(scaledIcon);
        } else {
            System.err.println("Ícone não encontrado: " + caminhoIcone);
        }

        panel.add(cadastrarEquipamentoButton); 
        cadastrarEquipamentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new TelaCadastroEquipamento(); 
            }
        });


        
        
        
     // Cadastrar fabricantes************************************8
        JButton cadastrarFabricanteButton = new JButton("Cadastrar Fabricante");
        cadastrarFabricanteButton.setBounds(buttonX, 150, buttonWidth, 25); 


        String caminhoIconeFabricante = "moduloEmpresa/GUI/graphicImages/fabricante.png";


        cadastrarFabricanteButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        cadastrarFabricanteButton.setVerticalTextPosition(SwingConstants.CENTER); 
        cadastrarFabricanteButton.setIconTextGap(10); 


        ImageIcon originalIconFabricante = new ImageIcon(getClass().getClassLoader().getResource(caminhoIconeFabricante));
        if (originalIconFabricante != null) {

            Image imgFabricante = originalIconFabricante.getImage();
            Image scaledImgFabricante = imgFabricante.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
            
  
            ImageIcon scaledIconFabricante = new ImageIcon(scaledImgFabricante);
            cadastrarFabricanteButton.setIcon(scaledIconFabricante); 
        } else { System.err.println("Ícone não encontrado: " + caminhoIconeFabricante);}

        panel.add(cadastrarFabricanteButton); 


        cadastrarFabricanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new TelaCadastroFabricante(); 
            }
        });

        
     // Listar fabricantes ****************************************8
        JButton listarFabricanteButton = new JButton("Listar Fabricante");
        listarFabricanteButton.setBounds(buttonX, 200, buttonWidth, 25); 


        String caminhoIconeListaFabricante = "moduloEmpresa/GUI/graphicImages/lista.png"; 
    
        listarFabricanteButton.setHorizontalTextPosition(SwingConstants.RIGHT); 
        listarFabricanteButton.setVerticalTextPosition(SwingConstants.CENTER); 
        listarFabricanteButton.setIconTextGap(10); 


        ImageIcon originalIconListaFabricante = new ImageIcon(getClass().getClassLoader().getResource(caminhoIconeListaFabricante));
        if (originalIconListaFabricante != null) {

            Image imgFabricante = originalIconListaFabricante.getImage(); 
            Image scaledImgFabricante = imgFabricante.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 
            

            ImageIcon scaledIconFabricante = new ImageIcon(scaledImgFabricante);
            listarFabricanteButton.setIcon(scaledIconFabricante); 
        } else {
            System.err.println("Ícone não encontrado: " + caminhoIconeListaFabricante);
        }

        panel.add(listarFabricanteButton); 


        listarFabricanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new TelaListarFabricante(); 
            }
        });

        
     // Listar municípios **************************************************************
        JButton listarMunicipiosButton = new JButton("Listar Municípios");
        listarMunicipiosButton.setBounds(buttonX, 250, buttonWidth, 25); 


        String caminhoIconeMunicipios = "moduloEmpresa/GUI/graphicImages/municipios.png"; 


        listarMunicipiosButton.setHorizontalTextPosition(SwingConstants.RIGHT); 
        listarMunicipiosButton.setVerticalTextPosition(SwingConstants.CENTER); 
        listarMunicipiosButton.setIconTextGap(10);


        ImageIcon originalIconMunicipios = new ImageIcon(getClass().getClassLoader().getResource(caminhoIconeMunicipios));
        if (originalIconMunicipios != null) {
 
            Image imgMunicipios = originalIconMunicipios.getImage(); 
            Image scaledImgMunicipios = imgMunicipios.getScaledInstance(16, 16, Image.SCALE_SMOOTH); 

            ImageIcon scaledIconMunicipios = new ImageIcon(scaledImgMunicipios);
            listarMunicipiosButton.setIcon(scaledIconMunicipios); 
        } else {System.err.println("Ícone não encontrado: " + caminhoIconeMunicipios); }

        panel.add(listarMunicipiosButton); 

       
        listarMunicipiosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new TelaListarMunicipios();
            }
        });

    }
}