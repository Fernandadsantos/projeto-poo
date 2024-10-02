package moduloEmpresa.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TelaCadastroEquipamento extends JFrame {
	
	public TelaCadastroEquipamento () {
		
		setTitle("Cadastro de equipamentos"); 
        setSize(1200, 800); 
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        setLocationRelativeTo(null); 

        PainelComFundo panel = new PainelComFundo();  
	    panel.setLayout(null); 

	    add(panel);  
	    placeComponents(panel);  
	    setVisible(true);  }
	
	private void placeComponents(JPanel panel) {
		panel.setLayout(null);
        
       
        JLabel welcomeLabel = new JLabel("Escolha o equipamento:");
        welcomeLabel.setBounds(535, 60, 300, 25); // Posição do rótulo
        
        panel.add(welcomeLabel); 
        
        int buttonWidth = 300;
        int buttonX = (1200 - buttonWidth) / 2;
        
        //placa solart
        JButton cadastrarPlacaSolarButton = new JButton("Cadastrar Placa Solar");
        cadastrarPlacaSolarButton.setBounds(buttonX, 100, buttonWidth, 25); 
        
        String caminhoIcone = "moduloEmpresa/GUI/graphicImages/placaSolar.png"; 
        
        cadastrarPlacaSolarButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        cadastrarPlacaSolarButton.setVerticalTextPosition(SwingConstants.CENTER); 
        cadastrarPlacaSolarButton.setIconTextGap(10); 
        ImageIcon originalIcon = new ImageIcon(getClass().getClassLoader().getResource(caminhoIcone));
        if (originalIcon != null) {
           
            Image img = originalIcon.getImage(); 
            Image scaledImg = img.getScaledInstance(16, 16, Image.SCALE_SMOOTH); // Altera o tamanho para 16x16 pixels
            ImageIcon scaledIcon = new ImageIcon(scaledImg);
            cadastrarPlacaSolarButton.setIcon(scaledIcon); // Define o ícone redimensionado no botão
        } 
        else {
            System.err.println("Ícone não encontrado: " + caminhoIcone);}

        panel.add(cadastrarPlacaSolarButton); 

   
        cadastrarPlacaSolarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode abrir a tela de cadastro de equipamentos
            	dispose();
                new TelaCadastroPlacaSolar(); // Crie a classe TelaCadastroEquipamento para lidar com o cadastro
            }
        });
        
        
        //cadastro do inversor
        JButton cadastrarInversorButton = new JButton("Cadastrar Inversor");
        cadastrarInversorButton.setBounds(buttonX, 150, buttonWidth, 25); 
        
        String caminhoIconeinversor = "moduloEmpresa/GUI/graphicImages/inversor.png"; 
        
        cadastrarInversorButton.setHorizontalTextPosition(SwingConstants.RIGHT);
        cadastrarInversorButton.setVerticalTextPosition(SwingConstants.CENTER); 
        cadastrarInversorButton.setIconTextGap(10); 
        
        ImageIcon originalIconInversor = new ImageIcon(getClass().getClassLoader().getResource(caminhoIconeinversor));
        if (originalIconInversor != null) {
            Image img = originalIconInversor.getImage();
            Image scaledImg = img.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon1 = new ImageIcon(scaledImg);
            cadastrarInversorButton.setIcon(scaledIcon1); 
        } 
        else {
            System.err.println("Ícone não encontrado: " + caminhoIconeinversor);}

        panel.add(cadastrarInversorButton); 

       
        cadastrarInversorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose();
                new TelaCadastroInversor(); 
            }
        });
        
     //botao de voltar pra tela anterior -- INICIAL
        JButton voltarButton = new JButton();
        voltarButton.setBounds(10, 10, 50, 50); 

        String caminhoIconeVoltar = "moduloEmpresa/GUI/graphicImages/voltar2.png"; 
        ImageIcon originalIconVoltar = new ImageIcon(getClass().getClassLoader().getResource(caminhoIconeVoltar));
        if (originalIconVoltar != null) {
            Image img = originalIconVoltar.getImage();
            Image scaledImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
            ImageIcon scaledIconVoltar = new ImageIcon(scaledImg);
            voltarButton.setIcon(scaledIconVoltar);
        } else {
            System.err.println("Ícone não encontrado: " + caminhoIconeVoltar);
        }
        panel.add(voltarButton);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                dispose();
                new TelaInicial(); 
            }
        });

        
	}
	
	
}
