import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        FlatDarculaLaf.setup();
        SwingUtilities.invokeLater(() -> {
            telaCalculadora janela = new telaCalculadora();
            janela.setTitle("Calculadora");
            janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            janela.setSize(300, 480);
            janela.setMinimumSize(new Dimension(290, 420));
            janela.setPreferredSize(new Dimension(300, 470));
            janela.setLocationRelativeTo(null);
            janela.setVisible(true);
        });
    }

}