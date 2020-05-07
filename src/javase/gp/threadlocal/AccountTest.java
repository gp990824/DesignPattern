package javase.gp.threadlocal;

/**
 * @author Gp
 * @create 2020/4/14 15:55
 */
public class AccountTest {
    private static AccountService service = new AccountService();
    public static void main(String[] args) {
        System.out.println(service.modifyMoney("wsc", 100, "gp"));
    }
}
