class SmsSender implements Sender {
    public void send(String message) {
        System.out.println("[SMS] " + message);
    }
}
