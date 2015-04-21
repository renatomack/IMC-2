package imc;

//importação das classes necessárias
//layouts para alinhamento dos componentes
import java.awt.FlowLayout;
import java.awt.GridLayout;
//janela
import javax.swing.JFrame;
//botão
import javax.swing.JButton;
//caixa de seleção
import javax.swing.JComboBox;
//inserção de texto e/ou imagem
import javax.swing.JLabel;
//classe Icon junto com ImageIcon anexão uma imagem a um Jlabel
import javax.swing.Icon;
import javax.swing.ImageIcon;
//exibição de textos numa pequena caixa de mensagens
import javax.swing.JOptionPane;
//painel
import javax.swing.JPanel;
//campo para inserção de valores ou caracteres
import javax.swing.JTextField;
//Evento de executar uma ação do evento que foi ouvido(ativado)
import java.awt.event.ActionEvent;

//Criação da classe EX2 extendendo a classe JFrame que foi importada
public class Ex2 extends JFrame {
    //declaração das variáveis
    //Vetor de caracteres (String) de 2 colunas

    //criando um array já com os valores configurados do tipo double
    private int tipo;
    private double altura;
    private double peso;
    private double massa;
    private double[] imc = {20.7, 26.4};
    private String string = "";

    //criação do FlowLayout que alinha componentes da esquerda para a direita.
    private final FlowLayout flowLayout = new FlowLayout();
    /*criação de GridLayout com 4 linhas e 2 colunas com 10 de espaço em largura
     e 1 de altura*/
    private final GridLayout gridLayout = new GridLayout(4, 2, 10, 1);
    //criação de um painel
    private final JPanel gridJPanel = new JPanel();

    //criação de dois botões com os nomes Calcular e Limpar Dados
    private final JButton butao = new JButton("Calcular");
    private final JButton butao2 = new JButton("Limpar Dados");
    //criação das label's
    private final JLabel Laltura = new JLabel("Altura em cm:");
    private final JLabel Lpeso = new JLabel("Peso em Kg:");
    private final JLabel Lresultado = new JLabel("");
    private final JLabel Lfoto = new JLabel("");
    //criação de campos com 5 de largura
    private final JTextField Faltura = new JTextField("", 5);
    private final JTextField Fpeso = new JTextField("", 5);

//    //criação de uma caixa de seleção
//    private JComboBox escolha = new JComboBox(getSexo());
    //anexando a imagem um icone de nome limpar
    private final Icon limpar = new ImageIcon(getClass().getResource("blank.gif"));

    //construtor de Ex2 sem argumentos
    public Ex2() {
        //título  da janela
        super("Calculo do IMC(Índice de massa corporal)");
        //alinhamento do frame com o uso do objeto flowLayout
        super.setLayout(flowLayout);
        //tamanho da janela
        setSize(370, 160);
        //inclusão dos componentes de maximinizar, miniminizar e fechar
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //exibe 2 linhas da caixa de seleção ao clicá-la
//        escolha.setMaximumRowCount(2);
        //alinha o painel com o objeto gridLayout
        gridJPanel.setLayout(gridLayout);
        //adiciona os componentes
//        gridJPanel.add(escolha);
        gridJPanel.add(Laltura);
        gridJPanel.add(Faltura);
        gridJPanel.add(Lpeso);
        gridJPanel.add(Fpeso);
        gridJPanel.add(butao);
        gridJPanel.add(butao2);

        //adiciona a janela principal
        super.add(gridJPanel);
        super.add(Lresultado);

        //criação de uma classe interna anônima para butao
        butao.addActionListener((ActionEvent event) -> {
            Calculos();
        } //Fim da classe interna anônima
        );//fim da chamada para addActionListerner

        //classe interna anônima para butao2
        butao2.addActionListener((ActionEvent event) -> {
            limpar();
        } //ao clicar no butao2 de nome limpar chama o método limpar
        //Fim da classe interna anônima
        );//fim da chamada para addActionListerner
    }

    //método que realiza os calculos
    private void Calculos() {
        try //tratador de erros com try e catch
        {
            //pega e converte os caracteres em ponto flutuante do campo Faltura para a variavel altura
            setAltura(Double.parseDouble(Faltura.getText()));
            //da mesma forma com Fpeso para a variável peso
            setPeso(Double.parseDouble(Fpeso.getText()));
            //realiza calculos
            setMassa(getPeso() / (getAltura() * getAltura()));

            /*Se a massa corporal for menor do que o estabelecido pelo vetor configure a variável
             string com essa frase*/
            if (getImc()[0] > getMassa()) {
                string = String.format("CUIDADO!!!Você está abaixo do peso! IMC %.2f", getMassa());
            } else if ((getImc()[0] < getMassa()) && (getMassa() <= getImc()[1])) {
                string = String.format("PARABÉNS!!Você está com o peso ideal! IMC %.2f", getMassa());
            } else {
                string = String.format("CUIDADO!!Você está obeso(a)! IMC %.2f", getMassa());
            }

            //reconfigure o tamanho da tela
            setSize(370, 180);
            //configure a label Lresultado com a variável string
            Lresultado.setText(string);
        } //caso ocorra uma excessão(erro) exiba uma mensagem nua caixa de mensagem
        catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, "Número inválido!\nEx: Use '.' ao invés de ',' para separar as casas decimais.");
            //limpe s campos e variáveis
            Fpeso.setText("");
            Faltura.setText("");
            setPeso(0);
            setAltura(0);
        }
    }

    //método para limpar os dados da tela e retornar a tela ao seu tamanho original
    private void limpar() {
        Fpeso.setText("");
        Faltura.setText("");
        Lresultado.setText("");
        //substitua a imagem atual por essa
        Lfoto.setIcon(limpar);
        setSize(300, 160);
    }

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @return the altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * @return the peso
     */
    public double getPeso() {
        return peso;
    }

    /**
     * @return the massa
     */
    public double getMassa() {
        return massa;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * @param massa the massa to set
     */
    public void setMassa(double massa) {
        this.massa = massa;
    }

    /**
     * @return the imc
     */
    public double[] getImc() {
        return imc;
    }

    /**
     * @param imc the imc to set
     */
    public void setImc(double[] imc) {
        this.imc = imc;
    }

}//Fim da classe Ex2
