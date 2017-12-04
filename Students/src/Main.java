
public class Main {

    static Group groupA;
    static Group groupB;

    public static void initGroupA() {
        groupA = new Group("A");
        groupA.add(new Student("Ivanov"));
        groupA.add(new Student("Petrov"));
        groupA.add(new Student("Doe"));
        groupA.add(new Student("Sidorov"));
        groupA.add(new Student("Docker"));
    }

    public static void initGroupB() {
        groupB = new Group("B");
        groupB.add(new Student("Fibonacce"));
        groupB.add(new Student("Kasatik"));
        groupB.add(new Student("Enshteyn"));
        groupB.add(new Student("Pupkin"));
    }

    public static void main(String[] args) {
        /* INIT groups */
        initGroupA();
        initGroupB();

        /* Add new student to group */
        groupA.add(new Student("New Student"));

        /* Delete existing student from group */
        groupA.delete("Docker");

        /* Check existing student by surename*/
        String searchStudend = "Ivanov";
        System.out.println("Student " + searchStudend + " " + (groupA.contains(searchStudend) ? "exists" : "does not exists") + " in group " + groupA.getName());

        /* Merge two groups */
        groupA.addAll(groupB);

        /* Alphabetical sorting */
        groupA.sort();

        /* Check if group contains in other group */
        System.out.println("Group " + groupB.getName() + (groupA.containsAll(groupB) ? " is contains" : " not contains") + " in group " + groupA.getName());

        /* Check if groups are equals */
        System.out.println("Group " + groupA.getName() + " and " + groupB.getName() + (groupA.equal(groupB) ? " are equals" : " are not equals"));

        /* Clear group */
        groupB.clear();

        /* Print group data */
        groupA.print();
    }
}
