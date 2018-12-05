/*
 * Program: Producent - Konsument
 * 
 * Plik: Producer.java
 * Klasa modelu Pracownika 
 * 
 * 
 * Autor:Tymoteusz Frankiewicz
 * Data: listopad/grudzien 2018
 */


class Producer extends Worker {

    public Producer(String name , Buffer buffer){
        this.name = name;
        this.buffer = buffer;
        run = true;
    }
    

    @Override
    public void run(){
        int item;
        while(run){
            // Producent "produkuje" nowy przedmiot.
            item = Worker.itemID++;
            ProducerConsumerApp.textArea.append("Producent <" + name + ">   produkuje: " + item + "\n");
            sleep(MIN_PRODUCER_TIME, MAX_PRODUCER_TIME);

            // Producent umieszcza przedmiot w buforze.
            buffer.put(this, item);
        }
    }

}