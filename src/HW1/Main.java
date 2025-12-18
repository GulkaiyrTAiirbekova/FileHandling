package HW1;

public class Main {
    public static void main(String [] args){
        UserRepository repo = new UserRepository("user.db");

        //Add users

        repo.add(new User(1, "Gulkaiyr", "gulkaiyr@example.com","pass123"));
        repo.add(new User(2, "Aikol", "aikol@example.com", " secret"));

        //Get all Users

        System.out.println("All users");
        repo.getAll().forEach(System.out::println);

        //Get user by ID
        System.out.println("Get user by ID 1: ");
        System.out.println(repo.getById(1));

        //Update user

        User updateUser = new User(1,"Gulkaiyr Taiirbekova","gu.t@example.com", "newpass");
        repo.update(updateUser);
        System.out.println("After update:");
        repo.getAll().forEach(System.out:: println);

        //Remove user

        repo.remove(2);
        System.out.println("After removing user with ID 2:");


    }
}
