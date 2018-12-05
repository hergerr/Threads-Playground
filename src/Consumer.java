/*
 * Program: Producent - Konsument
 * 
 * Plik: Consumer.java
 * Klasa modelu Konsumenta 
 * 
 * 
 * Autor:Tymoteusz Frankiewicz
 * Data: listopad/grudzien 2018
 */

class Consumer extends Worker {

    public Consumer(String name , Buffer buffer){
        this.name = name;
        this.buffer = buffer;
        run = true;
    }

    @Override
    public void run(){
        int item;
        while(run){
            // Konsument pobiera przedmiot z bufora
            item = buffer.get(this);

            // Konsument zużywa popraany przedmiot.
            sleep(MIN_CONSUMER_TIME, MAX_CONSUMER_TIME);
            ProducerConsumerApp.textArea.append("Konsument <" + name + ">       zużył: " + item + "\n");
        }
    }

}