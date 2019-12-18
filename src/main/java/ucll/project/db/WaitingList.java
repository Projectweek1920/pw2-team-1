package ucll.project.db;

import ucll.project.domain.user.SortById;
import ucll.project.domain.user.User;

import java.util.*;

public class WaitingList {
    private static WaitingList instance;
    private Queue<User> easy = new LinkedList<>();
    private Queue<User> difficult = new LinkedList<>();
    private Queue<User> aanDeBeurt = new LinkedList<>();

    private WaitingList() {
    }


    public static synchronized WaitingList getInstance(){
        if(instance==null){
            instance = new WaitingList();
        }
        return instance;
    }

    public Queue<User> getEasy() {
        return easy;
    }

    public void setEasy(Queue<User> easy) {
        this.easy = easy;
    }

    public Queue<User> getDifficult() {
        return difficult;
    }

    public void setDifficult(Queue<User> difficult) {
        this.difficult = difficult;
    }

    public void addUser(User user) {
        if (user != null) {
            if (user.isDifficult()) {
                difficult.offer(user); //this doesn't work pls help xD c:
            } else {
                easy.offer(user);
            }
        } else {
            throw new IllegalArgumentException("user is null");
        }
    }

    public User getNextDifficultUser() {
        User next = null;
        try {
            next = difficult.poll();
        } catch (Exception e) {
            next = getNextEasyUser();
            System.out.println("Geen complexe studenten");
        }
        return next;
    }

    public User getNextEasyUser() {
        User next = null;
        try {
            next = easy.poll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return next;

    }
    //TODO Not like this xD
    public ArrayList<User> getAll() {
        ArrayList arrayList = new ArrayList();
        for (User user : easy) {
            arrayList.add(user);
        }
        for (User user : difficult) {
            arrayList.add(user);
        }
        Collections.sort(arrayList, new SortById());
        return arrayList;
    }
}
