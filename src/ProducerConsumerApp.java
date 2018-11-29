import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ProducerConsumerApp extends JFrame{
	
	private Integer[] possibleConsProdBufSizes = {1,2,3,4,5};
	
	private JTextArea textArea = new JTextArea(15, 50);
	private JPanel panel = new JPanel();
	private JLabel buforSizeLabel = new JLabel("Rozmiar bufora");
	private JLabel producerQuantityLabel = new JLabel("Ilość producentów");
	private JLabel consumerQuantityLabel = new JLabel("Rozmiar konsumentów");
	private JComboBox<Integer> buforSizeComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JComboBox<Integer> producerQuantityComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JComboBox<Integer> consumerQuantityComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JButton stopButton = new JButton("Zatrzymaj symulacje");
	private JButton startButton = new JButton("Start");

    public static void main(String[] args){
    	new ProducerConsumerApp();
    }
    
    ProducerConsumerApp(){
    	this.setTitle("Wątki - okno główne");
    	this.setSize(600, 400);
    	this.setLocationRelativeTo(null);
    	panel.add(buforSizeLabel);
    	panel.add(buforSizeComboBox);
    	panel.add(producerQuantityLabel);
    	panel.add(producerQuantityComboBox);
    	panel.add(consumerQuantityLabel);
    	panel.add(consumerQuantityComboBox);

    	panel.add(textArea);

    	panel.add(startButton);
    	panel.add(stopButton);
    	
    	this.add(panel);
    	this.setVisible(true);
    }

}