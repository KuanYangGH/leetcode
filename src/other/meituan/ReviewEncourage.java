package other.meituan;

class ReviewEncourage {
    int n = 0;

    public ReviewEncourage(int n) {
        this.n = n;
    }      // 构造函数,n为中奖用户数

/*

    PrizePool类仅有一个send方法，实现如下：

    public class PrizePool {

        public void send(String input) {

            System.out.print(input);

        }

    }

  */

    public void bonus(PrizePool prizePool) {
        prizePool.send("A");
    }  // 仅能打印A，表示发放积分

    public void coupon(PrizePool prizePool) {
        prizePool.send("B");
    }  // 仅能打印B，表示发放优惠券

    public void contribution(PrizePool prizePool) {
        prizePool.send("C");
    }  // 仅能打印C，表示发放贡献值

}
