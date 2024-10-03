package moduloEmpresa.GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import moduloEmpresa.modelEmpresa.Fabricante;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroFabricante extends JFrame {

    public TelaCadastroFabricante() {
        setTitle("Cadastro de Fabricante");
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        PainelComFundo panel = new PainelComFundo();  
	    panel.setLayout(null); 

	    add(panel);  
	    placeComponents(panel);  
	    setVisible(true); 
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        // Label de boas-vindas
        JLabel welcomeLabel = new JLabel("Cadastro Fabricantes:");
        welcomeLabel.setBounds(535, 60, 300, 25);
        panel.add(welcomeLabel);

        // Label e campo de texto para o nome do fabricante
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        fabricanteLabel.setBounds(450, 150, 100, 25);
        panel.add(fabricanteLabel);

        JTextField fabricanteText = new JTextField(20);
        fabricanteText.setBounds(550, 150, 200, 25);
        panel.add(fabricanteText);

        // Botão de cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.setBounds(550, 200, 200, 25);
        panel.add(cadastrarButton);

        
        
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
        public void actionPerformed(ActionEvent e) {
                String nomeFabricante = fabricanteText.getText();
                
                if (!nomeFabricante.isEmpty()) {
                    
                    new Fabricante(nomeFabricante);
                    
                    
                    JOptionPane.showMessageDialog(null, "Fabricante '" + nomeFabricante + "' cadastrado com sucesso!");
                    fabricanteText.setText(""); 
                } else {
                    
                    JOptionPane.showMessageDialog(null, "Por favor, insira o nome do fabricante.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

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
