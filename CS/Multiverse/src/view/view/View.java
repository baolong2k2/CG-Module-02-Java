package view.view;

import model.entity.Customer;
import model.ulti.FileReaderUtils;
import view.multiverse_view.UserView;

import java.util.ArrayList;
import java.util.List;

public class View {

    public static void main(String[] args) {
        UserView.getInstance().displayMainMenu();
    }
}