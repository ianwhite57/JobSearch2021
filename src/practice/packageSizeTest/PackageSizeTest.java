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
     * @return all valid groupings.  Will contain duplicates when order is different.
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
                // This is the proper way to copy the contents of a list into a new list.
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

    /**
     * @param numWanted the target amount of items
     * @return a boolean value of whether or not valid groupings are found
     */
    public boolean doesGroupExist(Integer numWanted){
        return !findAllGroupings(numWanted).isEmpty();
    }

    /**
     * Find all unique grouping configurations, does not return duplicates.
     * @param numWanted the target amount of items
     * @return all unique valid groupings.
     */
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

    /**
     * Find the most efficient groupings.  If there are multiple equally-efficient groupings it will return all of them.
     * Filters out duplicate groupings with different orderings.
     * @param numWanted the target amount of items
     * @return the most efficient valid groupings.
     */
    public List<PackageGroup> findMostEfficientGroupings(Integer numWanted){
        // First gather only unique combinations
        List<PackageGroup> uniques = findUniqueGroupings(numWanted);
        List<PackageGroup> shortests = new LinkedList<>();

        // Sort 'uniques' by length of packageList.  Will likely need to write own comparator for this.
        Comparator<PackageGroup> compareByPackageGroupSize = (PackageGroup p1, PackageGroup p2) -> p1.getPackageList().size() - p2.getPackageList().size();
        Collections.sort(uniques, compareByPackageGroupSize);
        // Once sorting is done keep all groups that have the lowest number of items in packageList.
        int maxSize = -1;
        for(PackageGroup group : uniques){
            if(maxSize == -1) {  // Set maxSize to length of first PackageGroup.  Due to sort it will be the lowest value.
                maxSize = group.getPackageList().size();
            }

            if(group.getPackageList().size() == maxSize){
                shortests.add(group);
            }
        }

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
