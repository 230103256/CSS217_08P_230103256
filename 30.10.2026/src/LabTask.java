public class LabTask {
    public static void main(String[] args) {


        System.out.println("--- Test 1: Standard Alert via SMS (No Proxy) ---");
        Sender directSms = new SmsSender();
        Notification alert1 = new StandardAlert(directSms);
        alert1.deliver("Lab session starts in 10 minutes.");
        System.out.println();


        System.out.println("--- Test 2: Urgent Alert via Proxied Email ---");
        Sender realEmail = new EmailSender();
        Sender proxiedEmail = new SenderLoggingProxy(realEmail);
        Notification alert2 = new UrgentAlert(proxiedEmail);
        alert2.deliver("Database connection failed!");
        System.out.println();

        System.out.println("--- Test 3: Second Alert through Same Proxy ---");
        alert2.deliver("Disk space low on /dev/sda1");
    }
}
