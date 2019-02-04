public class ListsDemo {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("one");
        arrayList.add("two");
        arrayList.add("three");
        System.out.println(arrayList);
        System.out.println("Size = " + arrayList.size());
        arrayList.remove(1);
        System.out.println(arrayList);
        System.out.println("Size = " + arrayList.size());

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("one");
        linkedList.add("two");
        linkedList.add("three");
        System.out.println(linkedList);
        System.out.println("Size = " + linkedList.size());
        linkedList.remove(1);
        System.out.println(linkedList);
        System.out.println("Size = " + linkedList.size());
    }
}
