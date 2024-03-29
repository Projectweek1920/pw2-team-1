package ucll.project.db;

import ucll.project.domain.user.Gender;
import ucll.project.domain.user.SortById;
import ucll.project.domain.user.User;

import java.util.*;

public class WaitingList {
    private static WaitingList instance;
    private Deque<User> easy = new LinkedList<>();
    private Deque<User> difficult = new LinkedList<>();
    private ArrayList<User> aanDeBeurt = new ArrayList<>();

    private WaitingList() {
        User user1 = new User("OG1", "Quinten", "Geeraerts", "quiten.geeraerts@gmail.com", Gender.MALE);
        User user2 = new User("OG2", "Mathieu", "Broeckhoven", "mathieu.broeckhoven@telenet.be", Gender.MALE);
        User user3 = new User("OG3", "Matthias", "Veelaert", "matthias.veelaert@outlook.com", Gender.MALE);
        user3.setDifficult(true);
        User user4 = new User("OG4", "Mikkel", "Skovdal", "mikkel.skovdal@hotmail.be", Gender.MALE);
        user4.setDifficult(true);
        User user5 = new User("OG5", "Sinan", "Yolartiran", "sinan.yolartiran@skynet.be", Gender.MALE);
        easy.add(user1);
        easy.add(user2);
        difficult.add(user3);
        difficult.add(user4);
        easy.add(user5);
    }

    public static synchronized WaitingList getInstance() {
        if (instance == null) {
            instance = new WaitingList();
        }
        return instance;
    }

    public Deque<User> getEasy() {
        return easy;
    }

    public void setEasy(Deque<User> easy) {
        this.easy = easy;
    }

    public Deque<User> getDifficult() {
        return difficult;
    }

    public void setDifficult(Deque<User> difficult) {
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


    public void addUserAanDeBeurt(User user) {
        aanDeBeurt.add(user);
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

    public void removeNextEasyUser() {
        try {
            easy.poll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeNextDifficultUser() {
        try {
            difficult.poll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<User> getAanDeBeurt() {
        return aanDeBeurt;
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

    public void addDifficultAsFirst(User u) {
        this.difficult.addFirst(u);
    }

    public void removeUserAanDeBeurt(String loket) {
        User userr = null;
        System.out.println(loket);
        for (User u : aanDeBeurt) {
            if (u.getLoket().equals(loket)) {
                userr = u;
            }
        }
        aanDeBeurt.remove(userr);
    }

}

