package 알고리즘;

public class DynamicAndRecurcive {
    public void dynamic(int data) {
        Integer[] nums = new Integer[data+1];
        nums[0] = 0;
        nums[1] = 1;
        for(int i = 2; i < nums.length; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }

        System.out.println(nums[data]);
    }

    public int recursive(int data) {
        if(data <= 1) {
            return data;
        }

        return recursive(data - 1) + recursive(data - 2);
    }

    public static void main(String[] args) {
        DynamicAndRecurcive dynamicAndRecurcive = new DynamicAndRecurcive();
        dynamicAndRecurcive.dynamic(4);

        System.out.println(dynamicAndRecurcive.recursive(4));
    }

}
