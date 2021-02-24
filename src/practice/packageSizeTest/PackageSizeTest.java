package practice.packageSizeTest;

import java.util.*;

public class PackageSizeTest {
    private List<Integer> packageSizes;

    public PackageSizeTest(){
        packageSizes = Arrays.asList(6, 9, 20);
    }

    /**
     * Find all grouping configurations, will return duplicates.
     * @param numWanted the target amount of items
     * @return the total number of valid groupings.  Will contain duplicates when order is different.
     */
    public List<PackageGroup> findAllGroupings(Integer numWanted){
        LinkedList<PackageGroup> groups = new LinkedList<>();
        LinkedList<PackageGroup> matches = new LinkedList<>();
        groups.add(new PackageGroup(0));
        while(!groups.isEmpty()){
            PackageGroup curGrp = groups.pop();
            for(Integer i : packageSizes){
                int curTotal = curGrp.getCurrentTotal() + i;
                PackageGroup newGroup = new PackageGroup(curTotal);
                // Tricky to figure out, using a simple assignment lead a single ever-growing list.
                // This is the proper method to copy the contents of a list into a new list.
                newGroup.getPackageList().addAll(curGrp.getPackageList());
                newGroup.getPackageList().add(i);
                if(curTotal == numWanted){
                    matches.add(newGroup);
                } else if(curTotal < numWanted){
                    groups.add(newGroup);
                }
            }
        }

        return matches;
    }

    public boolean doesGroupExist(Integer numWanted){
        return !findAllGroupings(numWanted).isEmpty();
    }

    public List<PackageGroup> findUniqueGroupings(Integer numWanted){
        // This is explicitly a LinkedList so it can use queue functionality of LinkedList
        LinkedList<PackageGroup> allGroups = (LinkedList<PackageGroup>) findAllGroupings(numWanted);
        List<PackageGroup> uniqueGroups = new LinkedList<>();
        
        // Sort the lists
        for(PackageGroup group : allGroups){
            Collections.sort(group.getPackageList());
        }

        // Compare each list to all other lists, only keep ones that don't have a match
        while(!allGroups.isEmpty()){
            boolean toAdd = true;
            PackageGroup current = allGroups.pop();
            for(PackageGroup group : allGroups){
                if(current.getPackageList().equals(group.getPackageList())){
                    toAdd = false;
                }
            }

            if(toAdd){
                uniqueGroups.add(current);
            }
        }

        return uniqueGroups;
    }

    public List<PackageGroup> findMostEfficientGroupings(Integer numWanted){
        // First gather only unique combinations
        List<PackageGroup> uniques = findUniqueGroupings(numWanted);
        List<PackageGroup> shortests = new LinkedList<>();

        // TODO: Sort 'uniques' by length of packageList.  Will likely need to write own comparator for this.
        // TODO: Once sorting is done keep all groups that have the lowest number of items in packageList.
        // TODO: This may only return one value, it may return multiple if there are multiple with same-sized
        // TODO: packageLists.

        return shortests;
    }

    /**
     * Original implementation, only finds first match if any matches exist.  Replaced with more flexible design
     * @param numWanted
     * @return
     */
    public boolean doesGroupExistProt(int numWanted){
        boolean foundMatch = false;
        LinkedList<Integer> values = new LinkedList<>();

        values.add(0);
        while(!foundMatch && !values.isEmpty()){
            Integer curVal = values.pop();
            for(Integer i : packageSizes){
                if(curVal + i == numWanted){
                    foundMatch = true;
                    break;
                } else if (curVal + i < numWanted){
                    values.add(curVal + i);
                }
            }
        }

        return foundMatch;
    }
}
