import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Main {
    public static List<String> firstClients = List.of("Anya", "Sveta", "Olya", "Alexandra", "Ruslana", "Olesya", "Vika");

    public static void main(String[] args) {
        Deque<String> listServiceManicure = new ArrayDeque<>();

        System.out.println("\nВ очередь обслуживания; ");
        for (String firstClient : firstClients) {
            String status = (listServiceManicure.offer(firstClient))? "добавлена!" : "не добавлена!";
            System.out.print("- " + firstClient + " " + status + "\n");
        }

        System.out.println("\n---------\n");

        int countOK = 0;
        int countNoOk = 0;
        while (!listServiceManicure.isEmpty()) {
            String client = listServiceManicure.poll();
            System.out.println(client + " сделала новый маникюр");

            if (Math.random() < 0.5) { // проверка условия, которое срабатывает с 50% вероятностью
                listServiceManicure.offer("a friend of " + client);
                System.out.println("Подруга у " + client + ": a friend of " + client + " записалась");
                countOK++;
            } else {
                System.out.println("Подруга у " + client + " не записалась");
                countNoOk++;
            }
        }

        System.out.println("\n===========\nПришли новые клиенты: " + countOK);
        System.out.println("Отказались: " + countNoOk);
        System.out.println("-----\nВсего обслуживались: " + (firstClients.size() + countOK));

    }
}