class Consumer extends Worker {

    public Consumer(String name , Buffer buffer){
        this.name = name;
        this.buffer = buffer;
    }

    @Override
    public void run(){
        int item;
        while(true){
            // Konsument pobiera przedmiot z bufora
            item = buffer.get(this);

            // Konsument zu�ywa popraany przedmiot.
            sleep(MIN_CONSUMER_TIME, MAX_CONSUMER_TIME);
            System.out.println("Konsument <" + name + ">       zu�y�: " + item);
        }
    }

}