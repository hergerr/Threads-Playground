public class Buffer{
	private int contents;
	private int size;
	private int currentQuantityOfItems;
	
	Buffer(int size){
		this.size = size;
		currentQuantityOfItems = 0;
	}
	
	public synchronized int get(Consumer consumer) {
		ProducerConsumerApp.textArea.append("Konsument <" + consumer.name + "> chce zabrac" + "\n");
	        while (currentQuantityOfItems == 0){
	            try {
	            	ProducerConsumerApp.textArea.append("Konsument <" + consumer.name + ">   bufor pusty - czekam"+ "\n");
	                wait();
	            } catch (InterruptedException e) { }
	        }
	        int item = contents;
	        --currentQuantityOfItems;
	        ProducerConsumerApp.textArea.append("Konsument <" + consumer.name + ">      zabral: " + contents + "\n");
	        notifyAll();
	        return item;
	}
	
	public synchronized void put(Producer producer, int item){
		ProducerConsumerApp.textArea.append("Producent <" + producer.name + ">  chce oddac: " + item + "\n");
        while (currentQuantityOfItems == size){
            try {
            	ProducerConsumerApp.textArea.append("Producent <" + producer.name + ">   bufor pełny - czekam" + "\n");
                wait();
            } catch (InterruptedException e) { }
        }
        contents = item;
        ++currentQuantityOfItems;
        System.out.println(currentQuantityOfItems);
        ProducerConsumerApp.textArea.append("Producent <" + producer.name + ">       oddal: " + item + "\n");
        notifyAll();
	}
}