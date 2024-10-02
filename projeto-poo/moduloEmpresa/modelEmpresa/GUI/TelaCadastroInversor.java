package moduloEmpresa.GUI;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import moduloEmpresa.modelEmpresa.Fabricante;
import moduloEmpresa.modelEmpresa.Inversor;

public class TelaCadastroInversor extends JFrame{
	
    public TelaCadastroInversor() {
        setTitle("Cadastro de Placa Solar");
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
        JLabel welcomeLabel = new JLabel("Cadastro de Inversor:");
        welcomeLabel.setBounds(535, 60, 300, 25);
        panel.add(welcomeLabel);

        // Campo Fabricante
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        fabricanteLabel.setBounds(450, 150, 100, 25);
        panel.add(fabricanteLabel);

        JTextField fabricanteText = new JTextField(20);
        fabricanteText.setBounds(550, 150, 200, 25);
        panel.add(fabricanteText);

        // Campo Valor
        JLabel valorLabel = new JLabel("Valor (R$):");
        valorLabel.setBounds(450, 200, 100, 25);
        panel.add(valorLabel);

        JTextField valorText = new JTextField(20);
        valorText.setBounds(550, 200, 200, 25);
        panel.add(valorText);

        // Campo Potência
        JLabel potenciaLabel = new JLabel("Potência (Watts):");
        potenciaLabel.setBounds(450, 250, 150, 25);
        panel.add(potenciaLabel);

        JTextField potenciaText = new JTextField(20);
        potenciaText.setBounds(600, 250, 150, 25);
        panel.add(potenciaText);

        // Botão de Cadastro
        JButton cadastrarButton = new JButton("Cadastrar Inversor");
        cadastrarButton.setBounds(450, 350, 300, 30);
        panel.add(cadastrarButton);

        // Ação ao clicar no botão de cadastro
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fabricante = fabricanteText.getText();
                String valorStr = valorText.getText();
                String potenciaStr = potenciaText.getText();

                try {
                    double valor = Double.parseDouble(valorStr);
                    int potencia = Integer.parseInt(potenciaStr);

                   
                    Fabricante fab = new Fabricante(fabricante); 
                    Inversor inversor = new Inversor(fab, valor, potencia);

                    
                    JOptionPane.showMessageDialog(panel, "Inversor cadastrado com sucesso!");

                 
                    String info = inversor.exibirInfos(); 
                    JOptionPane.showMessageDialog(panel, info, "Informações do Inversor", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    
                	JOptionPane.showMessageDialog(panel, "Por favor, insira valores válidos para o valor e a potência.", "Erro", JOptionPane.ERROR_MESSAGE);
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
                new TelaCadastroEquipamento(); 
            }
        });
    }
}
