package moduloEmpresa.GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PainelComFundo extends JPanel {
    private Image backgroundImage;

    // Construtor que carrega a imagem de fundo a partir do caminho específico
    public PainelComFundo() {
        try {
            // Carrega a imagem de fundo
            backgroundImage = ImageIO.read(getClass().getClassLoader().getResource("moduloEmpresa/GUI/graphicImages/fundo1.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erro ao carregar a imagem de fundo: moduloEmpresa/GUI/graphicImages/fundo1.png");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Verifica se a imagem foi carregada com sucesso
        if (backgroundImage != null) {
            // Calcula o tamanho do painel e redimensiona a imagem de acordo com ele
            int panelWidth = getWidth();
            int panelHeight = getHeight();

            // Desenha a imagem de fundo redimensionada para preencher o painel
            g.drawImage(backgroundImage, 0, 0, panelWidth, panelHeight, this);
        }
    }
}
