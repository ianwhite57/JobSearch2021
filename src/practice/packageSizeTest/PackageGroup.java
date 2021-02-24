package practice.packageSizeTest;

import java.util.LinkedList;
import java.util.List;

public class PackageGroup {
    private Integer currentTotal;
    private List<Integer> packageList;

    public PackageGroup(Integer ct){
        currentTotal = ct;
        packageList = new LinkedList<>();
    }

    public Integer getCurrentTotal() {
        return currentTotal;
    }

    public void setCurrentTotal(Integer currentTotal) {
        this.currentTotal = currentTotal;
    }

    public List<Integer> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Integer> packageList) {
        this.packageList = packageList;
    }

    public void printPackageList(){
        if(packageList.isEmpty()){
            return;
        }
        System.out.print("[ ");
        for(Integer i : packageList){
            System.out.print(i + " ");
        }
        System.out.println("]");
    }
}
