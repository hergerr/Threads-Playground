import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ProducerConsumerApp extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private Integer[] possibleConsProdBufSizes = {1,2,3,4,5};
	public static JTextArea textArea = new JTextArea(15, 50);
	private JScrollPane scroll = new JScrollPane(textArea);
	
	
	private JPanel panel = new JPanel();
	private JLabel buforSizeLabel = new JLabel("Rozmiar bufora");
	private JLabel producerQuantityLabel = new JLabel("Ilość producentów");
	private JLabel consumerQuantityLabel = new JLabel("Rozmiar konsumentów");
	private JComboBox<Integer> buforSizeComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JComboBox<Integer> producerQuantityComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JComboBox<Integer> consumerQuantityComboBox = new JComboBox<Integer>(possibleConsProdBufSizes);
	private JButton stopButton = new JButton("Zatrzymaj symulacje");
	private JButton startButton = new JButton("Start");
	private int bufforSize;
	private int producerQuantity;
	private int consumerQuantity;
	private Buffer buffer;
	private Consumer c1,c2,c3,c4,c5;
	private Producer p1,p2,p3,p4,p5;
	
	private Consumer[] consumers = {c1,c2,c3,c4,c5};
	private Producer[] producers = {p1,p2,p3,p4,p5};
	
	public static void main(String[] args){
    	new ProducerConsumerApp();
    }
    
    
    
    ProducerConsumerApp(){
    	this.setTitle("Wątki - okno główne");
    	this.setSize(600, 400);
    	this.setLocationRelativeTo(null);
    	
    	stopButton.addActionListener(e -> {


    	});
    	
    	startButton.addActionListener(e -> {
    		bufforSize = (int) buforSizeComboBox.getSelectedItem();
    		producerQuantity = (int) producerQuantityComboBox.getSelectedItem();
    		consumerQuantity = (int) consumerQuantityComboBox.getSelectedItem();
    		
    		buffer = new Buffer(bufforSize);
    		
    		for(int i = 0; i < producerQuantity; ++i) {
    			producers[i] = new Producer("P" + Integer.toString(i + 1), buffer);
    			producers[i].start();
    		}
    		
    		for(int i = 0; i < consumerQuantity; ++i) {
    			consumers[i] = new Consumer("K" + Integer.toString(i + 1), buffer);
    			consumers[i].start();
    		}
    	});
    	
    	panel.add(buforSizeLabel);
    	panel.add(buforSizeComboBox);
    	panel.add(producerQuantityLabel);
    	panel.add(producerQuantityComboBox);
    	panel.add(consumerQuantityLabel);
    	panel.add(consumerQuantityComboBox);
    	
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	panel.add(scroll);

    	panel.add(startButton);
    	panel.add(stopButton);
    	
    	this.add(panel);
    	this.setVisible(true);
    }



    

}