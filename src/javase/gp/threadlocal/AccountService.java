package javase.gp.threadlocal;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Gp
 * @create 2020/4/14 15:51
 */
public class AccountService {
    private AccountDAO dao = new AccountDAO();

    /**
     * 开启事务, 这是一个原子操作, 如果中间出现异常, 会导致数据不一致, from 账户扣钱了而 to 账户却没有收到钱
     * 注意 : 每个线程的Service层的connection 必须要与 DAO层的connection保持一致(使用ThreadLocal)
     * @param from  要扣钱的账户
     * @param money 钱的数量
     * @param to    收钱的账户
     * @return 该事务是否提交成功
     */
    public boolean modifyMoney(String from, int money, String to) {//转账
        Connection connection = null;
        try {
            connection = C3P0ConnectionPool.getConnection();
            connection.setAutoCommit(false);//关闭自动提交
            boolean result = dao.queryBalance(from, money);
            boolean down = dao.downMoney(from, money);
//            int i = 1 / 0;
            boolean add = dao.addMoney(to, money);
            connection.commit();
            C3P0ConnectionPool.removeConnection();//解绑
            connection.close();
            return result && add && down;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (connection != null) {
                    System.out.println("出现异常, 数据库回滚!");
                    connection.rollback();
                    C3P0ConnectionPool.removeConnection();//解绑
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return false;
        }
    }
}
