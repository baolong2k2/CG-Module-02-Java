package model.ulti;

import model.entity.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileUlti {
    public static void writeFileUser(String path, User user) {
        try (FileWriter fileWriter = new FileWriter(path, true);//bắt buộc phải có append true nếu ko nó sẽ xóa hết và ghi đè lên
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(user.getName() + ";" + user.getPassWord() + ";" + user.getPhoneNumber() + ";" + user.getEmail() + "\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void writeFileMultiverse(String path, Multiverse multiverse) {
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(multiverse.getName() + ";" +multiverse.getDetail() +"\n" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFileGalaxy(String path, Galaxy galaxy) {
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(galaxy.getName() + ";" +galaxy.getDetail() + ";" + galaxy.getGalaxyName()+ ";" +galaxy.getMultiverseId()+"\n" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFilePlanet(String path, Planet planet) {
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(planet.getName() + ";" +planet.getDetail() +";" + planet.getGalaxyName()+";" + planet.getMultiverseId()+ ";" +planet.getTypeOfCreature()+";" + planet.getEnvironment() + ";" + planet.getCivilization() + ";" + planet.getNamePlanet() +"\n" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFilePost(String path, Post post) {
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(post.getUser().getId() + ";" + post.getTitle() +";" + post.getContent() +"\n" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void writeFileComment(String path, Comment comment) {
        try (FileWriter fileWriter = new FileWriter(path, true);
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(+ comment.getPostId() +";" + comment.getDetail() + ";" +comment.getUser().getId() + "\n" );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeFileScientist(String path, Scientist user) {
        try (FileWriter fileWriter = new FileWriter(path, true);//bắt buộc phải có append true nếu ko nó sẽ xóa hết và ghi đè lên
             BufferedWriter writer = new BufferedWriter(fileWriter)) {
            writer.write(user.getName() + ";" + user.getPassWord() + ";" + user.getPhoneNumber() + ";" + user.getEmail() + user.getRankScientist() + ";" + user.getPermission() + "\n" );
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
