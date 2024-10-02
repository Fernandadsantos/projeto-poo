package moduloEmpresa.GUI;

import javax.swing.*;

import moduloEmpresa.modelEmpresa.Fabricante;
import moduloEmpresa.modelEmpresa.PlacaSolar;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCadastroPlacaSolar extends JFrame {

    public TelaCadastroPlacaSolar() {
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

        
        JLabel welcomeLabel = new JLabel("Cadastro de Placa Solar:");
        welcomeLabel.setBounds(535, 60, 300, 25); 
        panel.add(welcomeLabel);

       
        JLabel fabricanteLabel = new JLabel("Fabricante:");
        fabricanteLabel.setBounds(450, 150, 100, 25);
        panel.add(fabricanteLabel);

        JTextField fabricanteText = new JTextField(20);
        fabricanteText.setBounds(550, 150, 200, 25);
        panel.add(fabricanteText);

        
        JLabel valorLabel = new JLabel("Valor (R$):");
        valorLabel.setBounds(450, 200, 100, 25);
        panel.add(valorLabel);

        JTextField valorText = new JTextField(20);
        valorText.setBounds(550, 200, 200, 25);
        panel.add(valorText);

        JLabel capacidadeLabel = new JLabel("Capacidade (Watts):");
        capacidadeLabel.setBounds(450, 250, 150, 25);
        panel.add(capacidadeLabel);

        JTextField capacidadeText = new JTextField(20);
        capacidadeText.setBounds(600, 250, 150, 25);
        panel.add(capacidadeText);

       
        JButton cadastrarButton = new JButton("Cadastrar Placa Solar");
        cadastrarButton.setBounds(450, 350, 300, 30);
        panel.add(cadastrarButton);

       //criar placa
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fabricante = fabricanteText.getText();
                String valorStr = valorText.getText();
                String capacidadeStr = capacidadeText.getText();

                try {
                    double valor = Double.parseDouble(valorStr);
                    int capacidade = Integer.parseInt(capacidadeStr);

                   
                    Fabricante fabricante1= new Fabricante(fabricante); 
                    PlacaSolar placaSolar = new PlacaSolar(fabricante1, valor, capacidade);

                   
                    JOptionPane.showMessageDialog(panel, "Placa Solar cadastrada com sucesso!");

                    String info = placaSolar.exibirInfos(); 
                    JOptionPane.showMessageDialog(panel, info, "Informações do Inversor", JOptionPane.INFORMATION_MESSAGE);

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(panel, "Por favor, insira valores válidos para o valor e a capacidade.", "Erro", JOptionPane.ERROR_MESSAGE);
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