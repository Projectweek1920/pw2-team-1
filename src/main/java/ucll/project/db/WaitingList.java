package ucll.project.db;

import ucll.project.domain.user.User;

import java.util.Queue;

public class WaitingList {
    private Queue<User> easy,difficult;

    public WaitingList() {
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

    public void addUser(User user){
        if(user!=null){
            if(user.isDifficult()){
                difficult.add(user);
            }else{
                easy.add(user);
            }
        }else{
            throw new IllegalArgumentException("user is null");
        }
    }

    public User getNextDifficultUser(){
        User next = null;
        try {
            next = difficult.poll();
        }catch (Exception e){
            next = getNextEasyUser();
            System.out.println("Geen complexe studenten");
        }
        return next;
    }

    public User getNextEasyUser(){
        User next = null;
        try {
            next = easy.poll();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return next;

    }
}
