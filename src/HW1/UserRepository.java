package HW1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IRepository<User>{

    private final String fileName;

    public UserRepository(String fileName){
        this.fileName = fileName;
    }

    @SuppressWarnings("unchecked")
    private List<User>readFromFile(){
        try (ObjectInputStream ios = new ObjectInputStream(new FileInputStream(fileName))){
            return (List<User>)  ios.readObject();
        } catch (FileNotFoundException e){
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void writeToFile(List<User> users){
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
            oos.writeObject(users);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    @Override
    public List<User> getAll(){
        return readFromFile();
    }
    @Override
    public User getById(int id){
        return readFromFile().stream()
                .filter(user ->user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void add(User user){
        List<User> users = readFromFile();
        users.add(user);
        writeToFile(users);
    }
    @Override
    public void update(User user){
        List<User> users = readFromFile();
        for(int i = 0; i< users.size(); i++){
            if(users.get(i).getId() == user.getId()){
                users.set(i,user);
                writeToFile(users);
                return;
            }
        }
        System.out.println("User with id" + user.getId() + " not found.");
    }

    @Override
    public void remove(int id){
        List<User> users = readFromFile();
        users.removeIf(user -> user.getId() == id);
        writeToFile(users);
    }
}
