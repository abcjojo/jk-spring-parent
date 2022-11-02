package 面试题.huawei;

public class NC63 {
    public static void main(String[] args) {

    }

    public int jumpFloor(int target) {

        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return jumpFloor(target - 1) + jumpFloor(target - 2);
        }

    }
}
