package moduloEmpresa.GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import compartilhado.database.Database;
import moduloEmpresa.modelEmpresa.Fabricante;

public class TelaListarFabricante extends JFrame {

    public TelaListarFabricante() {
        setTitle("Todos Fabricantes Encontrados na Base");
        setSize(1200, 800); // Mantendo o tamanho da tela
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Lista de Fabricantes", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 24)); // Estilo do título
        panel.add(titleLabel, BorderLayout.NORTH);

        // Preenchendo a tabela com a lista de fabricantes
        List<Fabricante> fabricantes = Database.getTodosFabricantes();
        String[] columnNames = {" ", "Nome"};
        Object[][] data;

        if (fabricantes.isEmpty()) {
            data = new Object[][]{{"1", "Nenhum fabricante cadastrado."}}; // Mensagem se não houver fabricantes
        } else {
            data = new Object[fabricantes.size()][2];
            for (int i = 0; i < fabricantes.size(); i++) {
                data[i][0] = String.valueOf(i + 1); // Adiciona o índice do fabricante
                data[i][1] = fabricantes.get(i).getNome(); // Adiciona o nome do fabricante
            }
        }

        // Criando a tabela
        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.setBackground(Color.WHITE); // Cor de fundo
        table.setForeground(Color.BLACK); // Cor do texto

        // Aumentando a fonte da tabela
        table.setFont(new Font("Arial", Font.PLAIN, 18));

        // Alinhando o texto ao centro
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Centraliza o texto
        table.getColumnModel().getColumn(1).setCellRenderer(centerRenderer); // Alinha nomes ao centro
        table.getColumnModel().getColumn(0).setCellRenderer(centerRenderer); // Alinha índices ao centro

        // Definindo a largura da coluna do índice
        TableColumn indexColumn = table.getColumnModel().getColumn(0);
        indexColumn.setPreferredWidth(10); // Ajuste a largura conforme necessário

        // Adicionando uma linha de divisão
        table.setShowHorizontalLines(true);
        table.setShowVerticalLines(false);

        JScrollPane scrollPane = new JScrollPane(table); // Adiciona a JTable a um JScrollPane
        panel.add(scrollPane, BorderLayout.CENTER); // Adiciona o JScrollPane ao centro do painel

        // Criando o botão "Voltar"
        JButton voltarButton = new JButton();
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

        // Adicionando o botão no painel
        panel.add(voltarButton, BorderLayout.SOUTH); // Alinhando o botão na parte inferior

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new TelaInicial();
            }
        });

        add(panel); // Adiciona o painel à JFrame
        setVisible(true);
    }
}
