package practice.packageSizeTest;

import java.util.List;

public class Main {
    public static void main(String[] argv){
        PackageSizeTest pst = new PackageSizeTest();

        System.out.println("---------21--------");
        System.out.println("pst.doesGroupExist(21) = " + pst.doesGroupExist(21));
        printGroupBreakdowns(pst.findAllGroupings(21));
        printGroupBreakdowns(pst.findUniqueGroupings(21));
        printGroupBreakdowns(pst.findMostEfficientGroupings(21));
        System.out.println("---------19--------");
        System.out.println("pst.doesGroupExist(20) = " + pst.doesGroupExist(19));
        printGroupBreakdowns(pst.findAllGroupings(19));
        printGroupBreakdowns(pst.findUniqueGroupings(19));
        printGroupBreakdowns(pst.findMostEfficientGroupings(19));
        System.out.println("---------18--------");
        System.out.println("pst.doesGroupExist(21) = " + pst.doesGroupExist(18));
        printGroupBreakdowns(pst.findAllGroupings(18));
        printGroupBreakdowns(pst.findUniqueGroupings(18));
        printGroupBreakdowns(pst.findMostEfficientGroupings(18));
    }

    public static void printGroupBreakdowns(List<PackageGroup> groups){
        if(groups.isEmpty()){
            return;
        }

        for(PackageGroup curGrp : groups){
            curGrp.printPackageList();
        }
        System.out.println();
    }
}
