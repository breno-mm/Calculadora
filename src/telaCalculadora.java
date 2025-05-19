import javax.swing.*;

public class telaCalculadora extends javax.swing.JFrame {

    private JPanel initPanel;
    private JButton bt_MC;
    private JTextField inputDisplay;
    private JButton bt_C;
    private JButton bt_div;
    private JButton bt_MA;
    private JButton bt_MPlus;
    private JButton bt_9;
    private JButton bt_mult;
    private JButton bt_8;
    private JButton bt_7;
    private JButton bt_6;
    private JButton bt_5;
    private JButton bt_4;
    private JButton bt_sub;
    private JButton bt_3;
    private JButton bt_2;
    private JButton bt_1;
    private JButton bt_virg;
    private JButton bt_porc;
    private JButton bt_0;
    private JButton bt_plus;
    private JButton bt_resultado;
    private JButton bt_MR;
    private JButton bt_apagar;

    Calculo calc = new Calculo();
    Memoria memoria = new Memoria();
    String operador = "";
    private float adc1 = 0;

    public telaCalculadora() {
        setContentPane(initPanel);

        bt_0.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("0"));
        });
        bt_1.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("1"));
        });
        bt_2.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("2"));
        });
        bt_3.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("3"));
        });
        bt_4.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("4"));
        });
        bt_5.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("5"));
        });
        bt_6.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("6"));
        });
        bt_7.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("7"));
        });
        bt_8.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("8"));
        });
        bt_9.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("9"));
        });

        bt_virg.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("."));
        });

        //opradores
        bt_plus.addActionListener( e -> {
            adc1 = Float.parseFloat(inputDisplay.getText());
            operador = "+";
            inputDisplay.setText("0");
        });
        bt_sub.addActionListener( e -> {
            adc1 = Float.parseFloat(inputDisplay.getText());
            operador = "-";
            inputDisplay.setText("0");
        });
        bt_mult.addActionListener( e -> {
            adc1 = Float.parseFloat(inputDisplay.getText());
            operador = "*";
            inputDisplay.setText("0");
        });
        bt_div.addActionListener( e -> {
            adc1 = Float.parseFloat(inputDisplay.getText());
            operador = "/";
            inputDisplay.setText("0");
        });

        bt_porc.addActionListener( e -> {
            inputDisplay.setText(numeroDisplay("%"));
            if('%' == inputDisplay.getText().charAt(inputDisplay.getText().length()-1)){
                inputDisplay.setText(calc.operacoes(adc1, (Float.parseFloat(inputDisplay.getText().substring(0, inputDisplay.getText().length()-1))/100)*adc1, operador) + "");
            }
        });

        //Resultado
        bt_resultado.addActionListener( e -> {
            if(adc1 != 0){
                if('%' == inputDisplay.getText().charAt(inputDisplay.getText().length()-1)){
                    inputDisplay.setText(calc.operacoes(adc1, (Float.parseFloat(inputDisplay.getText().substring(0, inputDisplay.getText().length()-1))/100)*adc1, operador) + "");
                }else {
                    inputDisplay.setText(calc.operacoes(adc1, Float.parseFloat(inputDisplay.getText()), operador) + "");
                }
            }
        });

        //Limpar
        bt_C.addActionListener( e -> {
            inputDisplay.setText("0");
            adc1 = 0;
        });
        //Apagar digitos
        bt_apagar.addActionListener(e -> {
            String numAtual = inputDisplay.getText();

            if(numAtual.length() <= 1){
                inputDisplay.setText("0");
            }else{
                String apagar = numAtual.substring(0, numAtual.length() - 1);
                inputDisplay.setText(apagar);
            }
        });
        //Memoria
        bt_MC.addActionListener( e -> {
            memoria.limpar();
        });
        //Adiciona a memória
        bt_MPlus.addActionListener( e -> {
            float valorAtual = Float.parseFloat(inputDisplay.getText());
            memoria.adicionar(valorAtual);
            inputDisplay.setText("0");
            adc1 = 0;
        });
        //Subtrai da memória
        bt_MA.addActionListener( e -> {
            float valorAtual = Float.parseFloat(inputDisplay.getText());
            memoria.subtrair(valorAtual);
            inputDisplay.setText("0");
            adc1 = 0;
        });
        bt_MR.addActionListener(e -> {
            inputDisplay.setText(memoria.recuperar() + "");
        });


    }

    String numeroDisplay(String numero){
        if(inputDisplay.getText().equals("0"))
            return numero;
        return inputDisplay.getText() + numero;
    }
}
