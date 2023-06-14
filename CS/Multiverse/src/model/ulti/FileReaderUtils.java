package model.ulti;

import model.builder.GalaxyConcreteBuilder;
import model.builder.MultiverseConcreteBuilder;
import model.builder.PlanetConcreteBuilder;
import model.entity.*;
import model.service.PostService;
import model.service.UserService;

import java.io.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderUtils {
    public static List<String> readFile(String path) {
        List<String> objectList = new ArrayList<>();
        File file = new File(path);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) { //try with resource
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                objectList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return objectList;
    }

    public static List<Customer> fileReadingCustomer(String path) {
        List<String> propertyOfCustomerList = readFile(path);
        List<Customer> customerList = new ArrayList<>();
        final int INDEX_OF_NAME = 0;
        final int INDEX_OF_PHONE_NUMBER = 1;
        final int INDEX_OF_EMAIL = 2;
        final int INDEX_OF_PASSWORD = 3;
        for (String propertyOFCustomer : propertyOfCustomerList) {
            if (propertyOFCustomer.equals(propertyOfCustomerList.get(0))) {
                continue;
            }
            String[] properties = propertyOFCustomer.split(";");
            customerList.add(new Customer(
                    properties[INDEX_OF_NAME],
                    properties[INDEX_OF_PHONE_NUMBER],
                    properties[INDEX_OF_EMAIL],
                    properties[INDEX_OF_PASSWORD]
            ));
        }
        return customerList;
    }

    public static List<Scientist> fileReadingScientist(String path) {
        List<String> propertyOfScientistList = readFile(path);
        List<Scientist> scientistList = new ArrayList<>();
        final int INDEX_OF_NAME = 0;
        final int INDEX_OF_PHONE_NUMBER = 2;
        final int INDEX_OF_EMAIL = 3;
        final int INDEX_OF_PASSWORD = 1;
        final int INDEX_0F_RANK = 4;
        final int INDEX_OF_PERMISSION = 5;
        for (String propertyOFScientist : propertyOfScientistList) {
            if (propertyOFScientist.equals(propertyOfScientistList.get(0))) {
                continue;
            }
            String[] properties = propertyOFScientist.split(";");
            scientistList.add(new Scientist(
                    properties[INDEX_OF_NAME],
                    properties[INDEX_OF_PASSWORD],
                    properties[INDEX_OF_PHONE_NUMBER],
                    properties[INDEX_OF_EMAIL],
                    properties[INDEX_0F_RANK],
                    properties[INDEX_OF_PERMISSION]
            ));
        }
        return scientistList;
    }

    public static List<Multiverse> fileReadingMultiverse(String path) throws ParseException {
        List<String> propertyOFMultiverse = readFile(path);
        List<Multiverse> multiverseList = new ArrayList<>();
        final int INDEX_OF_NAME = 0;
        final int INDEX_OF_DETAIL = 1;
        for (String propertyOfMultiverse : propertyOFMultiverse) {
            if (propertyOfMultiverse.equals(propertyOFMultiverse.get(0))) {
                continue;
            }
            String[] properties = propertyOfMultiverse.split(";");
            multiverseList.add(new MultiverseConcreteBuilder()
                    .setNameMultiverse(properties[INDEX_OF_NAME])
                    .setDetail(properties[INDEX_OF_DETAIL])
                    .build());
        }
        return multiverseList;
    }

    public static List<Galaxy> fileReadingGalaxy(String path) throws ParseException {
        List<String> galaxyProperties = readFile(path);
        List<Galaxy> galaxyList = new ArrayList<>();

        final int INDEX_OF_NAME = 0;
        final int INDEX_OF_DETAIL = 1;
        final int INDEX_OF_GALAXY_NAME = 2;
        final int INDEX_OF_MULTIVERSE_ID = 3;

        // Bỏ qua header trong file
        galaxyProperties = galaxyProperties.subList(1, galaxyProperties.size());

        for (String galaxyProperty : galaxyProperties) {
            String[] properties = galaxyProperty.split(";");

            String name = properties[INDEX_OF_NAME];
            String detail = properties[INDEX_OF_DETAIL];
            String galaxyName = properties[INDEX_OF_GALAXY_NAME];
            int multiverseId = Integer.parseInt(properties[INDEX_OF_MULTIVERSE_ID]);

            Galaxy galaxy = new GalaxyConcreteBuilder()
                    .setName(name)
                    .setDetail(detail)
                    .setGalaxyName(galaxyName)
                    .setMultiverseId(multiverseId)
                    .build();
            galaxyList.add(galaxy);
        }

        return galaxyList;
    }
    public static List<Planet> fileReadingPlanet(String path) throws ParseException {
        List<String> planetProperties = readFile(path);
        List<Planet> planetList = new ArrayList<>();

        final int INDEX_OF_NAME = 0;
        final int INDEX_OF_DETAIL = 1;
        final int INDEX_OF_GALAXY_NAME = 2;
        final int INDEX_OF_MULTIVERSE_ID = 3;
        final int INDEX_OF_TYPE_OF_CREATURE = 4;
        final int INDEX_OF_ENVIRONMENT = 5;
        final int INDEX_OF_CIVILIZATION = 6;
        final int INDEX_OF_NAME_PLANET = 7;
        // Bỏ qua header trong file
        planetProperties = planetProperties.subList(1, planetProperties.size());

        for (String planetProperty : planetProperties) {
            String[] properties = planetProperty.split(";");

            String name = properties[INDEX_OF_NAME];
            String detail = properties[INDEX_OF_DETAIL];
            String galaxyName = properties[INDEX_OF_GALAXY_NAME];
            int multiverseId = Integer.parseInt(properties[INDEX_OF_MULTIVERSE_ID]);
            String typeOfCreature = properties[INDEX_OF_TYPE_OF_CREATURE];
            String environment = properties[INDEX_OF_ENVIRONMENT];
            String civilization = properties[INDEX_OF_CIVILIZATION];
            String namePlanet = properties[INDEX_OF_NAME_PLANET];

            Planet planet = new PlanetConcreteBuilder()
                    .setName(name)
                    .setDetail(detail)
                    .setGalaxyName(galaxyName)
                    .setMultiverseId(multiverseId)
                    .setTypeOfCreature(typeOfCreature)
                    .setEnvironment(environment)
                    .setCivilization(civilization)
                    .setNamePlanet(namePlanet)
                    .build();
            planetList.add(planet);
        }

        return planetList;
    }
    public static List<Post> fileReadingPost(String path) {
        List<String> propertyOfPostList = readFile(path);
        List<Post> postList = new ArrayList<>();
        final int INDEX_OF_USER_ID = 0;
        final int INDEX_OF_TITLE = 1;
        final int INDEX_OF_CONTENT = 2;
        for (String propertyOFPost : propertyOfPostList) {
            if (propertyOFPost.equals(propertyOfPostList.get(0))) {
                continue;
            }
            String[] properties = propertyOFPost.split(";");
            postList.add(new Post(
                    UserService.getInstance().getScientistById(INDEX_OF_USER_ID),
                    Integer.parseInt(properties[INDEX_OF_USER_ID]),
                    properties[INDEX_OF_TITLE],
                    properties[INDEX_OF_CONTENT]
            ));
        }
        return postList;
    }
    public static List<Comment> fileReadingComment(String path) {
        List<String> propertyOfCommentList = readFile(path);
        List<Comment> commentList = new ArrayList<>();
        final int INDEX_OF_POST_ID = 0;
        final int INDEX_OF_DETAIL = 1;
        final int INDEX_OF_USER_ID = 2;
        for (String propertyOFComment : propertyOfCommentList) {
            if (propertyOFComment.equals(propertyOfCommentList.get(0))) {
                continue;
            }
            String[] properties = propertyOFComment.split(";");
            commentList.add(new Comment(
                    Integer.parseInt(properties[INDEX_OF_POST_ID]),
                    properties[INDEX_OF_DETAIL],
                    UserService.getInstance().getCustomerById(INDEX_OF_USER_ID)
            ));
        }
        return commentList;
    }
}


