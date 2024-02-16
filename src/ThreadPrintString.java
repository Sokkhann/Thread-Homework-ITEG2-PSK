public class ThreadPrintString extends Thread{

    private String msg;
    public ThreadPrintString(String msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        // print each character from the string that we input
        for (int i = 0; i<msg.length(); i++) {
            // checking if the string contains the word "Downloading"
            // it will print the whole word Downloading instead of print one by one character
            // startsWith() is the method set the whole word Downloading into one index( index i)
            if (msg.startsWith("Downloading", i)) {
                System.out.print("Downloading");
                // reset the length of the string
                // after converting length of Downloading into one index
                i += "Downloading".length() - 1;
            } else {
                // if the iteration don't meet the word downloading it will print one by one char
                System.out.print(msg.charAt(i));
            }

            // I want to sleep differently
            // every char position is sleep only 100 millisecond
            // but every char that modulo with 5 sleep 200 millisecond
            // to see the different output make it look cooler!
            if (msg.indexOf(i) / 5 == 0) {
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        // string that we want to print
        String mainCharacter = """
                Welcome to CSTAD!
                **************************************************
                Don't give up this opportunity, do your best first
                --------------------------------------------------
                Downloading.........................complete 100%.
                """;
        Thread thread = new ThreadPrintString(mainCharacter);
        thread.start();
    }
}
